package com.news.mobile.main.advert.presenter;

import com.news.mobile.MyApplication;
import com.news.mobile.base.BaseResponse;
import com.news.mobile.http.DataCallBack;

import com.news.mobile.main.advert.contract.AdvertContract;
import com.news.mobile.utils.UserSpCache;

/**
 * Created by sfy. on 2018/11/2 0002.
 */

public class AdvertPresenter extends AdvertContract.Presenter {
    private UserSpCache mUserSpCache = UserSpCache.getInstance(MyApplication.getAppContext());

    @Override
    public void TempLogin() {
        mModel.requestTempLogin(new DataCallBack() {
            @Override
            public void onComplete() {

            }

            @Override
            public void onSucceed(String json) {
                mView.templeLoginSuccess();
            }

            @Override
            public void onFail(BaseResponse baseResponse) {
                mView.showErrorTip(baseResponse.getCode(), baseResponse.getMsg());
            }

        });
    }
}
