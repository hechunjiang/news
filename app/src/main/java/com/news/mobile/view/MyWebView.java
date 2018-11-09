package com.news.mobile.view;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.ProgressBar;

import com.news.mobile.utils.LogUtil;

import java.lang.ref.WeakReference;

public class MyWebView extends WebView {

    private Context context;
    //private ProgressBar progressbar;
    private OnScrollChangeListener mOnScrollChangeListener;

    private boolean isSroll = false;

    public MyWebView(Context context) {
        this(context,null);
    }

    public MyWebView(Context context, AttributeSet attrs) {
        this(context,attrs,0);
    }

    public MyWebView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        init();
    }

    private void init(){
//        progressbar = new ProgressBar(context, null, android.R.attr.progressBarStyleHorizontal);
//        progressbar.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, 3, 0, 0));
//        addView(progressbar);
        setWebChromeClient(new WebChromeClient());
    }

    class WebChromeClient extends android.webkit.WebChromeClient{
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
//            if (newProgress == 100) {
//                //progressbar.setVisibility(GONE);
//            } else {
////                if (progressbar.getVisibility() == GONE)
////                    progressbar.setVisibility(VISIBLE);
////                progressbar.setProgress(newProgress);
//            }

            if(mOnScrollChangeListener != null){
                mOnScrollChangeListener.progress(newProgress);
            }

            super.onProgressChanged(view, newProgress);
        }
    }

    public void setmOnScrollChangeListener(OnScrollChangeListener mOnScrollChangeListener) {
        this.mOnScrollChangeListener = mOnScrollChangeListener;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        isSroll = true;
    }


    public interface OnScrollChangeListener {
        void progress(int progress);

    }


}
