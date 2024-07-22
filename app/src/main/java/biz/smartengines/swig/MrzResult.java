package biz.smartengines.swig;

public class MrzResult {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected MrzResult(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(MrzResult mrzResult) {
        if (mrzResult == null) {
            return 0;
        }
        return mrzResult.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                mrzjniInterfaceJNI.delete_MrzResult(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public MrzResult() {
        this(mrzjniInterfaceJNI.new_MrzResult__SWIG_0(), true);
    }

    public MrzField getDocType() {
        return new MrzField(mrzjniInterfaceJNI.MrzResult_getDocType(this.swigCPtr, this), false);
    }

    public MrzField getDocTypeCode() {
        return new MrzField(mrzjniInterfaceJNI.MrzResult_getDocTypeCode(this.swigCPtr, this), false);
    }

    public MrzField getFirstName() {
        return new MrzField(mrzjniInterfaceJNI.MrzResult_getFirstName(this.swigCPtr, this), false);
    }

    public MrzField getSecondName() {
        return new MrzField(mrzjniInterfaceJNI.MrzResult_getSecondName(this.swigCPtr, this), false);
    }

    public MrzField getSex() {
        return new MrzField(mrzjniInterfaceJNI.MrzResult_getSex(this.swigCPtr, this), false);
    }

    public MrzField getNationality() {
        return new MrzField(mrzjniInterfaceJNI.MrzResult_getNationality(this.swigCPtr, this), false);
    }

    public MrzField getOptData1() {
        return new MrzField(mrzjniInterfaceJNI.MrzResult_getOptData1(this.swigCPtr, this), false);
    }

    public MrzField getOptData2() {
        return new MrzField(mrzjniInterfaceJNI.MrzResult_getOptData2(this.swigCPtr, this), false);
    }

    public MrzField getDocNum() {
        return new MrzField(mrzjniInterfaceJNI.MrzResult_getDocNum(this.swigCPtr, this), false);
    }

    public MrzField getDocNumFormatted() {
        return new MrzField(mrzjniInterfaceJNI.MrzResult_getDocNumFormatted(this.swigCPtr, this), false);
    }

    public MrzField getCountry() {
        return new MrzField(mrzjniInterfaceJNI.MrzResult_getCountry(this.swigCPtr, this), false);
    }

    public MrzField getDepartmentCode() {
        return new MrzField(mrzjniInterfaceJNI.MrzResult_getDepartmentCode(this.swigCPtr, this), false);
    }

    public MrzDateField getBirthdate() {
        return new MrzDateField(mrzjniInterfaceJNI.MrzResult_getBirthdate(this.swigCPtr, this), false);
    }

    public MrzDateField getExpidate() {
        return new MrzDateField(mrzjniInterfaceJNI.MrzResult_getExpidate(this.swigCPtr, this), false);
    }

    public MrzDateField getIssuedate() {
        return new MrzDateField(mrzjniInterfaceJNI.MrzResult_getIssuedate(this.swigCPtr, this), false);
    }

    public StringVector getMrzLines() {
        return new StringVector(mrzjniInterfaceJNI.MrzResult_getMrzLines(this.swigCPtr, this), false);
    }

    public MrzOcrStringVector getMrzOcrLines() {
        return new MrzOcrStringVector(mrzjniInterfaceJNI.MrzResult_getMrzOcrLines(this.swigCPtr, this), false);
    }

    public MrzOcrChar getMrzCompositeCheckDigit() {
        return new MrzOcrChar(mrzjniInterfaceJNI.MrzResult_getMrzCompositeCheckDigit(this.swigCPtr, this), false);
    }

    public void setDocType(MrzField mrzField) {
        mrzjniInterfaceJNI.MrzResult_setDocType(this.swigCPtr, this, MrzField.getCPtr(mrzField), mrzField);
    }

    public void setDocTypeCode(MrzField mrzField) {
        mrzjniInterfaceJNI.MrzResult_setDocTypeCode(this.swigCPtr, this, MrzField.getCPtr(mrzField), mrzField);
    }

    public void setFirstName(MrzField mrzField) {
        mrzjniInterfaceJNI.MrzResult_setFirstName(this.swigCPtr, this, MrzField.getCPtr(mrzField), mrzField);
    }

    public void setSecondName(MrzField mrzField) {
        mrzjniInterfaceJNI.MrzResult_setSecondName(this.swigCPtr, this, MrzField.getCPtr(mrzField), mrzField);
    }

    public void setSex(MrzField mrzField) {
        mrzjniInterfaceJNI.MrzResult_setSex(this.swigCPtr, this, MrzField.getCPtr(mrzField), mrzField);
    }

    public void setNationality(MrzField mrzField) {
        mrzjniInterfaceJNI.MrzResult_setNationality(this.swigCPtr, this, MrzField.getCPtr(mrzField), mrzField);
    }

    public void setOptData1(MrzField mrzField) {
        mrzjniInterfaceJNI.MrzResult_setOptData1(this.swigCPtr, this, MrzField.getCPtr(mrzField), mrzField);
    }

    public void setOptData2(MrzField mrzField) {
        mrzjniInterfaceJNI.MrzResult_setOptData2(this.swigCPtr, this, MrzField.getCPtr(mrzField), mrzField);
    }

    public void setDocNum(MrzField mrzField) {
        mrzjniInterfaceJNI.MrzResult_setDocNum(this.swigCPtr, this, MrzField.getCPtr(mrzField), mrzField);
    }

    public void setDocNumFormatted(MrzField mrzField) {
        mrzjniInterfaceJNI.MrzResult_setDocNumFormatted(this.swigCPtr, this, MrzField.getCPtr(mrzField), mrzField);
    }

    public void setCountry(MrzField mrzField) {
        mrzjniInterfaceJNI.MrzResult_setCountry(this.swigCPtr, this, MrzField.getCPtr(mrzField), mrzField);
    }

    public void setDepartmentCode(MrzField mrzField) {
        mrzjniInterfaceJNI.MrzResult_setDepartmentCode(this.swigCPtr, this, MrzField.getCPtr(mrzField), mrzField);
    }

    public void setBirthdate(MrzDateField mrzDateField) {
        mrzjniInterfaceJNI.MrzResult_setBirthdate(this.swigCPtr, this, MrzDateField.getCPtr(mrzDateField), mrzDateField);
    }

    public void setExpidate(MrzDateField mrzDateField) {
        mrzjniInterfaceJNI.MrzResult_setExpidate(this.swigCPtr, this, MrzDateField.getCPtr(mrzDateField), mrzDateField);
    }

    public void setIssuedate(MrzDateField mrzDateField) {
        mrzjniInterfaceJNI.MrzResult_setIssuedate(this.swigCPtr, this, MrzDateField.getCPtr(mrzDateField), mrzDateField);
    }

    public void setMrzLines(StringVector stringVector) {
        mrzjniInterfaceJNI.MrzResult_setMrzLines(this.swigCPtr, this, StringVector.getCPtr(stringVector), stringVector);
    }

    public void setMrzOcrLines(MrzOcrStringVector mrzOcrStringVector) {
        mrzjniInterfaceJNI.MrzResult_setMrzOcrLines(this.swigCPtr, this, MrzOcrStringVector.getCPtr(mrzOcrStringVector), mrzOcrStringVector);
    }

    public void setMrzCompositeCheckDigit(MrzOcrChar mrzOcrChar) {
        mrzjniInterfaceJNI.MrzResult_setMrzCompositeCheckDigit(this.swigCPtr, this, MrzOcrChar.getCPtr(mrzOcrChar), mrzOcrChar);
    }

    public boolean hasCorrectCompositeChecksum() {
        return mrzjniInterfaceJNI.MrzResult_hasCorrectCompositeChecksum(this.swigCPtr, this);
    }

    public MrzResult(MrzResult mrzResult) {
        this(mrzjniInterfaceJNI.new_MrzResult__SWIG_1(getCPtr(mrzResult), mrzResult), true);
    }
}
