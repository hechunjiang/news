package com.news.mobile.main.mine.presenter;

import com.news.mobile.base.BaseResponse;
import com.news.mobile.entiyt.FeedBackClassifyResponse;
import com.news.mobile.entiyt.FeedBackResponse;
import com.news.mobile.entiyt.request.FeedBackRequest;
import com.news.mobile.http.DataResponseCallback;
import com.news.mobile.main.mine.contract.FeedbackContract;

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
