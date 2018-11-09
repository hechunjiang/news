package com.news.mobile.main.mine.model;

import com.google.gson.Gson;
import com.news.mobile.MyApplication;
import com.news.mobile.base.BaseResponse;
import com.news.mobile.entiyt.User;
import com.news.mobile.entiyt.request.PushTokenRequest;
import com.news.mobile.entiyt.request.TempLoginRequest;
import com.news.mobile.http.DataCallBack;
import com.news.mobile.main.mine.contract.AdvertContract;
import com.news.mobile.utils.LogUtil;
import com.news.mobile.utils.PhoneUtils;
import com.news.mobile.utils.UserSpCache;

/**
 * 作者：created by hcj
 * 邮箱：2654313873@qq.com
 * 日期：2018/11/5 18
 */
public class AdvertModel extends AdvertContract.Model {
    private UserSpCache mUserSpCache = UserSpCache.getInstance(MyApplication.getAppContext());

    @Override
    public void requestIstemp(final DataCallBack callBack) {
        TempLoginRequest request = new TempLoginRequest();
        request.setMobile_brand(PhoneUtils.getPhoneBrand());
        getRetrofit().requestTempLogin(request, new DataCallBack() {
            @Override
            public void onComplete() {
                callBack.onComplete();
            }

            @Override
            public void onSucceed(String json) {
                LogUtil.showLog(json);
                User response = new Gson().fromJson(json, User.class);
                mUserSpCache.putString(UserSpCache.KEY_TICKET, response.getData().getTicket());
                mUserSpCache.putBoolean(UserSpCache.KEY_IS_USER_LOGIN, response.getData().isLogin_flag());
                mUserSpCache.putUser(response);
                callBack.onSucceed(json);
            }

            @Override
            public void onFail(BaseResponse baseResponse) {
                callBack.onFail(baseResponse);
            }

        });
    }

    @Override
    public void pushToken(PushTokenRequest request, final DataCallBack callBack) {
        getRetrofit().onPushToken(request, new DataCallBack() {
            @Override
            public void onComplete() {
                callBack.onComplete();
            }

            @Override
            public void onSucceed(String json) {
                callBack.onSucceed(json);
            }

            @Override
            public void onFail(BaseResponse baseResponse) {
                callBack.onFail(baseResponse);
            }
        });
    }
}
