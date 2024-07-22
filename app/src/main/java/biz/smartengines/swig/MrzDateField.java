package biz.smartengines.swig;

public class MrzDateField extends MrzField {
    private transient long swigCPtr;

    protected MrzDateField(long j, boolean z) {
        super(mrzjniInterfaceJNI.MrzDateField_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    protected static long getCPtr(MrzDateField mrzDateField) {
        if (mrzDateField == null) {
            return 0;
        }
        return mrzDateField.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                mrzjniInterfaceJNI.delete_MrzDateField(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
        super.delete();
    }

    public MrzDateField() {
        this(mrzjniInterfaceJNI.new_MrzDateField__SWIG_0(), true);
    }

    public MrzDateField(MrzDate mrzDate, boolean z, double d) {
        this(mrzjniInterfaceJNI.new_MrzDateField__SWIG_1(MrzDate.getCPtr(mrzDate), mrzDate, z, d), true);
    }

    public MrzDateField(MrzDate mrzDate, boolean z) {
        this(mrzjniInterfaceJNI.new_MrzDateField__SWIG_2(MrzDate.getCPtr(mrzDate), mrzDate, z), true);
    }

    public MrzDateField(MrzDate mrzDate) {
        this(mrzjniInterfaceJNI.new_MrzDateField__SWIG_3(MrzDate.getCPtr(mrzDate), mrzDate), true);
    }

    public MrzDateField(MrzDate mrzDate, boolean z, double d, MrzOcrString mrzOcrString, MrzOcrChar mrzOcrChar) {
        this(mrzjniInterfaceJNI.new_MrzDateField__SWIG_4(MrzDate.getCPtr(mrzDate), mrzDate, z, d, MrzOcrString.getCPtr(mrzOcrString), mrzOcrString, MrzOcrChar.getCPtr(mrzOcrChar), mrzOcrChar), true);
    }

    public MrzDate getAsMrzDate() {
        return new MrzDate(mrzjniInterfaceJNI.MrzDateField_getAsMrzDate(this.swigCPtr, this), false);
    }
}
