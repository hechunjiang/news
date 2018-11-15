package com.news.mobilephone.main.mine.presenter;

import com.news.mobilephone.base.BaseResponse;
import com.news.mobilephone.entiyt.FeedBackClassifyResponse;
import com.news.mobilephone.entiyt.FeedBackResponse;
import com.news.mobilephone.entiyt.request.FeedBackRequest;
import com.news.mobilephone.http.DataResponseCallback;
import com.news.mobilephone.main.mine.contract.FeedbackContract;

/**
 * 作者：created by hcj
 * 邮箱：2654313873@qq.com
 * 日期：2018/11/5 17
 */
public class FeedbackPresenter extends FeedbackContract.Presenter {


    @Override
    public void getFeedClassifyList() {
        mModel.getFeedClassify(new DataResponseCallback<FeedBackClassifyResponse>() {
            @Override
            public void onSucceed(FeedBackClassifyResponse feedBackClassifyResponse) {
                mView.getFeedClassify(feedBackClassifyResponse);
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

    @Override
    public void sendFeed(final FeedBackRequest request) {
        mModel.sendFeed(request, new DataResponseCallback<FeedBackResponse>() {
            @Override
            public void onSucceed(FeedBackResponse response) {
                mView.showErrorTip(response.getCode(), response.getMsg());
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
