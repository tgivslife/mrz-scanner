package ro.sts.mrzscanner;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;

import androidx.core.view.InputDeviceCompat;

import java.util.ArrayList;
import java.util.List;

import biz.smartengines.swig.MrzRectMatrix;

public class RectView extends View {

    private int canvasHeight = 0;
    private int canvasWidth = 0;
    private Paint paint = new Paint();
    private int previewHeight = 0;
    private int previewWidth = 0;
    private List<RectF> rects = new ArrayList();
    private int zoneX = 0;
    private int zoneY = 0;

    public RectView(Context context) {
        super(context);
        this.paint.setColor(InputDeviceCompat.SOURCE_ANY);
        setBackgroundColor(Color.argb(0, 0, 0, 0));
    }

    public void SetZone(int zone_x2, int zone_y2) {
        this.zoneX = zone_x2;
        this.zoneY = zone_y2;
    }

    public void SetPreviewSize(int preview_w2, int preview_h2) {
        this.previewWidth = preview_w2;
        this.previewHeight = preview_h2;
    }

    public int getCanvasWidth() {
        return this.canvasWidth;
    }

    public int getCanvasHeight() {
        return this.canvasHeight;
    }

    public void Clear() {
        this.rects.clear();
    }

    public void SetRects(MrzRectMatrix mrzRectMatrix) {
        Clear();
        if (mrzRectMatrix != null) {
            for (int i = 0; ((long) i) < mrzRectMatrix.size(); i++) {
                for (int j = 0; ((long) j) < mrzRectMatrix.get(i).size(); j++) {
                    float l = ((((float) this.canvasWidth) * ((float) mrzRectMatrix.get(i).get(j).getX())) / ((float) this.previewWidth)) + ((float) this.zoneX);
                    float t = ((((float) this.canvasHeight) * ((float) mrzRectMatrix.get(i).get(j).getY())) / ((float) this.previewHeight)) + ((float) this.zoneY);
                    this.rects.add(new RectF(l, t, l + ((((float) this.canvasWidth) * ((float) mrzRectMatrix.get(i).get(j).getWidth())) / ((float) this.previewWidth)), t + ((((float) this.canvasHeight) * ((float) mrzRectMatrix.get(i).get(j).getHeight())) / ((float) this.previewHeight))));
                }
            }
        }
    }

    public void onDraw(Canvas canvas) {
        for (int i = 0; i < this.rects.size(); i++) {
            RectF rect = this.rects.get(i);
            canvas.drawLine(rect.left, rect.top, rect.right, rect.top, this.paint);
            canvas.drawLine(rect.left, rect.top, rect.left, rect.bottom, this.paint);
            canvas.drawLine(rect.right, rect.top, rect.right, rect.bottom, this.paint);
            canvas.drawLine(rect.left, rect.bottom, rect.right, rect.bottom, this.paint);
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        this.canvasWidth = w;
        this.canvasHeight = h;
    }
}
