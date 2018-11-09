package com.news.mobile.main.web.model;

import com.news.mobile.base.BaseResponse;
import com.news.mobile.entiyt.request.ShareVisitRequest;
import com.news.mobile.http.DataCallBack;
import com.news.mobile.main.web.contract.WebContract;

/**
 * 作者：created by hcj
 * 邮箱：2654313873@qq.com
 * 日期：2018/11/5 14
 */
public class WebModel extends WebContract.Model {
    @Override
    public void shareVisit(ShareVisitRequest request, final DataCallBack dataCacheBack) {
        getRetrofit().shareVisit(request, new DataCallBack() {
            @Override
            public void onComplete() {
                dataCacheBack.onComplete();
            }

            @Override
            public void onSucceed(String json) {
                dataCacheBack.onSucceed(json);
            }

            @Override
            public void onFail(BaseResponse baseResponse) {
                dataCacheBack.onFail(baseResponse);
            }
        });
    }

    @Override
    public void getShareInfo(final DataCallBack dataCacheBack) {
        getRetrofit().getShareInfo(new DataCallBack() {
            @Override
            public void onComplete() {
                dataCacheBack.onComplete();
            }

            @Override
            public void onSucceed(String json) {
                dataCacheBack.onSucceed(json);
            }

            @Override
            public void onFail(BaseResponse baseResponse) {
                dataCacheBack.onFail(baseResponse);
            }
        });
    }
}
