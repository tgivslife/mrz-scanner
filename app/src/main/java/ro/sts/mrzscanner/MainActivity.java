package ro.sts.mrzscanner;

import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.hardware.Camera;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

import biz.smartengines.swig.MrzEngine;
import biz.smartengines.swig.MrzEngineInternalSettings;
import biz.smartengines.swig.MrzEngineSessionHelpers;
import biz.smartengines.swig.MrzEngineSessionSettings;
import biz.smartengines.swig.MrzException;
import biz.smartengines.swig.MrzRect;
import biz.smartengines.swig.MrzRectMatrix;
import biz.smartengines.swig.MrzResult;
import biz.smartengines.swig.StringVector;

public class MainActivity extends AppCompatActivity implements MrzStreamReporter.MrzStreamListener, CompoundButton.OnCheckedChangeListener, SurfaceHolder.Callback, Camera.PreviewCallback {

    private static final String TAG = MainActivity.class.getName();

    public static final String PREF_MRZ_ENGINE_SETUP_COMPLETE = "mrz_engine_setup_complete";

    private boolean cameraReady = false;
    private boolean mrzEngineSetup;
    private boolean mrzEngineRunning;

    private AtomicBoolean mrzProcessed;
    private Handler handler;
    private Handler backgroundHandler;
    private HandlerThread backgroundHandlerThread;

    private double cameraAspectRatio = 6.0d;
    private MrzEngine mrzEngine;
    private MrzEngineSessionHelpers mrzEngineSessionHelpers;
    private MrzEngineSessionSettings mrzEngineSessionSettings;
    private MrzStreamReporter mrzStreamReporter;

    public Camera camera = null;
    private LinearLayout llMrzZone;
    private TextView line1, line2, line3;
    private RectView rectView;
    private SurfaceHolder surfaceHolder;
    private ToggleButton tglScan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        handler = new Handler();
        backgroundHandlerThread = new HandlerThread("BackgroundHandlerThread");
        backgroundHandlerThread.start();
        backgroundHandler = new Handler(backgroundHandlerThread.getLooper());

        mrzProcessed = new AtomicBoolean(false);

        SurfaceView mSurfaceView = findViewById(R.id.svCam);
        surfaceHolder = mSurfaceView.getHolder();
        surfaceHolder.addCallback(this);
        rectView = new RectView(this);

        tglScan = findViewById(R.id.tglScan);
        tglScan.setOnCheckedChangeListener(this);

        llMrzZone = findViewById(R.id.llMrzZone);
        line1 = findViewById(R.id.tvLine1);
        line2 = findViewById(R.id.tvLine2);
        line3 = findViewById(R.id.tvLine3);
        Typeface ocrbFont = Typeface.createFromAsset(getAssets(), "fonts/OcrB Regular.ttf");
        line1.setTypeface(ocrbFont);
        line2.setTypeface(ocrbFont);
        line3.setTypeface(ocrbFont);

        if (mrzEngineSetup) {
            mrzStreamReporter.setMrzStreamListener(this);
        } else {
            new MrzEngineSetup().execute();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();

        tglScan.setChecked(false);
        mrzEngineRunning = false;
        if (mrzEngineSetup) {
            try {
                mrzEngine.TerminateSession();
            } catch (MrzException e) {
                Log.e(TAG, "Cannot terminate mrz engine session", e);
            }
        }
    }

    @Override
    public void onSnapshotProcessed(MrzResult mrzResultValue, boolean processed) {
        Log.d(TAG, "Snapshot processed: " + processed);

        final MrzResult mrzResult = new MrzResult(mrzResultValue);
        if (processed) {
            handler.post(new Runnable() {
                @Override
                public void run() {
                    StringVector stringVector = mrzResult.getMrzLines();
                    if (stringVector != null && stringVector.size() > 0) {
                        for (int i = 0; i < stringVector.size(); i++) {
                            Log.d(TAG, stringVector.get(i));
                            switch (i) {
                                case 0:
                                    line1.setText(stringVector.get(i));
                                    line1.setVisibility(View.VISIBLE);
                                    break;
                                case 1:
                                    line2.setText(stringVector.get(i));
                                    line2.setVisibility(View.VISIBLE);
                                    break;
                                case 2:
                                    line3.setText(stringVector.get(i));
                                    line3.setVisibility(View.VISIBLE);
                                    break;
                            }
                        }
                        tglScan.setChecked(false);
                    }
                }
            });
        }
    }

    @Override
    public void onSnapshotRejected() {

    }

