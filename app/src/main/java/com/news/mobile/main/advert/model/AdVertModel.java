package com.news.mobile.main.advert.model;

import com.google.gson.Gson;
import com.news.mobile.MyApplication;
import com.news.mobile.base.BaseResponse;
import com.news.mobile.entiyt.TempleLoginResponse;
import com.news.mobile.entiyt.request.TempLoginRequest;
import com.news.mobile.http.DataCallBack;
import com.news.mobile.main.advert.contract.AdvertContract;
import com.news.mobile.utils.PhoneUtils;
import com.news.mobile.utils.UserSpCache;

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
