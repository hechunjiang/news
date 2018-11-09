package com.news.mobile.main.mine.activity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.Color;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.news.mobile.JsShareType;
import com.news.mobile.R;
import com.news.mobile.base.BaseActivity;
import com.news.mobile.entiyt.ApprenticePageDataResponse;
import com.news.mobile.http.Api;
import com.news.mobile.main.home.activity.MainActivity;
import com.news.mobile.main.mine.contract.EarnActivityContract;
import com.news.mobile.main.mine.model.EarnModel;
import com.news.mobile.main.mine.presenter.EarnAPresenter;
import com.news.mobile.tplatform.facebook.FaceBookShare;
import com.news.mobile.tplatform.linkedin.LinkedInPlatform;
import com.news.mobile.tplatform.twitter.TwitterLogin;
import com.news.mobile.utils.Common;
import com.news.mobile.utils.StatusBarUtils;
import com.news.mobile.utils.ToastUtils;
import com.news.mobile.view.CustomShareDialog;
import com.news.mobile.main.web.activity.WebActivity;

public class EarnActivity extends BaseActivity<EarnAPresenter, EarnModel> implements EarnActivityContract.View {

    private ImageView action_bar_back_iv;
    private SwipeRefreshLayout personSr;
    private TextView mInCode;
    private TextView mCoinsFromFriends;
    private TextView mFriends;
    private TextView m2ndFriends;
    private View toplayouts;
    private TextView tv_earn;
    private TextView tv_earn_invite;
    private TextView tv_earn_basic;
    private TextView tv_earn_permanent;
    private View v_earn_friends;
    private View v_earn_2nd;
    private TextView tv_invition_copy;
    //    private ImageButton close_ad;
    private CustomShareDialog mCustomShareDialog;
    private TwitterLogin mTwitterLogin;
    private FaceBookShare mFaceBookShare;
    private LinkedInPlatform mLinkedInPlatform;

    private ClipboardManager myClipboard;

    @Override
    public int getLayoutId() {
        return R.layout.activity_earn;
    }

    @Override
    public void initView() {
        StatusBarUtils.setColor(EarnActivity.this, Color.parseColor("#FFFFFF"));

        action_bar_back_iv = findViewById(R.id.action_bar_back_iv);
        personSr = findViewById(R.id.person_sr);
        mInCode = findViewById(R.id.tv_earn_my_code);
        mCoinsFromFriends = findViewById(R.id.tv_earn_coins_from);
        mFriends = findViewById(R.id.tv_earn_friends);
        m2ndFriends = findViewById(R.id.tv_earn_2nd);
//        tv_shifu = findViewById(R.id.earn_text_4);
//        iv_shifu = findViewById(R.id.iv_earn_my_inviter);
        toplayouts = findViewById(R.id.view3);
        tv_earn = findViewById(R.id.tv_earn_title);
        // tv_up_load = findViewById(R.id.tv_up_load);
        tv_earn_invite = findViewById(R.id.tv_invition_start);
        tv_earn_basic = findViewById(R.id.tv_earn_basic);
        tv_earn_permanent = findViewById(R.id.tv_earn_permanent);
        v_earn_friends = findViewById(R.id.v_earn_friends);
        v_earn_2nd = findViewById(R.id.v_earn_2nd);
        tv_invition_copy = findViewById(R.id.tv_invition_copy);
//        close_ad = findViewById(R.id.close_ad);

        if (this != null)
            personSr.setColorSchemeColors(this.
                    getResources().getColor(R.color.invition_num));
        personSr.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mPresenter.getDatas();
            }
        });
        //tv_up_load.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
        myClipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);

        /*
         * 分享
         * */
        mCustomShareDialog = new CustomShareDialog(this);
        mCustomShareDialog.setCopeLink();
        mCustomShareDialog.setOnShareListener(new CustomShareDialog.OnShareListener() {
            @Override
            public void onShare(int type) {
                if (type != Common.SHARE_TYPE_REPORT) {
                    mPresenter.getShareDatas(type);
                } else {
                    ClipboardManager cm = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                    // 创建普通字符型ClipData
                    ClipData mClipData = ClipData.newPlainText("Label", "https://play.google.com/store/apps/details?id=com.sven.huinews.international");
                    // 将ClipData内容放到系统剪贴板里。
                    cm.setPrimaryClip(mClipData);
                    ToastUtils.showLong(getApplicationContext(), "Copied");
                }
            }
        });


    }

    @Override
    public void initEvents() {
        action_bar_back_iv.setOnClickListener(this);
        tv_earn_invite.setOnClickListener(this);
        tv_earn_basic.setOnClickListener(this);
        tv_earn_permanent.setOnClickListener(this);
        mInCode.setOnClickListener(this);
        v_earn_friends.setOnClickListener(this);
        v_earn_2nd.setOnClickListener(this);
        //tv_up_load.setOnClickListener(this);
//        close_ad.setOnClickListener(this);
        tv_earn.setOnClickListener(this);
        tv_invition_copy.setOnClickListener(this);
    }

    @Override
    public void onClickEvent(View v) {
        switch (v.getId()) {
            case R.id.action_bar_back_iv:
                finish();
                break;
            case R.id.tv_invition_start:
                if (mCustomShareDialog != null) mCustomShareDialog.show();
                break;
            case R.id.tv_earn_basic:
                WebActivity.toThis(mContext, Api.BASIC_REWARD);
                break;
            case R.id.tv_earn_permanent:
                WebActivity.toThis(mContext, Api.PERMANENT_COMMISSION);
                break;
            case R.id.tv_earn_my_code:
                WebActivity.toThis(mContext, Api.SHARE);
                break;
            case R.id.v_earn_friends:
                WebActivity.toThis(mContext, Api.APPRENTICE_DISCIPLE);
                break;
            case R.id.v_earn_2nd:
                WebActivity.toThis(mContext, Api.APPRENTICE_DISCIPLE_TYPE);
                break;

//                break;
            case R.id.tv_earn_title://google插页广告
//                if (mGoogleInterstitialAdsUtils.isLoad()) {
//                    mGoogleInterstitialAdsUtils.showAd(Common.AD_TYPE_GOOGLE_INTERSTITIAL_LOOK,Common.AD_TYPE_GOOGLE_INTERSTITIAL_CLICK);
//                }
                break;
            case R.id.tv_invition_copy:
                String text = mInCode.getText().toString();
                ClipData myClip = ClipData.newPlainText("text", text);
                myClipboard.setPrimaryClip(myClip);
                ToastUtils.showShort(this, R.string.copy_tip);
                break;
        }
    }

    @Override
    public void initObject() {
        setMVP();

    }

    @Override
    public void setViewData(ApprenticePageDataResponse apprenticePageDataResponse) {

    }

    @Override
    public void setViewupdate(String context, int height) {

    }

    @Override
    public void toShare(int type, JsShareType jsShareType) {

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
}