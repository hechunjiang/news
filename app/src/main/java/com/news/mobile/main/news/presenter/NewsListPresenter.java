package com.news.mobile.main.news.presenter;

import com.google.gson.Gson;
import com.news.mobile.base.BaseResponse;
import com.news.mobile.entiyt.JsShareType;
import com.news.mobile.entiyt.NewsInfoResponse;
import com.news.mobile.entiyt.NewsSharedContent;
import com.news.mobile.entiyt.request.PariseRequest;
import com.news.mobile.entiyt.request.ShareNewsRequest;
import com.news.mobile.entiyt.request.SharedVistRequest;
import com.news.mobile.http.DataCallBack;
import com.news.mobile.http.DataResponseCallback;
import com.news.mobile.main.news.contract.NewsContract;

/**
 * Created by sfy. on 2018/11/3 0003.
 */

public class NewsListPresenter extends NewsContract.Presenter {

    @Override
    public void getNewsList(final boolean isRefresh) {
        mModel.requestNewsList(mView.getnewsListRequest(), new DataResponseCallback<NewsInfoResponse>() {
            @Override
            public void onSucceed(NewsInfoResponse infoResponse) {
                mView.getNewsListSuccess(infoResponse, isRefresh);
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
    public void getParise(final PariseRequest request) {
        mModel.requestParise(request, new DataResponseCallback<String>() {
            @Override
            public void onSucceed(String s) {
                mView.pariseSuccess();
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
    public void getSharedConttent(final ShareNewsRequest request, final int type) {
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
