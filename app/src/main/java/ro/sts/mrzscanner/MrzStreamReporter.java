package ro.sts.mrzscanner;

import biz.smartengines.swig.MrzRectMatrix;
import biz.smartengines.swig.MrzResult;
import biz.smartengines.swig.StreamReporterInterface;

public class MrzStreamReporter extends StreamReporterInterface {

    private MrzStreamListener mMrzStreamListener;

    public void setMrzStreamListener(MrzStreamListener listener) {
        mMrzStreamListener = listener;
    }

    @Override
    public void SnapshotProcessed(MrzResult mrzResult, boolean processed) {
        if (mMrzStreamListener != null) {
            mMrzStreamListener.onSnapshotProcessed(mrzResult, processed);
        }
    }

    @Override
    public void SnapshotRejected() {
        if (mMrzStreamListener != null) {
            mMrzStreamListener.onSnapshotRejected();
        }
    }

    @Override
    public void SymbolRectsFound(MrzRectMatrix mrzRectMatrix) {
        if (mMrzStreamListener != null) {
            mMrzStreamListener.onSymbolRectsFound(mrzRectMatrix);
        }
    }

    public interface MrzStreamListener {
        void onSnapshotProcessed(MrzResult mrzResult, boolean processed);

        void onSnapshotRejected();

        void onSymbolRectsFound(MrzRectMatrix mrzRectMatrix);
    }
}
