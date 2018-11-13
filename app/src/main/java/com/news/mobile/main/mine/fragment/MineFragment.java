package com.news.mobile.main.mine.fragment;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.drawee.view.SimpleDraweeView;
import com.news.mobile.entiyt.JsShareType;
import com.news.mobile.MyApplication;
import com.news.mobile.R;
import com.news.mobile.base.BaseActivity;
import com.news.mobile.base.BaseFragment;
import com.news.mobile.base.Constant;
import com.news.mobile.entiyt.UserInfoResponse;
import com.news.mobile.http.Api;
import com.news.mobile.main.mine.activity.EarnActivity;
import com.news.mobile.main.mine.activity.FeedbackActivity;
import com.news.mobile.main.mine.activity.MessageActivity;
import com.news.mobile.main.mine.activity.PersonActivity;
import com.news.mobile.main.mine.activity.SettingActivity;
import com.news.mobile.main.mine.contract.MineFContract;
import com.news.mobile.main.mine.model.MineFModel;
import com.news.mobile.main.mine.presenter.MineFPresenter;
import com.news.mobile.main.web.activity.WebActivity;
import com.news.mobile.tplatform.facebook.FaceBookShare;
import com.news.mobile.tplatform.twitter.TwitterLogin;
import com.news.mobile.tplatform.whatsapp.WhatsAppShare;
import com.news.mobile.utils.ACache;
import com.news.mobile.utils.Common;
import com.news.mobile.utils.LogUtil;
import com.news.mobile.utils.ToastUtils;
import com.news.mobile.utils.UserSpCache;
import com.news.mobile.view.CustomLoginDialog;
import com.news.mobile.view.MyRefreshLayout;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static android.content.Context.CLIPBOARD_SERVICE;


public class MineFragment extends BaseFragment<MineFPresenter, MineFModel> implements MineFContract.View {

    private TextView tv_login, tvMane, tvMeCoins, tvMeVideo, tvMeTotalIncome,
            tvMelExchange, tvMeContact, tvMeSettings, tvAgree, tvMeInput, tvMeRank;
    private LinearLayout ll_friend, ll_coins, ll_videos;
    private ImageView iv_tips, iv_faceShareLink, iv_ttShareLink, iv_InsShareLink, iv_WhatsShareLink;
    private CustomLoginDialog loginDialog;
    private FaceBookShare mFaceBookShare;
    private MyRefreshLayout swipRfLayout;
    private View ll_un_login;
    private View cl_login;
    private View ll_invition_code;
    private TextView tv_invition_code;
    private TextView tv_copy;
    private TextView tv_sign, tv_age, tv_location;
    private SimpleDraweeView headImg;
    private ImageButton btn_msg;
    private ImageButton close_ad;
    private FrameLayout fAdView;
    private ClipboardManager myClipboard;
    private TwitterLogin mTwitterLogin;
    private WhatsAppShare whatsAppShare;


    private boolean isShow = true, isLogin = false;
    private UserSpCache mUserSpCache = UserSpCache.getInstance(MyApplication.getAppContext());

    @Override
    protected int getLayoutResource() {
        EventBus.getDefault().register(this);
        return R.layout.fragment_mine;
    }

    @Override
    protected void initView(View v) {
        tv_login = v.findViewById(R.id.tv_login);
        swipRfLayout = v.findViewById(R.id.person_sr);
        tvMane = v.findViewById(R.id.tv_me_name);
        ll_un_login = v.findViewById(R.id.ll_un_login); //未登录
        cl_login = v.findViewById(R.id.cl_login);  //已登陆
        ll_invition_code = v.findViewById(R.id.ll_invition_code);
        tv_invition_code = v.findViewById(R.id.tv_invition_code);
        tv_copy = v.findViewById(R.id.tv_copy);
        tv_sign = v.findViewById(R.id.tv_sign);
        tv_location = v.findViewById(R.id.tv_location);
        tv_age = v.findViewById(R.id.tv_age);
        headImg = v.findViewById(R.id.iv_me_head);
        tvMeCoins = v.findViewById(R.id.tv_me_w_coins);
        tvMeVideo = v.findViewById(R.id.tv_me_videos);
        tvMeTotalIncome = v.findViewById(R.id.tv_me_w_total_income);
        tvMelExchange = v.findViewById(R.id.tv_me_l_exchange);  //提现
        btn_msg = v.findViewById(R.id.btn_message);
        tvMeContact = v.findViewById(R.id.tv_me_l_contact); //联系我们
        tvMeSettings = v.findViewById(R.id.tv_me_L_settings);  //设置
        tvAgree = v.findViewById(R.id.tv_agree_l_enter);  //意见反馈
        tvMeInput = v.findViewById(R.id.tv_me_l_input_num); //输入邀请码
        tvMeRank = v.findViewById(R.id.tv_me_l_rank); //排行榜
        iv_tips = v.findViewById(R.id.iv_tips);
        close_ad = v.findViewById(R.id.close_ad);

        myClipboard = (ClipboardManager) getActivity().getSystemService(CLIPBOARD_SERVICE);
        whatsAppShare = new WhatsAppShare(mContext);


        //中间按钮
        ll_friend = v.findViewById(R.id.ll_friend);
        ll_coins = v.findViewById(R.id.ll_coins);
        ll_videos = v.findViewById(R.id.ll_videos);
        loginDialog = new CustomLoginDialog(getActivity(), (BaseActivity) getActivity());

        //分享
        iv_faceShareLink = v.findViewById(R.id.iv_faceShareLink);
        iv_ttShareLink = v.findViewById(R.id.iv_ttShareLink);
        iv_InsShareLink = v.findViewById(R.id.iv_InsShareLink);
        iv_WhatsShareLink = v.findViewById(R.id.iv_WhatsShareLink);
        fAdView = v.findViewById(R.id.f_ad_view);
    }

