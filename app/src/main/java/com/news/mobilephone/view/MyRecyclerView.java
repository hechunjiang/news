package com.news.mobilephone.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

/**
 * @Author weiwei
 * create by 2018/11/8
 * Des: <功能简述>
 * 代码不优雅，写锤子代码
 */
public class MyRecyclerView extends RecyclerView {

    private boolean isScroll = false;
    private OnProgressListener onProgressListener;

    public void setOnProgressListener(OnProgressListener onProgressListener) {
        this.onProgressListener = onProgressListener;
    }

    public MyRecyclerView(Context context) {
        this(context,null);
    }

    public MyRecyclerView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MyRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init(){
        addOnScrollListener(new OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

                if(newState == RecyclerView.SCROLL_STATE_IDLE && isScroll){
                    isScroll = false;

                    if(onProgressListener != null){
                        onProgressListener.onStopScroll();
                    }
                }
            }
        });
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        isScroll = true;
    }

    public interface OnProgressListener{
        void onStopScroll();
    }
}
