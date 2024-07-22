package biz.smartengines.swig;

public class MrzOcrCharVector {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected MrzOcrCharVector(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(MrzOcrCharVector mrzOcrCharVector) {
        if (mrzOcrCharVector == null) {
            return 0;
        }
        return mrzOcrCharVector.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                mrzjniInterfaceJNI.delete_MrzOcrCharVector(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public MrzOcrCharVector() {
        this(mrzjniInterfaceJNI.new_MrzOcrCharVector__SWIG_0(), true);
    }

    public MrzOcrCharVector(long j) {
        this(mrzjniInterfaceJNI.new_MrzOcrCharVector__SWIG_1(j), true);
    }

    public long size() {
        return mrzjniInterfaceJNI.MrzOcrCharVector_size(this.swigCPtr, this);
    }

    public long capacity() {
        return mrzjniInterfaceJNI.MrzOcrCharVector_capacity(this.swigCPtr, this);
    }

    public void reserve(long j) {
        mrzjniInterfaceJNI.MrzOcrCharVector_reserve(this.swigCPtr, this, j);
    }

    public boolean isEmpty() {
        return mrzjniInterfaceJNI.MrzOcrCharVector_isEmpty(this.swigCPtr, this);
    }

    public void clear() {
        mrzjniInterfaceJNI.MrzOcrCharVector_clear(this.swigCPtr, this);
    }

    public void add(MrzOcrChar mrzOcrChar) {
        mrzjniInterfaceJNI.MrzOcrCharVector_add(this.swigCPtr, this, MrzOcrChar.getCPtr(mrzOcrChar), mrzOcrChar);
    }

    public MrzOcrChar get(int i) {
        return new MrzOcrChar(mrzjniInterfaceJNI.MrzOcrCharVector_get(this.swigCPtr, this, i), false);
    }

    public void set(int i, MrzOcrChar mrzOcrChar) {
        mrzjniInterfaceJNI.MrzOcrCharVector_set(this.swigCPtr, this, i, MrzOcrChar.getCPtr(mrzOcrChar), mrzOcrChar);
    }
}
