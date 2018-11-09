package com.news.mobile.main.mine.model;

import com.google.gson.Gson;
import com.news.mobile.base.BaseResponse;
import com.news.mobile.entiyt.FeedBackClassifyResponse;
import com.news.mobile.entiyt.FeedBackResponse;
import com.news.mobile.entiyt.request.FeedBackRequest;
import com.news.mobile.http.DataCallBack;
import com.news.mobile.http.DataResponseCallback;
import com.news.mobile.main.mine.contract.FeedbackContract;

/**
 * 作者：created by hcj
 * 邮箱：2654313873@qq.com
 * 日期：2018/11/5 17
 */
public class FeefbackModel extends FeedbackContract.Model {

    @Override
    public void getFeedClassify(final DataResponseCallback<FeedBackClassifyResponse> callBack) {
        getRetrofit().onFeedClassify(new DataCallBack() {
            @Override
            public void onComplete() {
                callBack.onComplete();
            }

            @Override
            public void onSucceed(String json) {
                FeedBackClassifyResponse response = new Gson().fromJson(json, FeedBackClassifyResponse.class);
                callBack.onSucceed(response);
            }

            @Override
            public void onFail(BaseResponse baseResponse) {
                callBack.onFail(baseResponse);
            }
        });
    }

    @Override
    public void sendFeed(FeedBackRequest request, final DataResponseCallback<FeedBackResponse> callBack) {
        getRetrofit().sendFeedBack(request, new DataCallBack() {
            @Override
            public void onComplete() {
                callBack.onComplete();
            }

            @Override
            public void onSucceed(String json) {
                FeedBackResponse response = new Gson().fromJson(json, FeedBackResponse.class);
                callBack.onSucceed(response);
            }

            @Override
            public void onFail(BaseResponse baseResponse) {
                callBack.onFail(baseResponse);
            }
        });
    }
}
