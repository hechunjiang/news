package com.news.mobilephone.main.news.model;

import com.google.gson.Gson;
import com.news.mobilephone.base.BaseResponse;
import com.news.mobilephone.entiyt.NewsAddGoodResponse;
import com.news.mobilephone.entiyt.NewsCommonListResponse;
import com.news.mobilephone.entiyt.NewsCommonResponse;
import com.news.mobilephone.entiyt.NewsDetailResponse;
import com.news.mobilephone.entiyt.NewsGoldResponse;
import com.news.mobilephone.entiyt.request.NewsAddGoodRequest;
import com.news.mobilephone.entiyt.request.NewsCommontListRequest;
import com.news.mobilephone.entiyt.request.NewsCommontRequest;
import com.news.mobilephone.entiyt.request.NewsDetailRequest;
import com.news.mobilephone.entiyt.request.NewsGoldRequest;
import com.news.mobilephone.entiyt.request.NewsVisitRequest;
import com.news.mobilephone.entiyt.request.ShareNewsRequest;
import com.news.mobilephone.entiyt.request.SharedVistRequest;
import com.news.mobilephone.http.DataCallBack;
import com.news.mobilephone.http.DataResponseCallback;
import com.news.mobilephone.main.news.contract.NewsDetailContract;

/**
 * Created by sfy. on 2018/11/3 0003.
 */

public class NewsDetailModel extends NewsDetailContract.Model {

    @Override
    public void requestNewsList(NewsDetailRequest request, final DataResponseCallback<NewsDetailResponse> callback) {
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
    public void requestGold(NewsGoldRequest request, final DataResponseCallback<NewsGoldResponse> callback) {
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
    public void addGood(NewsAddGoodRequest request, final DataResponseCallback<NewsAddGoodResponse> callback) {
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

    @Override
    public void getCommontList(NewsCommontListRequest request, final DataResponseCallback<NewsCommonListResponse> callback) {
        getRetrofit().commonList(request, new DataCallBack() {
            @Override
            public void onComplete() {
                callback.onComplete();
            }

            @Override
            public void onSucceed(String json) {
                NewsCommonListResponse infoResponse = new Gson().fromJson(json, NewsCommonListResponse.class);
                callback.onSucceed(infoResponse);
            }

            @Override
            public void onFail(BaseResponse baseResponse) {
                callback.onFail(baseResponse);
            }
        });
    }

    @Override
    public void commont(NewsCommontRequest request, final DataResponseCallback<NewsCommonResponse> callback) {
        getRetrofit().commont(request, new DataCallBack() {
            @Override
            public void onComplete() {
                callback.onComplete();
            }

            @Override
            public void onSucceed(String json) {
                NewsCommonResponse infoResponse = new Gson().fromJson(json, NewsCommonResponse.class);
                callback.onSucceed(infoResponse);
            }

            @Override
            public void onFail(BaseResponse baseResponse) {
                callback.onFail(baseResponse);
            }
        });
    }

    @Override
    public void requestSharedConttent(ShareNewsRequest request, final DataResponseCallback<String> callback) {
        getRetrofit().requestShareNewsConntent(request, new DataCallBack() {
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

    @Override
    public void newsVisit(NewsVisitRequest request, final DataResponseCallback<BaseResponse> callback) {
        getRetrofit().newsVisit(request, new DataCallBack() {
            @Override
            public void onComplete() {
                callback.onComplete();
            }

            @Override
            public void onSucceed(String json) {
                BaseResponse infoResponse = new Gson().fromJson(json, BaseResponse.class);
                callback.onSucceed(infoResponse);
            }

            @Override
            public void onFail(BaseResponse baseResponse) {
                callback.onFail(baseResponse);
            }
        });
    }

    @Override
    public void requestSharedVisit(SharedVistRequest request, final DataCallBack callBack) {
        getRetrofit().requestShareVisit(request, new DataCallBack() {
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
}
