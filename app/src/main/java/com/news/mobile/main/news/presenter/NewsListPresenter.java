package com.news.mobile.main.news.presenter;

import com.news.mobile.base.BaseResponse;
import com.news.mobile.entiyt.NewsInfoResponse;
import com.news.mobile.entiyt.request.PariseRequest;
import com.news.mobile.entiyt.request.ShareNewsRequest;
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
    public void getSharedConttent(final ShareNewsRequest request) {
        mModel.requestSharedConttent(request, new DataResponseCallback<String>() {
            @Override
            public void onSucceed(String s) {

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
