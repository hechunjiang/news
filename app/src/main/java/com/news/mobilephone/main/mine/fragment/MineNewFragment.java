package com.news.mobilephone.main.mine.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.allen.library.SuperTextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.news.mobilephone.entiyt.JsShareType;
import com.news.mobilephone.MyApplication;
import com.news.mobilephone.R;
import com.news.mobilephone.base.BaseActivity;
import com.news.mobilephone.base.BaseFragment;
import com.news.mobilephone.base.Constant;
import com.news.mobilephone.entiyt.UserInfoResponse;
import com.news.mobilephone.http.Api;
import com.news.mobilephone.main.mine.activity.EarnActivity;
import com.news.mobilephone.main.mine.activity.FeedbackActivity;
import com.news.mobilephone.main.mine.activity.MessageActivity;
import com.news.mobilephone.main.mine.activity.PersonActivity;
import com.news.mobilephone.main.mine.activity.SettingActivity;
import com.news.mobilephone.main.mine.contract.MineFContract;
import com.news.mobilephone.main.mine.model.MineFModel;
import com.news.mobilephone.main.mine.presenter.MineFPresenter;
import com.news.mobilephone.main.web.activity.WebActivity;
import com.news.mobilephone.tplatform.facebook.FaceBookShare;
import com.news.mobilephone.utils.Common;
import com.news.mobilephone.utils.UserSpCache;
import com.news.mobilephone.view.CustomLoginDialog;
import com.news.mobilephone.view.MyRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MineNewFragment extends BaseFragment<MineFPresenter, MineFModel> implements MineFContract.View {

    private SimpleDraweeView sv_head;
    private SuperTextView sv_left, sv_middle, sv_right;
    private CustomLoginDialog loginDialog;
    private FaceBookShare mFaceBookShare;
    private TextView tv_login;
    private MyRefreshLayout swipRfLayout;
    private UserSpCache mUserSpCache = UserSpCache.getInstance(MyApplication.getAppContext());
    private boolean isShow = true, isLogin = false;
    private TextView tv_invition_code, tv_agreement, tv_setting, tv_callme, tv_exchange, tv_message, tv_invit;

    @Override
    protected int getLayoutResource() {
        EventBus.getDefault().register(this);
        return R.layout.fragment_mine_new;
    }

    @Override
    public void initObject() {
        setMVP();
        mPresenter.getPersonMsg();
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
    protected void initView(View v) {
        loginDialog = new CustomLoginDialog(getActivity(), (BaseActivity) getActivity());
        sv_head = v.findViewById(R.id.sv_head);
        sv_left = v.findViewById(R.id.sv_left);
        sv_middle = v.findViewById(R.id.sv_middle);
        sv_right = v.findViewById(R.id.sv_right);
        tv_login = v.findViewById(R.id.tv_login);
        tv_invition_code = v.findViewById(R.id.tv_invition_code);
        tv_agreement = v.findViewById(R.id.tv_agreement);
        swipRfLayout = v.findViewById(R.id.refreshLayout);
        tv_setting = v.findViewById(R.id.tv_setting);
        tv_callme = v.findViewById(R.id.tv_callme);
        tv_exchange = v.findViewById(R.id.tv_exchange);
        tv_message = v.findViewById(R.id.tv_message);
        tv_invit = v.findViewById(R.id.tv_invit);


    }

    @Override
    public void initEvents() {
        swipRfLayout.finishLoadmore();
        swipRfLayout.setEnableLoadmore(false);
        sv_head.setOnClickListener(this);
        tv_invition_code.setOnClickListener(this);
        tv_agreement.setOnClickListener(this);
        tv_setting.setOnClickListener(this);
        tv_callme.setOnClickListener(this);
        tv_exchange.setOnClickListener(this);
        tv_message.setOnClickListener(this);
        tv_invit.setOnClickListener(this);
        swipRfLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                mPresenter.getPersonMsg();
            }
        });
    }

    @Override
    public void OnClickEvents(View v) {
        if (v == sv_head) {
            if (isLogin) {
                Intent intent = new Intent(getActivity(), PersonActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("name", tv_login.getText().toString().trim());
                intent.putExtras(bundle);
                startActivity(intent);
            } else {
                loginDialog.show();
            }

        } else if (v == tv_login) {
            if (!isLogin) {
                loginDialog.show();
            }
        } else if (v == tv_invition_code) {
            if (isLogin) {
                WebActivity.toThis(mContext, Api.ENTER);
            } else {
                loginDialog.show();
            }
        } else if (v == tv_agreement) {
            startActivity(FeedbackActivity.class);
        } else if (v == tv_setting) {
            startActivity(SettingActivity.class);
        } else if (v == tv_callme) {
            WebActivity.toThis(mContext, Api.CONTACT);
        } else if (v == tv_exchange) {
            WebActivity.toThis(mContext, Api.MelExchange);
        } else if (v == tv_message) {
            startActivity(MessageActivity.class);
        } else if (v == tv_invit) {
            startActivity(EarnActivity.class);
        }
    }

    @Override
    public void getPersonMsgSuccess(UserInfoResponse user) {
        tv_login.setText(TextUtils.isEmpty(user.getData().getUserMsg().getNickname()) ? getString(R.string.un_login) : user.getData().getUserMsg().getNickname());

        if (swipRfLayout != null && swipRfLayout.isRefreshing()) {
            swipRfLayout.finishRefresh();
        }
        if (user != null) {
            UserInfoResponse.UserInfo.UserMsg userMsg = user.getData().getUserMsg();
            isLogin = mUserSpCache.getBoolean(Constant.KEY_IS_USER_LOGIN);
            sv_head.setImageURI(Uri.parse(userMsg.getHeadimg()));
            sv_left.setCenterString(userMsg.getGold_flag() + "");
            sv_middle.setCenterString(TextUtils.isEmpty(userMsg.getBalance())?"0.00":userMsg.getBalance());
            sv_right.setCenterString(TextUtils.isEmpty(userMsg.getTotal_balance())?"0.00":userMsg.getTotal_balance());
        }

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
        swipRfLayout.finishRefresh();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onRefreshTips(String str) {

        if (Common.REFRESH_USERINFO.equals(str)) {
            mPresenter.getPersonMsg();

        }
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

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);

    }
}
