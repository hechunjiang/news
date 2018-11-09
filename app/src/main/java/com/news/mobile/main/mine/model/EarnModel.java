package com.news.mobile.main.mine.model;

import com.news.mobile.base.BaseResponse;
import com.news.mobile.entiyt.request.ShareVisitRequest;
import com.news.mobile.entiyt.request.SharedRequest;
import com.news.mobile.http.DataCallBack;
import com.news.mobile.main.mine.contract.EarnActivityContract;

/**
 * 作者：created by hcj
 * 邮箱：2654313873@qq.com
 * 日期：2018/11/5 12
 */
public class EarnModel extends EarnActivityContract.Model {

    //分享计数
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
    public void inviteShareDatas(SharedRequest request, final DataCallBack callBack) {
        getRetrofit().inviteShareDatas(request, new DataCallBack() {
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

    //分享
}