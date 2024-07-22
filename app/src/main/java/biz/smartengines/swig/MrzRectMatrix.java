package biz.smartengines.swig;

public class MrzRectMatrix {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected MrzRectMatrix(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(MrzRectMatrix mrzRectMatrix) {
        if (mrzRectMatrix == null) {
            return 0;
        }
        return mrzRectMatrix.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                mrzjniInterfaceJNI.delete_MrzRectMatrix(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public MrzRectMatrix() {
        this(mrzjniInterfaceJNI.new_MrzRectMatrix__SWIG_0(), true);
    }

    public MrzRectMatrix(long j) {
        this(mrzjniInterfaceJNI.new_MrzRectMatrix__SWIG_1(j), true);
    }

    public long size() {
        return mrzjniInterfaceJNI.MrzRectMatrix_size(this.swigCPtr, this);
    }

    public long capacity() {
        return mrzjniInterfaceJNI.MrzRectMatrix_capacity(this.swigCPtr, this);
    }

    public void reserve(long j) {
        mrzjniInterfaceJNI.MrzRectMatrix_reserve(this.swigCPtr, this, j);
    }

    public boolean isEmpty() {
        return mrzjniInterfaceJNI.MrzRectMatrix_isEmpty(this.swigCPtr, this);
    }

    public void clear() {
        mrzjniInterfaceJNI.MrzRectMatrix_clear(this.swigCPtr, this);
    }

    public void add(MrzRectVector mrzRectVector) {
        mrzjniInterfaceJNI.MrzRectMatrix_add(this.swigCPtr, this, MrzRectVector.getCPtr(mrzRectVector), mrzRectVector);
    }

    public MrzRectVector get(int i) {
        return new MrzRectVector(mrzjniInterfaceJNI.MrzRectMatrix_get(this.swigCPtr, this, i), false);
    }

    public void set(int i, MrzRectVector mrzRectVector) {
        mrzjniInterfaceJNI.MrzRectMatrix_set(this.swigCPtr, this, i, MrzRectVector.getCPtr(mrzRectVector), mrzRectVector);
    }
}
