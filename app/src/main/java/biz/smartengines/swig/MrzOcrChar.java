package biz.smartengines.swig;

public class MrzOcrChar {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected MrzOcrChar(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(MrzOcrChar mrzOcrChar) {
        if (mrzOcrChar == null) {
            return 0;
        }
        return mrzOcrChar.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                mrzjniInterfaceJNI.delete_MrzOcrChar(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public MrzOcrChar() {
        this(mrzjniInterfaceJNI.new_MrzOcrChar__SWIG_0(), true);
    }

    public MrzOcrChar(MrzOcrCharVariantVector mrzOcrCharVariantVector, boolean z, boolean z2, boolean z3) {
        this(mrzjniInterfaceJNI.new_MrzOcrChar__SWIG_1(MrzOcrCharVariantVector.getCPtr(mrzOcrCharVariantVector), mrzOcrCharVariantVector, z, z2, z3), true);
    }

    public MrzOcrCharVariantVector getOcrCharVariants() {
        return new MrzOcrCharVariantVector(mrzjniInterfaceJNI.MrzOcrChar_getOcrCharVariants(this.swigCPtr, this), false);
    }

    public boolean isHighlighted() {
        return mrzjniInterfaceJNI.MrzOcrChar_isHighlighted(this.swigCPtr, this);
    }

    public boolean isCorrected() {
        return mrzjniInterfaceJNI.MrzOcrChar_isCorrected(this.swigCPtr, this);
    }

    public boolean isFoundInDictionary() {
        return mrzjniInterfaceJNI.MrzOcrChar_isFoundInDictionary(this.swigCPtr, this);
    }

    public char GetChar() throws MrzException {
        return mrzjniInterfaceJNI.MrzOcrChar_GetChar(this.swigCPtr, this);
    }
}
