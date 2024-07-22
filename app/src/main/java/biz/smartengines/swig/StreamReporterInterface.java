package biz.smartengines.swig;

public class StreamReporterInterface {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected StreamReporterInterface(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(StreamReporterInterface streamReporterInterface) {
        if (streamReporterInterface == null) {
            return 0;
        }
        return streamReporterInterface.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                mrzjniInterfaceJNI.delete_StreamReporterInterface(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    /* access modifiers changed from: protected */
    public void swigDirectorDisconnect() {
        this.swigCMemOwn = false;
        delete();
    }

    public void swigReleaseOwnership() {
        this.swigCMemOwn = false;
        mrzjniInterfaceJNI.StreamReporterInterface_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        mrzjniInterfaceJNI.StreamReporterInterface_change_ownership(this, this.swigCPtr, true);
    }

    public void SymbolRectsFound(MrzRectMatrix mrzRectMatrix) {
        if (getClass() == StreamReporterInterface.class) {
            mrzjniInterfaceJNI.StreamReporterInterface_SymbolRectsFound(this.swigCPtr, this, MrzRectMatrix.getCPtr(mrzRectMatrix), mrzRectMatrix);
            return;
        }
        mrzjniInterfaceJNI.StreamReporterInterface_SymbolRectsFoundSwigExplicitStreamReporterInterface(this.swigCPtr, this, MrzRectMatrix.getCPtr(mrzRectMatrix), mrzRectMatrix);
    }

    public void SymbolRectsFoundAfterSnapshotProcessed(MrzRectMatrix mrzRectMatrix) {
        if (getClass() == StreamReporterInterface.class) {
            mrzjniInterfaceJNI.StreamReporterInterface_SymbolRectsFoundAfterSnapshotProcessed(this.swigCPtr, this, MrzRectMatrix.getCPtr(mrzRectMatrix), mrzRectMatrix);
            return;
        }
        mrzjniInterfaceJNI.StreamReporterInterface_SymbolRectsFoundAfterSnapshotProcessedSwigExplicitStreamReporterInterface(this.swigCPtr, this, MrzRectMatrix.getCPtr(mrzRectMatrix), mrzRectMatrix);
    }

    public void SnapshotRejected() {
        if (getClass() == StreamReporterInterface.class) {
            mrzjniInterfaceJNI.StreamReporterInterface_SnapshotRejected__SWIG_0(this.swigCPtr, this);
        } else {
            mrzjniInterfaceJNI.StreamReporterInterface_SnapshotRejectedSwigExplicitStreamReporterInterface__SWIG_0(this.swigCPtr, this);
        }
    }

    public void SnapshotRejected(String str) {
        if (getClass() == StreamReporterInterface.class) {
            mrzjniInterfaceJNI.StreamReporterInterface_SnapshotRejected__SWIG_1(this.swigCPtr, this, str);
        } else {
            mrzjniInterfaceJNI.StreamReporterInterface_SnapshotRejectedSwigExplicitStreamReporterInterface__SWIG_1(this.swigCPtr, this, str);
        }
    }

    public void SnapshotProcessed(MrzResult mrzResult, boolean z) {
        mrzjniInterfaceJNI.StreamReporterInterface_SnapshotProcessed(this.swigCPtr, this, MrzResult.getCPtr(mrzResult), mrzResult, z);
    }

    public StreamReporterInterface() {
        this(mrzjniInterfaceJNI.new_StreamReporterInterface(), true);
        mrzjniInterfaceJNI.StreamReporterInterface_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
