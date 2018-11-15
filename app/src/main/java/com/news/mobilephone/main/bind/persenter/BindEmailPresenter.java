package com.news.mobilephone.main.bind.persenter;

import com.google.gson.Gson;
import com.news.mobilephone.base.BaseResponse;
import com.news.mobilephone.entiyt.BindEamilResponse;
import com.news.mobilephone.entiyt.request.GetCodeRequest;
import com.news.mobilephone.http.DataCallBack;
import com.news.mobilephone.http.DataResponseCallback;
import com.news.mobilephone.main.bind.contract.BindEmailContract;


/**
 * Created by sfy. on 2018/11/1 0001.
 */

public class BindEmailPresenter extends BindEmailContract.Presenter {

    @Override
    public void getSmsCode(GetCodeRequest request) {
        mModel.getSmsCode(request, new DataCallBack() {
            @Override
            public void onComplete() {

            }

            @Override
            public void onSucceed(String json) {

                mView.getsmsCodeSuccess();
            }

            @Override
            public void onFail(BaseResponse baseResponse) {

            }
        });
    }

    @Override
    public void bindEmail() {
        mModel.requestBindEmail(mView.getBindEmailRequest(), new DataResponseCallback<String>() {
            @Override
            public void onSucceed(String s) {
                BindEamilResponse response = new Gson().fromJson(s, BindEamilResponse.class);

                    mView.bindEmailSuccess(response.getData().getGold() + "");

            }

            @Override
            public void onFail(BaseResponse response) {
                mView.showErrorTip(response.getCode(), response.getMsg());
            }

            @Override
            public void onComplete() {

            }
        });
    }
}
