package com.news.mobilephone.main.web.activity;

import android.view.View;

import com.news.mobilephone.R;
import com.news.mobilephone.base.BaseActivity;
import com.news.mobilephone.view.MyWebView;

public class MyWebActivity extends BaseActivity {
    private MyWebView myweb;

    @Override
    public int getLayoutId() {
        return R.layout.activity_my_web;
    }

    @Override
    public void initView() {
        myweb = findViewById(R.id.myweb);

    }

    @Override
    public void initEvents() {

    }

    @Override
    public void onClickEvent(View v) {

    }

    @Override
    public void initObject() {
        myweb.loadUrl("https://blog.csdn.net/lowprofile_coding/article/details/77928614");
    }
}
