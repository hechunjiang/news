package com.news.mobilephone.main.news.presenter;

import com.google.gson.Gson;
import com.news.mobilephone.base.BaseResponse;
import com.news.mobilephone.entiyt.JsShareType;
import com.news.mobilephone.entiyt.NewsInfoResponse;
import com.news.mobilephone.entiyt.NewsSharedContent;
import com.news.mobilephone.entiyt.request.PariseRequest;
import com.news.mobilephone.entiyt.request.ShareNewsRequest;
import com.news.mobilephone.entiyt.request.SharedVistRequest;
import com.news.mobilephone.entiyt.request.SignInAdayRequest;
import com.news.mobilephone.http.DataCallBack;
import com.news.mobilephone.http.DataResponseCallback;
import com.news.mobilephone.main.news.contract.NewsContract;

import java.util.Map;

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

        mModel.requestSharedVisit(mView.getSharedRequest(newsid), new DataCallBack() {
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

    @Override
    public void getSignInDay(final String id) {
        final SignInAdayRequest request = new SignInAdayRequest();
        request.setId(id);
        mModel.requestSignInAday(request, new DataResponseCallback<Map<String, String>>() {
            @Override
            public void onSucceed(Map<String, String> map) {
                mView.showGoldCome(Integer.parseInt(map.get("Count")), Integer.parseInt(id), map.get("message"));
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
