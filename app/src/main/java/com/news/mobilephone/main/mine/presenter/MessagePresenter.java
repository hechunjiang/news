package com.news.mobilephone.main.mine.presenter;

import com.news.mobilephone.base.BaseResponse;
import com.news.mobilephone.entiyt.MessageResponse;
import com.news.mobilephone.http.DataResponseCallback;
import com.news.mobilephone.main.mine.contract.MessageContract;

/**
 * 作者：created by hcj
 * 邮箱：2654313873@qq.com
 * 日期：2018/11/5 16
 */
public class MessagePresenter extends MessageContract.Presenter {
    @Override
    public void getMessageList() {
        mModel.getMessageList(new DataResponseCallback<MessageResponse>() {
            @Override
            public void onSucceed(MessageResponse messageResponse) {
                mView.setMessageData(messageResponse);
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
