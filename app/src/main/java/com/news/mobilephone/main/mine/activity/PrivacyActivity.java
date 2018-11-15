package com.news.mobilephone.main.mine.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.news.mobilephone.R;
import com.news.mobilephone.base.BaseActivity;
import com.news.mobilephone.utils.CommonUtils;

public class PrivacyActivity extends BaseActivity {

    private ImageView action_bar_back_iv;
    private TextView tv_agreement;

    @Override
    public int getLayoutId() {
        return R.layout.activity_privacy;
    }

    @Override
    public void initView() {
        action_bar_back_iv = findViewById(R.id.action_bar_back_iv);
        tv_agreement = findViewById(R.id.tv_agreement);
    }

    @Override
    public void initEvents() {
        action_bar_back_iv.setOnClickListener(this);

    }

    @Override
    public void onClickEvent(View v) {
        if (v == action_bar_back_iv) {
            finish();
        }

    }

    @Override
    public void initObject() {

        String str = CommonUtils.readRawTxt(this, R.raw.privacy);
        tv_agreement.setText(CommonUtils.ToDBC(str));
    }
}
