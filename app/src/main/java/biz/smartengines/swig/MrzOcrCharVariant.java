package biz.smartengines.swig;

public class MrzOcrCharVariant {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected MrzOcrCharVariant(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(MrzOcrCharVariant mrzOcrCharVariant) {
        if (mrzOcrCharVariant == null) {
            return 0;
        }
        return mrzOcrCharVariant.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                mrzjniInterfaceJNI.delete_MrzOcrCharVariant(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public MrzOcrCharVariant() {
        this(mrzjniInterfaceJNI.new_MrzOcrCharVariant__SWIG_0(), true);
    }

    public MrzOcrCharVariant(char c, double d) {
        this(mrzjniInterfaceJNI.new_MrzOcrCharVariant__SWIG_1(c, d), true);
    }

    public char getCharacter() {
        return mrzjniInterfaceJNI.MrzOcrCharVariant_getCharacter(this.swigCPtr, this);
    }

    public double getConfidence() {
        return mrzjniInterfaceJNI.MrzOcrCharVariant_getConfidence(this.swigCPtr, this);
    }
}
