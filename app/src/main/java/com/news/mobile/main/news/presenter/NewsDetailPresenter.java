package com.news.mobile.main.news.presenter;

import com.google.gson.Gson;
import com.news.mobile.base.BaseResponse;
import com.news.mobile.entiyt.JsShareType;
import com.news.mobile.entiyt.NewsAddGoodResponse;
import com.news.mobile.entiyt.NewsCommonListResponse;
import com.news.mobile.entiyt.NewsCommonResponse;
import com.news.mobile.entiyt.NewsDetailResponse;
import com.news.mobile.entiyt.NewsGoldResponse;
import com.news.mobile.entiyt.NewsInfoResponse;
import com.news.mobile.entiyt.NewsSharedContent;
import com.news.mobile.entiyt.request.NewsAddGoodRequest;
import com.news.mobile.entiyt.request.NewsCommontListRequest;
import com.news.mobile.entiyt.request.NewsCommontRequest;
import com.news.mobile.entiyt.request.NewsDetailRequest;
import com.news.mobile.entiyt.request.NewsGoldRequest;
import com.news.mobile.entiyt.request.ShareNewsRequest;
import com.news.mobile.entiyt.request.SharedVistRequest;
import com.news.mobile.http.DataCallBack;
import com.news.mobile.http.DataResponseCallback;
import com.news.mobile.main.news.contract.NewsContract;
import com.news.mobile.main.news.contract.NewsDetailContract;
import com.news.mobile.utils.LogUtil;

/**
 * Created by sfy. on 2018/11/3 0003.
 */

public class NewsDetailPresenter extends NewsDetailContract.Presenter {

    @Override
    public void getNewsDetail(NewsDetailRequest response) {

        mModel.requestNewsList(response, new DataResponseCallback<NewsDetailResponse>() {
            @Override
            public void onSucceed(NewsDetailResponse response) {
                mView.getNewsListSuccess(response.getData());
            }

            @Override
            public void onFail(BaseResponse response) {
                mView.showLoading();
            }

            @Override
            public void onComplete() {

            }
        });
    }

    @Override
    public void getNewsGold(NewsGoldRequest response) {
        mModel.requestGold(response, new DataResponseCallback<NewsGoldResponse>() {
            @Override
            public void onSucceed(NewsGoldResponse response) {
                mView.getGoldSuccess(response);
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
    public void addGood(NewsAddGoodRequest request) {
        mModel.addGood(request, new DataResponseCallback<NewsAddGoodResponse>() {
            @Override
            public void onSucceed(NewsAddGoodResponse response) {
                mView.addGood(response);
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
    public void commontList(NewsCommontListRequest request) {
        mModel.getCommontList(request, new DataResponseCallback<NewsCommonListResponse>() {
            @Override
            public void onSucceed(NewsCommonListResponse response) {
                mView.commontList(response);
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
    public void commont(NewsCommontRequest request) {
        mModel.commont(request, new DataResponseCallback<NewsCommonResponse>() {
            @Override
            public void onSucceed(NewsCommonResponse response) {
                mView.commont(response);
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
    public void getSharedConttent(ShareNewsRequest request, final int type) {
        mModel.requestSharedConttent(request, new DataResponseCallback<String>() {
            @Override
            public void onSucceed(String s) {
                NewsSharedContent content = new Gson().fromJson(s, NewsSharedContent.class);

                mView.getSharedConttentSuccess(content, type);
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
    public String getShareJson(NewsSharedContent content, int type) {
        JsShareType jsShareType = new JsShareType();

        jsShareType.setType(type);
        jsShareType.setTitle(content.getData().getTitle());
        jsShareType.setUrl(content.getData().getUrl());
        jsShareType.setContent(content.getData().getTitle());
        jsShareType.setImgUrl(content.getData().getCover_img());

        return new Gson().toJson(jsShareType);

    }

    @Override
    public void shareVisit(String newsid) {
        SharedVistRequest request = new SharedVistRequest();
        request.setNews_id(newsid);
        mModel.requestSharedVisit(request, new DataCallBack() {
            @Override
            public void onComplete() {

            }

            @Override
            public void onSucceed(String json) {
                mView.sharednewsSuccess();
            }

            @Override
            public void onFail(BaseResponse baseResponse) {
                mView.showErrorTip(baseResponse.getCode(), baseResponse.getMsg());
            }
        });
    }
}
