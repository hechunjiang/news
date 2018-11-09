package com.news.mobile.main.mine.model;

import com.google.gson.Gson;
import com.news.mobile.MyApplication;
import com.news.mobile.base.BaseResponse;
import com.news.mobile.entiyt.UserInfoResponse;
import com.news.mobile.entiyt.request.SharedRequest;
import com.news.mobile.http.DataCallBack;
import com.news.mobile.http.DataResponseCallback;
import com.news.mobile.main.mine.contract.MineFContract;
import com.news.mobile.utils.UserSpCache;

/**
 * 作者：created by hcj
 * 邮箱：2654313873@qq.com
 * 日期：2018/11/4 16
 */
public class MineFModel extends MineFContract.Model {
    private UserSpCache mUserSpCache = UserSpCache.getInstance(MyApplication.getAppContext());

    @Override
    public void requestPersonMsg(final DataResponseCallback<UserInfoResponse> callback) {
        getRetrofit().requestPersonMsg(new DataCallBack() {
            @Override
            public void onComplete() {
                callback.onComplete();
            }

            @Override
            public void onSucceed(String json) {
                UserInfoResponse userInfoResponse = new Gson().fromJson(json, UserInfoResponse.class);
                callback.onSucceed(userInfoResponse);
            }

            @Override
            public void onFail(BaseResponse baseResponse) {
                callback.onFail(baseResponse);
            }
        });
    }

    @Override
    public void requestLinkUrl(SharedRequest request, final DataResponseCallback<String> callback) {
        getRetrofit().inviteShareDatas(request, new DataCallBack() {
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


}
