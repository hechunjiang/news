package com.news.mobilephone.main.mine.model;

import com.google.gson.Gson;
import com.news.mobilephone.base.BaseResponse;
import com.news.mobilephone.entiyt.MessageResponse;
import com.news.mobilephone.http.DataCallBack;
import com.news.mobilephone.http.DataResponseCallback;
import com.news.mobilephone.main.mine.contract.MessageContract;

/**
 * 作者：created by hcj
 * 邮箱：2654313873@qq.com
 * 日期：2018/11/5 16
 */
public class MessageModel extends MessageContract.Model {
    @Override
    public void getMessageList(final DataResponseCallback<MessageResponse> callBack) {
        getRetrofit().onMessageList(new DataCallBack() {
            @Override
            public void onComplete() {
                callBack.onComplete();
            }

            @Override
            public void onSucceed(String json) {
                MessageResponse response = new Gson().fromJson(json, MessageResponse.class);
                callBack.onSucceed(response);
            }

            @Override
            public void onFail(BaseResponse baseResponse) {
                callBack.onFail(baseResponse);
            }
        });
    }
}
