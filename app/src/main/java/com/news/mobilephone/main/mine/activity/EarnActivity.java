package com.news.mobilephone.main.mine.activity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.Color;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.news.mobilephone.entiyt.JsShareType;
import com.news.mobilephone.R;
import com.news.mobilephone.base.BaseActivity;
import com.news.mobilephone.entiyt.ApprenticePageDataResponse;
import com.news.mobilephone.http.Api;
import com.news.mobilephone.main.mine.contract.EarnActivityContract;
import com.news.mobilephone.main.mine.model.EarnModel;
import com.news.mobilephone.main.mine.presenter.EarnAPresenter;
import com.news.mobilephone.tplatform.facebook.FaceBookShare;
import com.news.mobilephone.tplatform.linkedin.LinkedInPlatform;
import com.news.mobilephone.tplatform.twitter.TwitterLogin;
import com.news.mobilephone.utils.Common;
import com.news.mobilephone.utils.CommonUtils;
import com.news.mobilephone.utils.LogUtil;
import com.news.mobilephone.utils.StatusBarUtils;
import com.news.mobilephone.utils.ToastUtils;
import com.news.mobilephone.view.CustomShareDialog;
import com.news.mobilephone.main.web.activity.WebActivity;

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
        toplayouts = findViewById(R.id.view3);
        tv_earn = findViewById(R.id.tv_earn_title);
        tv_earn_invite = findViewById(R.id.tv_invition_start);
        tv_earn_basic = findViewById(R.id.tv_earn_basic);
        tv_earn_permanent = findViewById(R.id.tv_earn_permanent);
        v_earn_friends = findViewById(R.id.v_earn_friends);
        v_earn_2nd = findViewById(R.id.v_earn_2nd);
        tv_invition_copy = findViewById(R.id.tv_invition_copy);

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
        mPresenter.getDatas();
    }

    @Override
    public void setViewData(ApprenticePageDataResponse data) {

        if (personSr != null) {
            if (personSr.isRefreshing()) personSr.setRefreshing(false);
        }
        if (data != null) {
//            mInCode.setText(getString(R.string.earn_my_in_code,
//                    data.getData().getInvitation_code()));
            mInCode.setText(
                    data.getData().getInvitation_code());
            mCoinsFromFriends.setText(data.getData().getGold_tribute_total() + "");
            mFriends.setText(data.getData().getApprentice_total() + "");
            mPresenter.vw_toplayout(data.getData().getApprentice_total());
            m2ndFriends.setText(data.getData().getDisciple_num() + "");
//            if (!data.getData().getIs_shifu()) {
//                tv_shifu.setVisibility(View.GONE);
//                iv_shifu.setVisibility(View.GONE);
//            }
        }
    }

    @Override
    public void setViewupdate(String context, int height) {

    }

    @Override
    public void toShare(int type, final JsShareType jsShareType) {

        if (type == Common.SHARE_TYPE_TWITTER) {
            if (mTwitterLogin == null) mTwitterLogin = new TwitterLogin();
            mTwitterLogin.setTwitterShareLisenter(new TwitterLogin.TwitterShareLisenter() {
                @Override
                public void getShareOk(String response) {
                    LogUtil.showLog("msg---分享成功:");
                    //计数
                    mPresenter.shareVisit(CommonUtils.getShareSuccesResponse(), jsShareType.getActivity_type(), jsShareType.getType());
                }

                @Override
                public void getShareFail(String response) {
                    LogUtil.showLog("msg---分享失败:");
                }

                @Override
                public void getShareCancel(String response) {
                    LogUtil.showLog("msg---分享取消:");
                }
            });
            mTwitterLogin.twitterShare(EarnActivity.this, jsShareType, Common.TWITTER_SHARE_IAMGE);
        } else if (type == Common.SHARE_TYPE_FACEBOOK) {
            if (mFaceBookShare == null)
                mFaceBookShare = new FaceBookShare(EarnActivity.this, new FacebookCallback() {
                    @Override
                    public void onSuccess(Object o) {
                        LogUtil.showLog("msg---分享成功:");
                        ToastUtils.showShort(mContext, getString(R.string.sharedSuccess));
                        //计数
                        mPresenter.shareVisit(CommonUtils.getShareSuccesResponse(), jsShareType.getActivity_type(), jsShareType.getType());
                    }

                    @Override
                    public void onCancel() {
                        LogUtil.showLog("msg---取消分享:");
                    }

                    @Override
                    public void onError(FacebookException error) {
                        ToastUtils.showShort(mContext, getString(R.string.sharedFialed));


                    }
                });
            mFaceBookShare.share(jsShareType);
        } else if (type == Common.SHARE_TYPE_LINKEDIN) {
            if (mLinkedInPlatform == null)
                mLinkedInPlatform = new LinkedInPlatform(EarnActivity.this);
            mLinkedInPlatform.linkedInShareLisenter(new LinkedInPlatform.linkedInShareLisenter() {
                @Override
                public void getShareOk(String response) {
                    LogUtil.showLog("msg---分享成功:");
                    ToastUtils.showShort(mContext, getString(R.string.sharedSuccess));
                    //计数
                    mPresenter.shareVisit(CommonUtils.getShareSuccesResponse(), jsShareType.getActivity_type(), jsShareType.getType());
                }

                @Override
                public void getShareFail(String response) {
                    LogUtil.showLog("msg---分享失败:");
                    ToastUtils.showShort(mContext, getString(R.string.sharedFialed));
                }
            });
            mLinkedInPlatform.linkedInShare(jsShareType);
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
        personSr.setRefreshing(false);
        ToastUtils.showShort(mContext, msg);
    }
}
