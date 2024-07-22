package biz.smartengines.swig;

public class MrzEngineSessionHelpers {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected MrzEngineSessionHelpers(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(MrzEngineSessionHelpers mrzEngineSessionHelpers) {
        if (mrzEngineSessionHelpers == null) {
            return 0;
        }
        return mrzEngineSessionHelpers.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                mrzjniInterfaceJNI.delete_MrzEngineSessionHelpers(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public double get_optimal_aspect_ratio() {
        return mrzjniInterfaceJNI.MrzEngineSessionHelpers_get_optimal_aspect_ratio(this.swigCPtr, this);
    }

    public void set_optimal_aspect_ratio(double d) {
        mrzjniInterfaceJNI.MrzEngineSessionHelpers_set_optimal_aspect_ratio(this.swigCPtr, this, d);
    }

    public MrzEngineSessionHelpers() {
        this(mrzjniInterfaceJNI.new_MrzEngineSessionHelpers(), true);
    }
}
