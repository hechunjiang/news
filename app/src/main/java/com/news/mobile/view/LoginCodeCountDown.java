package com.news.mobile.view;

import android.graphics.Color;
import android.os.CountDownTimer;
import android.widget.TextView;

import com.news.mobile.MyApplication;
import com.news.mobile.R;

/**
 * 作者：created by hcj
 * 邮箱：2654313873@qq.com
 * 日期：2018/11/4 17
 */
public class LoginCodeCountDown extends CountDownTimer {

    private TextView mTextView;
    private static final long mMillisInFuture = 60 * 1000;
    private static final long mCountDownInterval = 1000;

    public void setNotClick() {
        mTextView.setTextColor(Color.parseColor("#9a9b9f"));
        mTextView.setClickable(false);
    }

    public LoginCodeCountDown(TextView textView) {
        super(mMillisInFuture, mCountDownInterval);
        mTextView = textView;
    }

    @Override
    public void onTick(long millisUntilFinished) {
        mTextView.setText(millisUntilFinished / 1000 + MyApplication.getAppContext().getResources().getString(R.string.s_re_try));
    }

    @Override
    public void onFinish() {
        mTextView.setText("0" + MyApplication.getAppContext().getResources().getString(R.string.s_re_try));
        mTextView.setText(MyApplication.getAppContext().getResources().getString(R.string.get_code));
        mTextView.setTextColor(Color.parseColor("#ff0000"));
        mTextView.setClickable(true);
    }
}
