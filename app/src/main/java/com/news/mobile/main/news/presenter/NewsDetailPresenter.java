package com.news.mobile.main.news.presenter;

import com.news.mobile.base.BaseResponse;
import com.news.mobile.entiyt.NewsAddGoodResponse;
import com.news.mobile.entiyt.NewsDetailResponse;
import com.news.mobile.entiyt.NewsGoldResponse;
import com.news.mobile.entiyt.NewsInfoResponse;
import com.news.mobile.entiyt.request.NewsAddGoodRequest;
import com.news.mobile.entiyt.request.NewsDetailRequest;
import com.news.mobile.entiyt.request.NewsGoldRequest;
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
}
