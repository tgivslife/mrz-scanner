package biz.smartengines.swig;

public class MrzOcrString {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected MrzOcrString(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(MrzOcrString mrzOcrString) {
        if (mrzOcrString == null) {
            return 0;
        }
        return mrzOcrString.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                mrzjniInterfaceJNI.delete_MrzOcrString(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public MrzOcrString() {
        this(mrzjniInterfaceJNI.new_MrzOcrString__SWIG_0(), true);
    }

    public MrzOcrString(MrzOcrCharVector mrzOcrCharVector) {
        this(mrzjniInterfaceJNI.new_MrzOcrString__SWIG_1(MrzOcrCharVector.getCPtr(mrzOcrCharVector), mrzOcrCharVector), true);
    }

    public MrzOcrCharVector getOcrChars() {
        return new MrzOcrCharVector(mrzjniInterfaceJNI.MrzOcrString_getOcrChars(this.swigCPtr, this), false);
    }
}