    @Override
    public void onSymbolRectsFound(MrzRectMatrix mrzRectMatrix) {

    }

    private void setupOcrData() {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);

        boolean engineSetupComplete = preferences.getBoolean(PREF_MRZ_ENGINE_SETUP_COMPLETE, false);

        if (!engineSetupComplete) {
            Log.d(TAG, "Setting up mrz engine data");
            setupOcrDataFolder("data");
            preferences.edit().putBoolean(PREF_MRZ_ENGINE_SETUP_COMPLETE, true).apply();
            Log.d(TAG, "Setting up mrz engine data done");
        }
    }

    private void setupOcrDataFolder(String ocrDataFolder) {
        AssetManager assetManager = getAssets();
        String flavorDir = "";
        int separatorIndex = ocrDataFolder.indexOf(File.separatorChar);
        if (separatorIndex > 0) {
            flavorDir = ocrDataFolder.substring(separatorIndex + 1);
        }
        String outputFolderPath = getApplicationContext().getFilesDir().getAbsolutePath() + File.separator + flavorDir;
        File outputFolder = new File(outputFolderPath);
        try {
            if (outputFolder.mkdir() || outputFolder.isDirectory()) {
                for (String file : Objects.requireNonNull(assetManager.list(ocrDataFolder))) {
                    String inputFile = ocrDataFolder + File.separator + file;
                    String outputFile = outputFolderPath + File.separator + file;
                    if (inputFile.lastIndexOf(46) > 0) {
                        setupOcrDataFile(inputFile, outputFile);
                    } else {
                        setupOcrDataFolder(inputFile);
                    }
                }
            }
        } catch (Exception e) {
            Log.e(TAG, "Failed to setup ocr data folder", e);
        }
    }

    private void setupOcrDataFile(String input, String output) throws IOException {
        InputStream in = getAssets().open(input);
        OutputStream out = new FileOutputStream(output);
        byte[] buffer = new byte[1024];
        while (true) {
            int length = in.read(buffer);
            if (length > 0) {
                out.write(buffer, 0, length);
            } else {
                in.close();
                out.close();
                return;
            }
        }
    }

    private void setupOcrSession() {
        Log.d(TAG, "Setting up mrz engine session");
        mrzEngineSessionSettings.set_mrp_support_enabled(true);
        mrzEngineSessionSettings.set_td1_support_enabled(true);
        mrzEngineSessionSettings.set_td2_support_enabled(true);
        mrzEngineSessionSettings.set_cnis_support_enabled(true);
        mrzEngineSessionSettings.set_m3z_support_enabled(true);
        mrzEngineSessionSettings.set_mrp_support_enabled(true);
        mrzEngineSessionSettings.set_td2_support_enabled(true);
        mrzEngineSessionSettings.set_anywhere_enabled(true);

        try {
            mrzEngine.InitializeSession(mrzStreamReporter, mrzEngineSessionHelpers, mrzEngineSessionSettings);
        } catch (MrzException e) {
            Log.e(TAG, "Failed to setup mrz engine session", e);
        }
        cameraAspectRatio = mrzEngineSessionHelpers.get_optimal_aspect_ratio();
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        toggleScan(b);
    }

    private void toggleScan(boolean isChecked) {
        Log.d(TAG, "Setting mrz engine scan running status to " + isChecked);
        mrzEngineRunning = isChecked;

        if (isChecked) {
            line1.setText("");
            line1.setVisibility(View.GONE);
            line2.setText("");
            line2.setVisibility(View.GONE);
            line3.setText("");
            line3.setVisibility(View.GONE);

            if (mrzEngineSetup) {
                setupOcrSession();
            }
            camera.setPreviewCallback(this);
            mrzProcessed.set(false);
        } else {
            camera.setPreviewCallback(null);
        }
    }

    @Override
    public void surfaceCreated(@NonNull SurfaceHolder surfaceHolder) {
        if (cameraReady || !needCameraPermission()) {
            initCamera();
        } else {
            requestCameraPermission();
        }
    }

    public void initCamera() {
        try {
            if (camera == null) {
                camera = Camera.open();
            }
            if (camera != null) {
                setCameraParams();
                camera.setPreviewDisplay(surfaceHolder);
                camera.startPreview();
                cameraReady = true;
            }
        } catch (IOException | RuntimeException e) {
            Log.d(TAG, "Cannot set preview surface: " + e.getMessage());
        }
    }

    private void setCameraParams() {
        Camera.Parameters params = this.camera.getParameters();
        List<String> focus = params.getSupportedFocusModes();
        String focusMode = "auto";
        if (focus.contains(focusMode)) {
            if (focus.contains("continuous-picture")) {
                focusMode = "continuous-picture";
            } else if (focus.contains("continuous-video")) {
                focusMode = "continuous-video";
            }
        } else if (focus.contains("infinity")) {
            focusMode = "infinity";
        } else if (focus.contains("fixed")) {
            focusMode = "fixed";
        }
        List<Camera.Size> sizes = params.getSupportedPreviewSizes();
        double best_ratio = ((double) getWindowManager().getDefaultDisplay().getHeight()) / ((double) getWindowManager().getDefaultDisplay().getWidth());
        Camera.Size previewSize = sizes.get(0);
        double previewRatioDiff = Math.abs((((double) previewSize.height) / ((double) previewSize.width)) - best_ratio);
        for (int i = 1; i < sizes.size(); i++) {
            Camera.Size tmp_size = sizes.get(i);
            double tmp_ratio_diff = Math.abs((((double) tmp_size.height) / ((double) tmp_size.width)) - best_ratio);
            if ((Math.abs(tmp_ratio_diff - previewRatioDiff) < 0.1d && tmp_size.width > previewSize.width) || tmp_ratio_diff < previewRatioDiff) {
                previewSize = tmp_size;
                previewRatioDiff = tmp_ratio_diff;
            }
        }
        params.setFocusMode(focusMode);
        params.setPreviewSize(previewSize.width, previewSize.height);
        this.camera.setParameters(params);
//        if (focus_mode == "auto") {
//            this.timer = new Timer();
//            this.timer.schedule(new Focus(), (long) this.timer_delay, (long) this.timer_period);
//            this.use_timer = true;
//        }
        rectView.SetPreviewSize(previewSize.width, previewSize.height);
    }

    public void cameraNotPermitted() {
        Toast.makeText(this, "Please allow CAMERA permission in Application Settings.", 1).show();
    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder surfaceHolder) {

    }

    public boolean needCameraPermission() {
        return ContextCompat.checkSelfPermission(this, "android.permission.CAMERA") != 0;
    }

    public void requestCameraPermission() {
        ActivityCompat.requestPermissions(this, new String[]{"android.permission.CAMERA"}, 1);
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case 1:
                if (grantResults.length > 0 && grantResults[0] == 0) {
                    initCamera();
                } else {
                    cameraNotPermitted();
                }
                break;
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    public void onPreviewFrame(final byte[] bytes, Camera camera) {
        Camera.Size size = camera.getParameters().getPreviewSize();
        final int previewWidth = size.width;
        final int previewHeight = size.height;

        backgroundHandler.post(new Runnable() {
            @Override
            public void run() {
                if (mrzEngineSetup && mrzEngineRunning) {
                    int roiWidth = previewWidth;
                    int roiHeight = previewHeight;
                    int roiY = 0;
                    MrzRect regionOfInterest = new MrzRect(0, roiY, roiWidth, roiHeight);
                    try {
                        mrzEngine.FeedUncompressedImageData(bytes, previewWidth, previewHeight, previewWidth, 1, regionOfInterest);
                    } catch (MrzException e) {
                        Log.e(TAG, "Failed to feed image to mrz engine", e);
                    }
                }
            }
        });
    }

    private class MrzEngineSetup extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... params) {
            setupOcrData();

            Log.d(TAG, "Setting up mrz engine");
            System.loadLibrary("mrzjniInterface");

            try {
                String mrzEngineSettingsPath = getApplicationContext().getFilesDir().getAbsolutePath() + File.separator + "mrzapi_engine.zip";
                File t = new File(mrzEngineSettingsPath);
                Log.d(TAG, "asd:" + t.exists() + " size:" + t.length());
                MrzEngineInternalSettings mrzEngineSettings = MrzEngineInternalSettings.createFromFilesystem(mrzEngineSettingsPath);
                mrzEngineSessionSettings = new MrzEngineSessionSettings();
                mrzEngineSessionSettings.set_should_postprocess(true);
                mrzEngineSessionHelpers = new MrzEngineSessionHelpers();
                mrzStreamReporter = new MrzStreamReporter();
                mrzStreamReporter.setMrzStreamListener(MainActivity.this);
                mrzEngine = new MrzEngine(mrzEngineSettings);
                mrzEngineSetup = true;
                Log.d(TAG, "Setting up mrz engine done");
            } catch (Exception e) {
                Log.e(TAG, "Failed to setup mrz engine", e);
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            if (mrzEngineSetup && mrzEngineRunning) {
                setupOcrSession();
            }
        }
    }
}