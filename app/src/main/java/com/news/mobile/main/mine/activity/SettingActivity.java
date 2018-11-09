package com.news.mobile.main.mine.activity;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.news.mobile.BuildConfig;
import com.news.mobile.R;
import com.news.mobile.base.BaseActivity;
import com.news.mobile.entiyt.event.LogoutEvent;
import com.news.mobile.entiyt.request.PushTokenRequest;
import com.news.mobile.main.mine.contract.AdvertContract;
import com.news.mobile.main.mine.model.AdvertModel;
import com.news.mobile.main.mine.presenter.AdvertPresenter;
import com.news.mobile.utils.ToastUtils;
import com.news.mobile.utils.UserSpCache;
import com.news.mobile.utils.update.UpdateInfo;
import com.news.mobile.view.dialog.UploadProgressDialog;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

public class SettingActivity extends BaseActivity<AdvertPresenter, AdvertModel> implements AdvertContract.View {
    private TextView tvClearCache, tvUpData, tvLogOut, tv_version;
    private RelativeLayout relativeLayout, checkSetting;
    private UploadProgressDialog mDialog;

    @Override
    public int getLayoutId() {
        return R.layout.activity_setting;
    }

    @Override
    public void initView() {
        EventBus.getDefault().post(this);
        tvClearCache = findViewById(R.id.tv_settings_clear_cache);
        tvUpData = findViewById(R.id.tv_settings_up_data);
        tvLogOut = findViewById(R.id.tv_settings_logout);
        relativeLayout = findViewById(R.id.relativeLayout);
        checkSetting = findViewById(R.id.checking_settings);
        tv_version = findViewById(R.id.tv_version);
        mDialog = UploadProgressDialog.initGrayDialog(this);
        mDialog.setMessage("");
        tv_version.setText("V" + BuildConfig.VERSION_NAME);
    }

    @Override
    public void initEvents() {
        tvClearCache.setOnClickListener(this);
        tvUpData.setOnClickListener(this);
        tvLogOut.setOnClickListener(this);
        relativeLayout.setOnClickListener(this);
    }

    @Override
    public void onClickEvent(View v) {
        if (v == relativeLayout) {
            SettingActivity.this.finish();
        } else if (v == tvClearCache) {
            ToastUtils.showShort(mContext, getResources().getString(R.string.clearUp));
        } else if (v == tvUpData) {
            //更新Apk
            UpdateInfo updateInfo = new UpdateInfo(SettingActivity.this);
            updateInfo.getVersionIsUpdate();
        } else if (v == tvLogOut) {
            mDialog.show();
            logout();
        }
    }

    public void logout() {
        int totalCount = UserSpCache.getInstance(mContext).getInt(UserSpCache.NEEDCOUNT_LOGIN);
        long signTime = UserSpCache.getInstance(mContext).getLong(UserSpCache.SIGN_SERVICE_TIME);
        long localTime = UserSpCache.getInstance(mContext).getLong(UserSpCache.SIGN_LOCAL_TIME);
        int openGoldCount = UserSpCache.getInstance(mContext).getInt(UserSpCache.OPEN_GOLD_COUNT);
        int openRedCount = UserSpCache.getInstance(mContext).getInt(UserSpCache.OPEN_RED_COUNT);
        UserSpCache.getInstance(mContext.getApplicationContext()).clearCache();
        UserSpCache.getInstance(mContext).putString(UserSpCache.KEY_IS_FIRST_OPEN_APP, "has_open_app");
        UserSpCache.getInstance(mContext).putString(UserSpCache.KEY_IS_SECEND_OPEN_APP, "isSecend");
        UserSpCache.getInstance(mContext).putInt(UserSpCache.NEEDCOUNT_LOGIN, totalCount);
        UserSpCache.getInstance(mContext).putLong(UserSpCache.SIGN_SERVICE_TIME, signTime);
        UserSpCache.getInstance(mContext).putLong(UserSpCache.SIGN_LOCAL_TIME, localTime);
        UserSpCache.getInstance(mContext).putInt(UserSpCache.OPEN_GOLD_COUNT, openGoldCount);
        UserSpCache.getInstance(mContext).putInt(UserSpCache.OPEN_RED_COUNT, openRedCount);
        mPresenter.checkIstemp();
    }

    @Override
    public void initObject() {
        setMVP();
    }

    @Override
    public void tempLoginSuccess(String s) {
//        firebase不要
//        mPresenter.pushToken();
        mDialog.dismiss();
        int count = UserSpCache.getInstance(getApplicationContext()).getInt(UserSpCache.OPEN_COUNT);
        count++;
        UserSpCache.getInstance(this).putInt(UserSpCache.OPEN_COUNT, count);
        SettingActivity.this.finish();
        EventBus.getDefault().post(new LogoutEvent());
    }

    @Override
    public PushTokenRequest onPushTokenRequest() {
        return null;
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showErrorTip(int code, String msg) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);

    }

    int[] a = {1, 2, 3, 4, 5};

    public void parse() {


    }
}
