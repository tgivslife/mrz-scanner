package biz.smartengines.swig;

public class MrzEngine {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected MrzEngine(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(MrzEngine mrzEngine) {
        if (mrzEngine == null) {
            return 0;
        }
        return mrzEngine.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                mrzjniInterfaceJNI.delete_MrzEngine(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public MrzEngine(MrzEngineInternalSettings mrzEngineInternalSettings) throws MrzException {
        this(mrzjniInterfaceJNI.new_MrzEngine(MrzEngineInternalSettings.getCPtr(mrzEngineInternalSettings), mrzEngineInternalSettings), true);
    }

    public void InitializeSession(StreamReporterInterface streamReporterInterface, MrzEngineSessionHelpers mrzEngineSessionHelpers, MrzEngineSessionSettings mrzEngineSessionSettings) throws MrzException {
        mrzjniInterfaceJNI.MrzEngine_InitializeSession__SWIG_0(this.swigCPtr, this, StreamReporterInterface.getCPtr(streamReporterInterface), streamReporterInterface, MrzEngineSessionHelpers.getCPtr(mrzEngineSessionHelpers), mrzEngineSessionHelpers, MrzEngineSessionSettings.getCPtr(mrzEngineSessionSettings), mrzEngineSessionSettings);
    }

    public void InitializeSession(StreamReporterInterface streamReporterInterface, MrzEngineSessionHelpers mrzEngineSessionHelpers) throws MrzException {
        mrzjniInterfaceJNI.MrzEngine_InitializeSession__SWIG_1(this.swigCPtr, this, StreamReporterInterface.getCPtr(streamReporterInterface), streamReporterInterface, MrzEngineSessionHelpers.getCPtr(mrzEngineSessionHelpers), mrzEngineSessionHelpers);
    }

    public void InitializeSession(StreamReporterInterface streamReporterInterface) throws MrzException {
        mrzjniInterfaceJNI.MrzEngine_InitializeSession__SWIG_2(this.swigCPtr, this, StreamReporterInterface.getCPtr(streamReporterInterface), streamReporterInterface);
    }

    public void TerminateSession() throws MrzException {
        mrzjniInterfaceJNI.MrzEngine_TerminateSession(this.swigCPtr, this);
    }

    public void FeedUncompressedImageData(byte[] bArr, int i, int i2, int i3, int i4, MrzRect mrzRect, ImageOrientation imageOrientation) throws MrzException {
        mrzjniInterfaceJNI.MrzEngine_FeedUncompressedImageData__SWIG_0(this.swigCPtr, this, bArr, i, i2, i3, i4, MrzRect.getCPtr(mrzRect), mrzRect, imageOrientation.swigValue());
    }

    public void FeedUncompressedImageData(byte[] bArr, int i, int i2, int i3, int i4, MrzRect mrzRect) throws MrzException {
        mrzjniInterfaceJNI.MrzEngine_FeedUncompressedImageData__SWIG_1(this.swigCPtr, this, bArr, i, i2, i3, i4, MrzRect.getCPtr(mrzRect), mrzRect);
    }

    public void FeedUncompressedYUVImageData(byte[] bArr, int i, int i2, int i3, MrzRect mrzRect, ImageOrientation imageOrientation) throws MrzException {
        mrzjniInterfaceJNI.MrzEngine_FeedUncompressedYUVImageData__SWIG_0(this.swigCPtr, this, bArr, i, i2, i3, MrzRect.getCPtr(mrzRect), mrzRect, imageOrientation.swigValue());
    }

    public void FeedUncompressedYUVImageData(byte[] bArr, int i, int i2, int i3, MrzRect mrzRect) throws MrzException {
        mrzjniInterfaceJNI.MrzEngine_FeedUncompressedYUVImageData__SWIG_1(this.swigCPtr, this, bArr, i, i2, i3, MrzRect.getCPtr(mrzRect), mrzRect);
    }

    public void FeedImageFile(String str, ImageOrientation imageOrientation) throws MrzException {
        mrzjniInterfaceJNI.MrzEngine_FeedImageFile__SWIG_0(this.swigCPtr, this, str, imageOrientation.swigValue());
    }

    public void FeedImageFile(String str) throws MrzException {
        mrzjniInterfaceJNI.MrzEngine_FeedImageFile__SWIG_1(this.swigCPtr, this, str);
    }

    public static final class ImageOrientation {
        public static final ImageOrientation InvertedLandscape = new ImageOrientation("InvertedLandscape");
        public static final ImageOrientation InvertedPortrait = new ImageOrientation("InvertedPortrait");
        public static final ImageOrientation Landscape = new ImageOrientation("Landscape");
        public static final ImageOrientation Portrait = new ImageOrientation("Portrait");
        private static int swigNext = 0;
        private static ImageOrientation[] swigValues = {Landscape, Portrait, InvertedLandscape, InvertedPortrait};
        private final String swigName;
        private final int swigValue;

        public final int swigValue() {
            return this.swigValue;
        }

        public String toString() {
            return this.swigName;
        }

        public static ImageOrientation swigToEnum(int i) {
            if (i < swigValues.length && i >= 0 && swigValues[i].swigValue == i) {
                return swigValues[i];
            }
            for (int i2 = 0; i2 < swigValues.length; i2++) {
                if (swigValues[i2].swigValue == i) {
                    return swigValues[i2];
                }
            }
            throw new IllegalArgumentException("No enum " + ImageOrientation.class + " with value " + i);
        }

        private ImageOrientation(String str) {
            this.swigName = str;
            int i = swigNext;
            swigNext = i + 1;
            this.swigValue = i;
        }

        private ImageOrientation(String str, int i) {
            this.swigName = str;
            this.swigValue = i;
            swigNext = i + 1;
        }

        private ImageOrientation(String str, ImageOrientation imageOrientation) {
            this.swigName = str;
            this.swigValue = imageOrientation.swigValue;
            swigNext = this.swigValue + 1;
        }
    }
}
