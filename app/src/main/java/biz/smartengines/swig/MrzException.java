package biz.smartengines.swig;

public class MrzException extends Exception {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected MrzException(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(MrzException mrzException) {
        if (mrzException == null) {
            return 0;
        }
        return mrzException.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                mrzjniInterfaceJNI.delete_MrzException(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public String getMessage() {
        return what();
    }

    public MrzException(String str) {
        this(mrzjniInterfaceJNI.new_MrzException(str), true);
    }

    public String what() {
        return mrzjniInterfaceJNI.MrzException_what(this.swigCPtr, this);
    }
}
