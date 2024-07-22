package biz.smartengines.swig;

public class MrzDate {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected MrzDate(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(MrzDate mrzDate) {
        if (mrzDate == null) {
            return 0;
        }
        return mrzDate.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                mrzjniInterfaceJNI.delete_MrzDate(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public MrzDate(int i, int i2, int i3) {
        this(mrzjniInterfaceJNI.new_MrzDate__SWIG_0(i, i2, i3), true);
    }

    public MrzDate(int i, int i2) {
        this(mrzjniInterfaceJNI.new_MrzDate__SWIG_1(i, i2), true);
    }

    public MrzDate(int i) {
        this(mrzjniInterfaceJNI.new_MrzDate__SWIG_2(i), true);
    }

    public MrzDate() {
        this(mrzjniInterfaceJNI.new_MrzDate__SWIG_3(), true);
    }

    public int getDay() {
        return mrzjniInterfaceJNI.MrzDate_getDay(this.swigCPtr, this);
    }

    public int getMonth() {
        return mrzjniInterfaceJNI.MrzDate_getMonth(this.swigCPtr, this);
    }

    public int getYear() {
        return mrzjniInterfaceJNI.MrzDate_getYear(this.swigCPtr, this);
    }

    public void setDay(int i) {
        mrzjniInterfaceJNI.MrzDate_setDay(this.swigCPtr, this, i);
    }

    public void setMonth(int i) {
        mrzjniInterfaceJNI.MrzDate_setMonth(this.swigCPtr, this, i);
    }

    public void setYear(int i) {
        mrzjniInterfaceJNI.MrzDate_setYear(this.swigCPtr, this, i);
    }

    public boolean isDayPresent() {
        return mrzjniInterfaceJNI.MrzDate_isDayPresent(this.swigCPtr, this);
    }

    public boolean isMonthPresent() {
        return mrzjniInterfaceJNI.MrzDate_isMonthPresent(this.swigCPtr, this);
    }

    public boolean isYearPresent() {
        return mrzjniInterfaceJNI.MrzDate_isYearPresent(this.swigCPtr, this);
    }

    public MrzDate(MrzDate mrzDate) {
        this(mrzjniInterfaceJNI.new_MrzDate__SWIG_4(getCPtr(mrzDate), mrzDate), true);
    }
}
