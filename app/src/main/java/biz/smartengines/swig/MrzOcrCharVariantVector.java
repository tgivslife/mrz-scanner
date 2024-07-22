package biz.smartengines.swig;

public class MrzOcrCharVariantVector {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected MrzOcrCharVariantVector(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(MrzOcrCharVariantVector mrzOcrCharVariantVector) {
        if (mrzOcrCharVariantVector == null) {
            return 0;
        }
        return mrzOcrCharVariantVector.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                mrzjniInterfaceJNI.delete_MrzOcrCharVariantVector(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public MrzOcrCharVariantVector() {
        this(mrzjniInterfaceJNI.new_MrzOcrCharVariantVector__SWIG_0(), true);
    }

    public MrzOcrCharVariantVector(long j) {
        this(mrzjniInterfaceJNI.new_MrzOcrCharVariantVector__SWIG_1(j), true);
    }

    public long size() {
        return mrzjniInterfaceJNI.MrzOcrCharVariantVector_size(this.swigCPtr, this);
    }

    public long capacity() {
        return mrzjniInterfaceJNI.MrzOcrCharVariantVector_capacity(this.swigCPtr, this);
    }

    public void reserve(long j) {
        mrzjniInterfaceJNI.MrzOcrCharVariantVector_reserve(this.swigCPtr, this, j);
    }

    public boolean isEmpty() {
        return mrzjniInterfaceJNI.MrzOcrCharVariantVector_isEmpty(this.swigCPtr, this);
    }

    public void clear() {
        mrzjniInterfaceJNI.MrzOcrCharVariantVector_clear(this.swigCPtr, this);
    }

    public void add(MrzOcrCharVariant mrzOcrCharVariant) {
        mrzjniInterfaceJNI.MrzOcrCharVariantVector_add(this.swigCPtr, this, MrzOcrCharVariant.getCPtr(mrzOcrCharVariant), mrzOcrCharVariant);
    }

    public MrzOcrCharVariant get(int i) {
        return new MrzOcrCharVariant(mrzjniInterfaceJNI.MrzOcrCharVariantVector_get(this.swigCPtr, this, i), false);
    }

    public void set(int i, MrzOcrCharVariant mrzOcrCharVariant) {
        mrzjniInterfaceJNI.MrzOcrCharVariantVector_set(this.swigCPtr, this, i, MrzOcrCharVariant.getCPtr(mrzOcrCharVariant), mrzOcrCharVariant);
    }
}
