package biz.smartengines.swig;

public class StringVector {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected StringVector(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(StringVector stringVector) {
        if (stringVector == null) {
            return 0;
        }
        return stringVector.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                mrzjniInterfaceJNI.delete_StringVector(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public StringVector() {
        this(mrzjniInterfaceJNI.new_StringVector__SWIG_0(), true);
    }

    public StringVector(long j) {
        this(mrzjniInterfaceJNI.new_StringVector__SWIG_1(j), true);
    }

    public long size() {
        return mrzjniInterfaceJNI.StringVector_size(this.swigCPtr, this);
    }

    public long capacity() {
        return mrzjniInterfaceJNI.StringVector_capacity(this.swigCPtr, this);
    }

    public void reserve(long j) {
        mrzjniInterfaceJNI.StringVector_reserve(this.swigCPtr, this, j);
    }

    public void clear() {
        mrzjniInterfaceJNI.StringVector_clear(this.swigCPtr, this);
    }

    public void add(String str) {
        mrzjniInterfaceJNI.StringVector_add(this.swigCPtr, this, str);
    }

    public String get(int i) {
        return mrzjniInterfaceJNI.StringVector_get(this.swigCPtr, this, i);
    }

    public void set(int i, String str) {
        mrzjniInterfaceJNI.StringVector_set(this.swigCPtr, this, i, str);
    }
}
