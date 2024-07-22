package biz.smartengines.swig;

public class MrzRect {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected MrzRect(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(MrzRect mrzRect) {
        if (mrzRect == null) {
            return 0;
        }
        return mrzRect.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                mrzjniInterfaceJNI.delete_MrzRect(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public MrzRect(int i, int i2, int i3, int i4) {
        this(mrzjniInterfaceJNI.new_MrzRect__SWIG_0(i, i2, i3, i4), true);
    }

    public MrzRect(int i, int i2, int i3) {
        this(mrzjniInterfaceJNI.new_MrzRect__SWIG_1(i, i2, i3), true);
    }

    public MrzRect(int i, int i2) {
        this(mrzjniInterfaceJNI.new_MrzRect__SWIG_2(i, i2), true);
    }

    public MrzRect(int i) {
        this(mrzjniInterfaceJNI.new_MrzRect__SWIG_3(i), true);
    }

    public MrzRect() {
        this(mrzjniInterfaceJNI.new_MrzRect__SWIG_4(), true);
    }

    public int getX() {
        return mrzjniInterfaceJNI.MrzRect_getX(this.swigCPtr, this);
    }

    public int getY() {
        return mrzjniInterfaceJNI.MrzRect_getY(this.swigCPtr, this);
    }

    public int getWidth() {
        return mrzjniInterfaceJNI.MrzRect_getWidth(this.swigCPtr, this);
    }

    public int getHeight() {
        return mrzjniInterfaceJNI.MrzRect_getHeight(this.swigCPtr, this);
    }

    public void setX(int i) {
        mrzjniInterfaceJNI.MrzRect_setX(this.swigCPtr, this, i);
    }

    public void setY(int i) {
        mrzjniInterfaceJNI.MrzRect_setY(this.swigCPtr, this, i);
    }

    public void setWidth(int i) {
        mrzjniInterfaceJNI.MrzRect_setWidth(this.swigCPtr, this, i);
    }

    public void setHeight(int i) {
        mrzjniInterfaceJNI.MrzRect_setHeight(this.swigCPtr, this, i);
    }
}
