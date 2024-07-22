package biz.smartengines.swig;

public class MrzEngineInternalSettings {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected MrzEngineInternalSettings(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(MrzEngineInternalSettings mrzEngineInternalSettings) {
        if (mrzEngineInternalSettings == null) {
            return 0;
        }
        return mrzEngineInternalSettings.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                mrzjniInterfaceJNI.delete_MrzEngineInternalSettings(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public static MrzEngineInternalSettings createFromFilesystem(String str) throws MrzException {
        long MrzEngineInternalSettings_createFromFilesystem = mrzjniInterfaceJNI.MrzEngineInternalSettings_createFromFilesystem(str);
        if (MrzEngineInternalSettings_createFromFilesystem == 0) {
            return null;
        }
        return new MrzEngineInternalSettings(MrzEngineInternalSettings_createFromFilesystem, false);
    }

    public static MrzEngineInternalSettings createFromZipBuffer(String str) throws MrzException {
        long MrzEngineInternalSettings_createFromZipBuffer = mrzjniInterfaceJNI.MrzEngineInternalSettings_createFromZipBuffer(str);
        if (MrzEngineInternalSettings_createFromZipBuffer == 0) {
            return null;
        }
        return new MrzEngineInternalSettings(MrzEngineInternalSettings_createFromZipBuffer, false);
    }
}
