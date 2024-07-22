package biz.smartengines.swig;

public class MrzOcrStringVector {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected MrzOcrStringVector(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(MrzOcrStringVector mrzOcrStringVector) {
        if (mrzOcrStringVector == null) {
            return 0;
        }
        return mrzOcrStringVector.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                mrzjniInterfaceJNI.delete_MrzOcrStringVector(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public MrzOcrStringVector() {
        this(mrzjniInterfaceJNI.new_MrzOcrStringVector__SWIG_0(), true);
    }

    public MrzOcrStringVector(long j) {
        this(mrzjniInterfaceJNI.new_MrzOcrStringVector__SWIG_1(j), true);
    }

    public long size() {
        return mrzjniInterfaceJNI.MrzOcrStringVector_size(this.swigCPtr, this);
    }

    public long capacity() {
        return mrzjniInterfaceJNI.MrzOcrStringVector_capacity(this.swigCPtr, this);
    }

    public void reserve(long j) {
        mrzjniInterfaceJNI.MrzOcrStringVector_reserve(this.swigCPtr, this, j);
    }

    public boolean isEmpty() {
        return mrzjniInterfaceJNI.MrzOcrStringVector_isEmpty(this.swigCPtr, this);
    }

    public void clear() {
        mrzjniInterfaceJNI.MrzOcrStringVector_clear(this.swigCPtr, this);
    }

    public void add(MrzOcrString mrzOcrString) {
        mrzjniInterfaceJNI.MrzOcrStringVector_add(this.swigCPtr, this, MrzOcrString.getCPtr(mrzOcrString), mrzOcrString);
    }

    public MrzOcrString get(int i) {
        return new MrzOcrString(mrzjniInterfaceJNI.MrzOcrStringVector_get(this.swigCPtr, this, i), false);
    }

    public void set(int i, MrzOcrString mrzOcrString) {
        mrzjniInterfaceJNI.MrzOcrStringVector_set(this.swigCPtr, this, i, MrzOcrString.getCPtr(mrzOcrString), mrzOcrString);
    }
}
