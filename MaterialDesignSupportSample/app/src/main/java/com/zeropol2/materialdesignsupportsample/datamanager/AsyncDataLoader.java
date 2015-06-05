/**
 * 
 */
package com.zeropol2.materialdesignsupportsample.datamanager;

import android.os.AsyncTask;
import android.os.Build;

/**
 * @author zeropol2
 * 
 */
public abstract class AsyncDataLoader<T> extends AsyncTask<Void, Void, T> {
	public static interface OnDataLoadListener<T> {
		public void onDataLoad(T data);
        public void onDataLoadFail(int code, String message);
	}
    public static class CodeMessageException extends Exception {
        private int mCode;
        private String mMessage;
        public CodeMessageException(int code, String message) {
            super();
            mCode = code;
            mMessage = message;
        }

        public int getCode() {
            return mCode;
        }

        public String getMessage() {
            return mMessage;
        }
    }
    private CodeMessageException mException = null;
	private OnDataLoadListener<T> mOnDataLoadListener = null;
	public AsyncDataLoader(OnDataLoadListener<T> l) {
		mOnDataLoadListener = l;
	}

    private static final int EXCEPTION_CODE_INTERRUPTED_EXCEPTION =100;
	
	protected abstract T doTask() throws CodeMessageException, InterruptedException;
	
	@Override
	protected void onPreExecute() {
		super.onPreExecute();
	}

	@Override
	protected T doInBackground(Void... unused) {
        try {
            return doTask();
        } catch(CodeMessageException e) {
            mException = e;
            return null;
        } catch(InterruptedException e) {
            mException = new CodeMessageException(EXCEPTION_CODE_INTERRUPTED_EXCEPTION, e.toString());
            return null;
        }
	}

	@Override
	protected void onPostExecute(T result) {
		if(null != mOnDataLoadListener) {
            if(null == mException) {
                mOnDataLoadListener.onDataLoad(result);
            } else {
                mOnDataLoadListener.onDataLoadFail(mException.getCode(), mException.getMessage());
            }
		}
	}

    public void executeTask() {
        if(Build.VERSION.SDK_INT< Build.VERSION_CODES.HONEYCOMB){
            this.execute();
        }else{
            this.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, null);
        }
    }

}
