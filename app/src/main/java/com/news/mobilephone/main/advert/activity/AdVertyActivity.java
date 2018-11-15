package com.news.mobilephone.main.advert.activity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.CountDownTimer;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.news.mobilephone.R;
import com.news.mobilephone.base.BaseActivity;
import com.news.mobilephone.main.advert.contract.AdvertContract;
import com.news.mobilephone.main.advert.model.AdVertModel;
import com.news.mobilephone.main.advert.presenter.AdvertPresenter;
import com.news.mobilephone.main.home.activity.MainActivity;
import com.news.mobilephone.utils.Common;
import com.news.mobilephone.utils.Eyes;
import com.news.mobilephone.utils.NetWorkUtils;
import com.news.mobilephone.utils.ToastUtils;
import com.news.mobilephone.utils.UserSpCache;

public class AdVertyActivity extends BaseActivity<AdvertPresenter, AdVertModel> implements AdvertContract.View {

    private ImageView gif_logo;
    private TextView ad_count_time_tv;
    private UserSpCache mUserSpCache;
    private CountTimeUtils mCountTimeUtils;
    private boolean isTimeDown = false, tempLogin = false;

    @Override
    public int getLayoutId() {
        return R.layout.activity_ad_verty;
    }

    @Override
    public void initView() {
        Eyes.translucentStatusBar(this, true);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        hideBottomUIMenu();
        mCountTimeUtils = new CountTimeUtils(5000, 1000);
        mUserSpCache = UserSpCache.getInstance(getApplicationContext());
        gif_logo = findViewById(R.id.gif_logo);
        ad_count_time_tv = findViewById(R.id.ad_count_time_tv);
        mCountTimeUtils.start();
        Glide.with(this).load(R.drawable.homepagelog).into(gif_logo);

        mUserSpCache.putFloat(Common.PROGRESS, 0f);
    }

    @Override
    public void initEvents() {

    }

    @Override
    public void onClickEvent(View v) {

    }

    @Override
    public void initObject() {
        setMVP();
        //检查是否需要临时登录
        if (!mUserSpCache.getBoolean(UserSpCache.KEY_IS_USER_LOGIN)) {
            mPresenter.TempLogin();
        }
    }


    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showErrorTip(int code, String msg) {
        if (isTimeDown) {
            startToMainActivity();
        }
        if (!NetWorkUtils.isNetworkAvailable(this)) {
            ToastUtils.showLong(mContext, getString(R.string.network_down));
        }
    }

    @Override
    public void templeLoginSuccess() {
        if (isTimeDown) {
            startToMainActivity();
        }
    }

    private class CountTimeUtils extends CountDownTimer {

        public CountTimeUtils(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
          ad_count_time_tv.setText(millisUntilFinished / 1000 + "s");
        }

        @Override
        public void onFinish() {
            ad_count_time_tv.setText(getString(R.string.length_0));
            isTimeDown = true;
            startToMainActivity();
        }
    }

    private void startToMainActivity() {
        startActivity(new Intent(AdVertyActivity.this, MainActivity.class));
        AdVertyActivity.this.finish();
    }


    /**
     * 隐藏虚拟按键，并且全屏
     */
    protected void hideBottomUIMenu() {
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN); //隐藏状态栏
        // 隐藏虚拟按键，并且全屏
        if (Build.VERSION.SDK_INT > 11 && Build.VERSION.SDK_INT < 19) { // lower api
            View v = this.getWindow().getDecorView();
            v.setSystemUiVisibility(View.GONE);
        } else if (Build.VERSION.SDK_INT >= 19) {
            //for new api versions.
            View decorView = getWindow().getDecorView();
            int uiOptions = View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
            decorView.setSystemUiVisibility(uiOptions);
        }
    }
}
