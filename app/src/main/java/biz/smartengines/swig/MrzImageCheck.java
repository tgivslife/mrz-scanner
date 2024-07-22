package biz.smartengines.swig;

public class MrzImageCheck {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected MrzImageCheck(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(MrzImageCheck mrzImageCheck) {
        if (mrzImageCheck == null) {
            return 0;
        }
        return mrzImageCheck.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                mrzjniInterfaceJNI.delete_MrzImageCheck(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public static boolean isRefocusNeeded(byte[] bArr, int i, int i2, int i3, int i4, int i5) throws MrzException {
        return mrzjniInterfaceJNI.MrzImageCheck_isRefocusNeeded(bArr, i, i2, i3, i4, i5);
    }

    public static int computeFocusConfidence(byte[] bArr, int i, int i2, int i3, int i4) throws MrzException {
        return mrzjniInterfaceJNI.MrzImageCheck_computeFocusConfidence(bArr, i, i2, i3, i4);
    }

    public static boolean isFlashNeeded(byte[] bArr, int i, int i2, int i3, int i4, int i5) throws MrzException {
        return mrzjniInterfaceJNI.MrzImageCheck_isFlashNeeded(bArr, i, i2, i3, i4, i5);
    }

    public static float computeFlashConfidence(byte[] bArr, int i, int i2, int i3, int i4) throws MrzException {
        return mrzjniInterfaceJNI.MrzImageCheck_computeFlashConfidence(bArr, i, i2, i3, i4);
    }

    public MrzImageCheck() {
        this(mrzjniInterfaceJNI.new_MrzImageCheck(), true);
    }
}
