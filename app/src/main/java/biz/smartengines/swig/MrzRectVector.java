package biz.smartengines.swig;

public class MrzRectVector {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected MrzRectVector(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(MrzRectVector mrzRectVector) {
        if (mrzRectVector == null) {
            return 0;
        }
        return mrzRectVector.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                mrzjniInterfaceJNI.delete_MrzRectVector(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public MrzRectVector() {
        this(mrzjniInterfaceJNI.new_MrzRectVector__SWIG_0(), true);
    }

    public MrzRectVector(long j) {
        this(mrzjniInterfaceJNI.new_MrzRectVector__SWIG_1(j), true);
    }

    public long size() {
        return mrzjniInterfaceJNI.MrzRectVector_size(this.swigCPtr, this);
    }

    public long capacity() {
        return mrzjniInterfaceJNI.MrzRectVector_capacity(this.swigCPtr, this);
    }

    public void reserve(long j) {
        mrzjniInterfaceJNI.MrzRectVector_reserve(this.swigCPtr, this, j);
    }

    public boolean isEmpty() {
        return mrzjniInterfaceJNI.MrzRectVector_isEmpty(this.swigCPtr, this);
    }

    public void clear() {
        mrzjniInterfaceJNI.MrzRectVector_clear(this.swigCPtr, this);
    }

    public void add(MrzRect mrzRect) {
        mrzjniInterfaceJNI.MrzRectVector_add(this.swigCPtr, this, MrzRect.getCPtr(mrzRect), mrzRect);
    }

    public MrzRect get(int i) {
        return new MrzRect(mrzjniInterfaceJNI.MrzRectVector_get(this.swigCPtr, this, i), false);
    }

    public void set(int i, MrzRect mrzRect) {
        mrzjniInterfaceJNI.MrzRectVector_set(this.swigCPtr, this, i, MrzRect.getCPtr(mrzRect), mrzRect);
    }
}
