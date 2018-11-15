package com.news.mobilephone.main.advert.model;

import com.google.gson.Gson;
import com.news.mobilephone.MyApplication;
import com.news.mobilephone.base.BaseResponse;
import com.news.mobilephone.entiyt.TempleLoginResponse;
import com.news.mobilephone.entiyt.request.TempLoginRequest;
import com.news.mobilephone.http.DataCallBack;
import com.news.mobilephone.main.advert.contract.AdvertContract;
import com.news.mobilephone.utils.PhoneUtils;
import com.news.mobilephone.utils.UserSpCache;

/**
 * Created by sfy. on 2018/11/2 0002.
 */

public class AdVertModel extends AdvertContract.Model {
    private UserSpCache mUserSpCache = UserSpCache.getInstance(MyApplication.getAppContext());

    @Override
    public void requestTempLogin(final DataCallBack callBack) {
        TempLoginRequest request = new TempLoginRequest();
        request.setMobile_brand(PhoneUtils.getPhoneBrand());
        getRetrofit().requestTempLogin(request, new DataCallBack() {
            @Override
            public void onComplete() {
                callBack.onCompleted();
            }

            @Override
            public void onSucceed(String json) {
                TempleLoginResponse response = new Gson().fromJson(json, TempleLoginResponse.class);
                mUserSpCache.putString(UserSpCache.KEY_TICKET, response.getData().getTicket());
                mUserSpCache.putBoolean(UserSpCache.KEY_IS_USER_LOGIN, response.getData().isLogin_flag());
                callBack.onSucceed(json);
            }

            @Override
            public void onFail(BaseResponse baseResponse) {
                callBack.onFail(baseResponse);
            }
        });
    }
}
