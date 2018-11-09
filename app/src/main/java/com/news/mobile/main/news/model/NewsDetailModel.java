package com.news.mobile.main.news.model;

import com.google.gson.Gson;
import com.news.mobile.base.BaseResponse;
import com.news.mobile.entiyt.NewsAddGoodResponse;
import com.news.mobile.entiyt.NewsDetailResponse;
import com.news.mobile.entiyt.NewsGoldResponse;
import com.news.mobile.entiyt.NewsInfoResponse;
import com.news.mobile.entiyt.request.NewsAddGoodRequest;
import com.news.mobile.entiyt.request.NewsDetailRequest;
import com.news.mobile.entiyt.request.NewsGoldRequest;
import com.news.mobile.entiyt.request.NewsListRequest;
import com.news.mobile.http.DataCallBack;
import com.news.mobile.http.DataResponseCallback;
import com.news.mobile.main.news.contract.NewsDetailContract;

/**
 * Created by sfy. on 2018/11/3 0003.
 */

public class NewsDetailModel extends NewsDetailContract.Model {

    @Override
    public void requestNewsList(NewsDetailRequest request,final DataResponseCallback<NewsDetailResponse> callback) {
        getRetrofit().requestNewsDetail(request, new DataCallBack() {
            @Override
            public void onComplete() {
                callback.onComplete();
            }

            @Override
            public void onSucceed(String json) {
                NewsDetailResponse infoResponse = new Gson().fromJson(json, NewsDetailResponse.class);
                callback.onSucceed(infoResponse);
            }

            @Override
            public void onFail(BaseResponse baseResponse) {
                callback.onFail(baseResponse);
            }
        });
    }

    @Override
    public void requestGold(NewsGoldRequest request,final DataResponseCallback<NewsGoldResponse> callback) {
        getRetrofit().requestNewsGold(request, new DataCallBack() {
            @Override
            public void onComplete() {
                callback.onComplete();
            }

            @Override
            public void onSucceed(String json) {
                NewsGoldResponse infoResponse = new Gson().fromJson(json, NewsGoldResponse.class);
                callback.onSucceed(infoResponse);
            }

            @Override
            public void onFail(BaseResponse baseResponse) {
                callback.onFail(baseResponse);
            }
        });
    }

    @Override
    public void addGood(NewsAddGoodRequest request,final DataResponseCallback<NewsAddGoodResponse> callback) {
        getRetrofit().addGood(request, new DataCallBack() {
            @Override
            public void onComplete() {
                callback.onComplete();
            }

            @Override
            public void onSucceed(String json) {
                NewsAddGoodResponse infoResponse = new Gson().fromJson(json, NewsAddGoodResponse.class);
                callback.onSucceed(infoResponse);
            }

            @Override
            public void onFail(BaseResponse baseResponse) {
                callback.onFail(baseResponse);
            }
        });
    }
}
