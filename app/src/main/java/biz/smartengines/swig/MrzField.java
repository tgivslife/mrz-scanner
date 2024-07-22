package biz.smartengines.swig;

public class MrzField {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected MrzField(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(MrzField mrzField) {
        if (mrzField == null) {
            return 0;
        }
        return mrzField.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                mrzjniInterfaceJNI.delete_MrzField(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public MrzField() {
        this(mrzjniInterfaceJNI.new_MrzField__SWIG_0(), true);
    }

    public MrzField(String str, boolean z, double d) {
        this(mrzjniInterfaceJNI.new_MrzField__SWIG_1(str, z, d), true);
    }

    public MrzField(String str, boolean z) {
        this(mrzjniInterfaceJNI.new_MrzField__SWIG_2(str, z), true);
    }

    public MrzField(String str) {
        this(mrzjniInterfaceJNI.new_MrzField__SWIG_3(str), true);
    }

    public MrzField(String str, boolean z, double d, MrzOcrString mrzOcrString, MrzOcrChar mrzOcrChar) {
        this(mrzjniInterfaceJNI.new_MrzField__SWIG_4(str, z, d, MrzOcrString.getCPtr(mrzOcrString), mrzOcrString, MrzOcrChar.getCPtr(mrzOcrChar), mrzOcrChar), true);
    }

    public String getAsString() {
        return mrzjniInterfaceJNI.MrzField_getAsString(this.swigCPtr, this);
    }

    public boolean isAccepted() {
        return mrzjniInterfaceJNI.MrzField_isAccepted(this.swigCPtr, this);
    }

    public double getConfidence() {
        return mrzjniInterfaceJNI.MrzField_getConfidence(this.swigCPtr, this);
    }

    public MrzOcrString getOcrString() {
        return new MrzOcrString(mrzjniInterfaceJNI.MrzField_getOcrString(this.swigCPtr, this), false);
    }

    public int calculateChecksum() throws MrzException {
        return mrzjniInterfaceJNI.MrzField_calculateChecksum(this.swigCPtr, this);
    }

    public boolean hasChecksumOcrChar() {
        return mrzjniInterfaceJNI.MrzField_hasChecksumOcrChar(this.swigCPtr, this);
    }

    public MrzOcrChar getChecksumOcrChar() {
        return new MrzOcrChar(mrzjniInterfaceJNI.MrzField_getChecksumOcrChar(this.swigCPtr, this), false);
    }

    public boolean hasCorrectChecksum() {
        return mrzjniInterfaceJNI.MrzField_hasCorrectChecksum(this.swigCPtr, this);
    }
}