    @Override
    public void initObject() {
        setMVP();
        mPresenter.getPersonMsg();
        setTips();

    }

    private void setTips() {
        int tips_service_count = UserSpCache.getInstance(mContext).getInt(UserSpCache.TIPS_FLAG);
        int tips_local_count = UserSpCache.getInstance(mContext).getInt(UserSpCache.TIPS_LOCAL_FLAG);

        if (tips_service_count > tips_local_count) {
            iv_tips.setVisibility(View.VISIBLE);
        } else {
            iv_tips.setVisibility(View.GONE);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        swipRfLayout.autoRefresh();
    }

    @Override
    protected void loadData() {


    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onRefreshTips(String str) {
        if (Common.REFRESH_USERINFO.equals(str)) {
            LogUtil.showLog("登陆");
            mPresenter.getPersonMsg();
        }
    }

    @Override
    public void initEvents() {
        swipRfLayout.finishLoadmore();
        swipRfLayout.setEnableLoadmore(false);
        tv_login.setOnClickListener(this);
        headImg.setOnClickListener(this);
        tvMelExchange.setOnClickListener(this);
        tvMeContact.setOnClickListener(this);
        tvAgree.setOnClickListener(this);
        tvMeSettings.setOnClickListener(this);
        btn_msg.setOnClickListener(this);
        tvMeInput.setOnClickListener(this);
        tvMeRank.setOnClickListener(this);
        tv_copy.setOnClickListener(this);
        ll_friend.setOnClickListener(this);
        ll_coins.setOnClickListener(this);
        ll_videos.setOnClickListener(this);

        iv_faceShareLink.setOnClickListener(this);
        iv_ttShareLink.setOnClickListener(this);
        iv_InsShareLink.setOnClickListener(this);
        iv_WhatsShareLink.setOnClickListener(this);
        close_ad.setOnClickListener(this);
    }

    @Override
    public void OnClickEvents(View v) {
        if (v == tv_login) {
            loginDialog.show();
        } else if (v == ll_friend) {
            startActivity(EarnActivity.class);
        } else if (v == btn_msg) {
            startActivity(MessageActivity.class);
        } else if (v == ll_coins) {
            WebActivity.toThis(mContext, Api.MelExchange);
        } else if (v == tvMeInput) {
            if (isLogin) {
                WebActivity.toThis(mContext, Api.ENTER);
            } else {
                loginDialog.show();
            }
        } else if (v == tvMelExchange) {
            WebActivity.toThis(mContext, Api.MelExchange);
        } else if (v == tvMeRank) {  //收入排行榜
            WebActivity.toThis(mContext, Api.MelRankingList);
        } else if (v == tvAgree) {
            startActivity(FeedbackActivity.class);
        } else if (v == tvMeSettings) {//设置界面
            startActivity(SettingActivity.class);
        } else if (v == tvMeContact) {
            WebActivity.toThis(mContext, Api.CONTACT);
        } else if (v == headImg) {
            if (!tvMane.getText().toString().trim().equals("")) {
                Intent intent = new Intent(getActivity(), PersonActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("name", tvMane.getText().toString().trim());
                intent.putExtras(bundle);
                startActivity(intent);
            } else {
                loginDialog.show();
            }
        } else if (v == tv_copy) {
            String text = tv_invition_code.getText().toString();
            ClipData myClip = ClipData.newPlainText("text", text);
            myClipboard.setPrimaryClip(myClip);
            ToastUtils.showShort(getContext(), R.string.copy_tip);
        } else if (v == iv_faceShareLink) {
            mPresenter.getLinkShareUrl(Common.SHARE_TYPE_FACEBOOK);
        } else if (v == iv_ttShareLink) {
            mPresenter.getLinkShareUrl(Common.SHARE_TYPE_TWITTER);
        } else if (v == iv_InsShareLink) {
            //不行
            mPresenter.getLinkShareUrl(Common.SHARE_TYPE_INS);
        } else if (v == iv_WhatsShareLink) {
            mPresenter.getLinkShareUrl(Common.SHARE_TYPE_WHATS);
        }
    }

    @Override
    public void getPersonMsgSuccess(UserInfoResponse user) {
        tvMane.setText(user.getData().getUserMsg().getNickname());
        if (swipRfLayout != null && swipRfLayout.isRefreshing()) {
            swipRfLayout.finishRefresh();
        }
        if (user != null) {
            isLogin = mUserSpCache.getBoolean(Constant.KEY_IS_USER_LOGIN);
            UserInfoResponse.UserInfo.UserMsg userMsg = user.getData().getUserMsg();
            if (isLogin) {
                ll_un_login.setVisibility(View.GONE);
                ll_invition_code.setVisibility(View.VISIBLE);
                cl_login.setVisibility(View.VISIBLE);
                tv_invition_code.setText(userMsg.getInvitation_code());
                tv_sign.setText(userMsg.getSignature());
            } else {
                ll_un_login.setVisibility(View.VISIBLE);
                ll_invition_code.setVisibility(View.GONE);
                cl_login.setVisibility(View.GONE);
            }

            if (getContext() != null) {
                headImg.setImageURI(userMsg.getHeadimg());
            }
            tvMeCoins.setText(userMsg.getGold_flag() + ""); //金币
            tvMeTotalIncome.setText(userMsg.getFriend_num() + ""); //徒弟
            tvMeVideo.setText(userMsg.getVideo_num() + "");  //视频数量
            if (TextUtils.isEmpty(userMsg.getBirthday())) {
                tv_age.setText(getString(R.string.me_age, 0));
            } else {
                tv_age.setText(getString(R.string.me_age, getAge(userMsg.getBirthday())));
            }

            String country = ACache.get(getActivity()).getAsString(Constant.CACHE_COUNTRY);
            if (TextUtils.isEmpty(country)) {
                tv_location.setText(getString(R.string.unknow));
            } else {
                tv_location.setText(country);
            }

            if (userMsg.isShare_code_status()) {//填写邀请码 ture就隐藏
                tvMeInput.setVisibility(View.GONE);
            } else {
                tvMeInput.setVisibility(View.VISIBLE);
            }
        }
    }

    @Override
    public void toShare(int type, JsShareType jsShareType) {
        if (type == Common.SHARE_TYPE_FACEBOOK) {
            mFaceBookShare = new FaceBookShare(getActivity(), new FacebookCallback() {
                @Override
                public void onSuccess(Object o) {
                    LogUtil.showLog("msg---分享成功:");
                    ToastUtils.showShort(mContext, getString(R.string.sharedSuccess));

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
        } else if (type == Common.SHARE_TYPE_TWITTER) {
            if (mTwitterLogin == null) mTwitterLogin = new TwitterLogin();
            mTwitterLogin.setTwitterShareLisenter(new TwitterLogin.TwitterShareLisenter() {
                @Override
                public void getShareOk(String response) {
                    LogUtil.showLog("msg---分享成功:");
                    ToastUtils.showShort(mContext, getString(R.string.sharedSuccess));
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
            mTwitterLogin.twitterShare(getActivity(), jsShareType, Common.TWITTER_SHARE_IAMGE);
        } else if (type == Common.SHARE_TYPE_INS) {
            ToastUtils.showShort(mContext, "暂未开放");
        } else if (type == Common.SHARE_TYPE_WHATS) {
            whatsAppShare.shareLink(jsShareType.getUrl());
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

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        loginDialog.registerCallBack(requestCode, resultCode, data, true);

        if (mFaceBookShare != null) {
            mFaceBookShare.getCallbackManager().onActivityResult(requestCode, resultCode, data);
        }
    }

    private int getAge(String birth) {
        int age = 0;
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date birthDay = df.parse(birth);
            age = getAge(birthDay);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
        return age;
    }

    public static int getAge(Date birthDay) {
        Calendar cal = Calendar.getInstance();

        if (cal.before(birthDay)) {
            return 0;
        }
        int yearNow = cal.get(Calendar.YEAR);
        int monthNow = cal.get(Calendar.MONTH);
        int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);
        cal.setTime(birthDay);

        int yearBirth = cal.get(Calendar.YEAR);
        int monthBirth = cal.get(Calendar.MONTH);
        int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);

        int age = yearNow - yearBirth;

        if (monthNow <= monthBirth) {
            if (monthNow == monthBirth) {
                if (dayOfMonthNow < dayOfMonthBirth)
                    age--;
            } else {
                age--;
            }
        }
        return age;
    }
}
