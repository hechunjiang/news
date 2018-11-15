package com.news.mobilephone.view;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.OverScroller;
import android.widget.ScrollView;

import java.lang.reflect.Field;

public class MyScrollView extends ScrollView {

    private boolean isScroll = false;
    private OnScrollStateListener onScrollStateListener;

    public void setOnScrollStateListener(OnScrollStateListener onScrollStateListener) {
        this.onScrollStateListener = onScrollStateListener;
    }

    public MyScrollView(Context context) {
        this(context, null);
    }

    public MyScrollView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyScrollView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }


    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);

        isScroll = true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        int action = ev.getAction();
        switch (action) {
            case MotionEvent.ACTION_CANCEL:
            case MotionEvent.ACTION_UP:
                handler.sendEmptyMessage(0);
                break;
        }
        return super.onTouchEvent(ev);
    }

    Handler handler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    checkIsScrolling();
                    break;
            }
            super.handleMessage(msg);
        }
    };

    private void checkIsScrolling() {
        try {
            Field field = getClass().getSuperclass().getDeclaredField(
                    "mScroller");
            field.setAccessible(true);
            Object object = field.get(this);
            OverScroller scroller = (OverScroller) object;
            boolean isScrolling = scroller.computeScrollOffset();
            if (isScrolling) {
                handler.sendEmptyMessageDelayed(0, 10);
            } else {
                //滑动结束
                if(onScrollStateListener != null && isScroll){
                    onScrollStateListener.onScrollStop();
                }

                isScroll = false;
            }
            System.out.println(field.getType() + "");
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }


    public interface OnScrollStateListener{
        void onScrollStop();
    }
}
