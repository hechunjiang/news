package com.news.mobilephone.main.bind.model;


import com.news.mobilephone.base.BaseResponse;
import com.news.mobilephone.entiyt.request.BindEmailRequest;
import com.news.mobilephone.entiyt.request.GetCodeRequest;
import com.news.mobilephone.http.DataCallBack;
import com.news.mobilephone.http.DataResponseCallback;
import com.news.mobilephone.main.bind.contract.BindEmailContract;

/**
 * Created by sfy. on 2018/11/1 0001.
 */

public class BinEmailModel extends BindEmailContract.Model {
    @Override
    public void getSmsCode(GetCodeRequest request, final DataCallBack callBack) {
        getRetrofit().getSmsCode(request, new DataCallBack() {
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

    @Override
    public void requestBindEmail(BindEmailRequest request, final DataResponseCallback<String> callback) {

        getRetrofit().bindEmail(request, new DataCallBack() {
            @Override
            public void onComplete() {
                callback.onComplete();
            }

            @Override
            public void onSucceed(String json) {
                callback.onSucceed(json);
            }

            @Override
            public void onFail(BaseResponse baseResponse) {
                callback.onFail(baseResponse);
            }
        });
    }
}
