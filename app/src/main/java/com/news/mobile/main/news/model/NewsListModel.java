package com.news.mobile.main.news.model;

import com.google.gson.Gson;
import com.news.mobile.base.BaseResponse;
import com.news.mobile.entiyt.NewsInfoResponse;
import com.news.mobile.entiyt.request.NewsListRequest;
import com.news.mobile.entiyt.request.PariseRequest;
import com.news.mobile.entiyt.request.ShareNewsRequest;
import com.news.mobile.entiyt.request.SharedVistRequest;
import com.news.mobile.http.DataCallBack;
import com.news.mobile.http.DataResponseCallback;
import com.news.mobile.main.news.contract.NewsContract;
import com.news.mobile.utils.LogUtil;

/**
 * Created by sfy. on 2018/11/3 0003.
 */

public class NewsListModel extends NewsContract.Model {

    @Override
    public void requestNewsList(NewsListRequest request, final DataResponseCallback<NewsInfoResponse> callback) {

        getRetrofit().requestNewsList(request, new DataCallBack() {
            @Override
            public void onComplete() {
                callback.onComplete();
            }

            @Override
            public void onSucceed(String json) {
                NewsInfoResponse infoResponse = new Gson().fromJson(json, NewsInfoResponse.class);
                LogUtil.showJson("msg", "requestNewsList---" + infoResponse.toString());

                callback.onSucceed(infoResponse);
            }

            @Override
            public void onFail(BaseResponse baseResponse) {
                callback.onFail(baseResponse);
            }
        });
    }

    @Override
    public void requestParise(PariseRequest request, final DataResponseCallback<String> callback) {
        getRetrofit().requestParseNews(request, new DataCallBack() {
            @Override
            public void onComplete() {
                callback.onComplete();
            }

            @Override
            public void onSucceed(String json) {


                LogUtil.showLog(json);
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
