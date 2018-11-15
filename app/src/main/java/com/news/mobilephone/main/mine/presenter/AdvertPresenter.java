package com.news.mobilephone.main.mine.presenter;

import com.news.mobilephone.base.BaseResponse;
import com.news.mobilephone.http.DataCallBack;
import com.news.mobilephone.main.mine.contract.AdvertContract;
import com.news.mobilephone.utils.LogUtil;

/**
 * 作者：created by hcj
 * 邮箱：2654313873@qq.com
 * 日期：2018/11/5 18
 */
public class AdvertPresenter extends AdvertContract.Presenter {
    @Override
    public void checkIstemp() {
        mModel.requestIstemp(new DataCallBack() {
            @Override
            public void onComplete() {

            }

            @Override
            public void onSucceed(String json) {
                mView.tempLoginSuccess(json);
            }

            @Override
            public void onFail(BaseResponse baseResponse) {
                mView.showErrorTip(baseResponse.getCode(), baseResponse.getMsg());
            }

        });


    }

    @Override
    public void pushToken() {
        mModel.pushToken(mView.onPushTokenRequest(), new DataCallBack() {
            @Override
            public void onComplete() {

            }

            @Override
            public void onSucceed(String json) {
                LogUtil.showLog("msg----json:" + json);
            }

            @Override
            public void onFail(BaseResponse baseResponse) {

            }
        });
    }
}
