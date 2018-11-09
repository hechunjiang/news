package com.news.mobile.main.mine.model;

import android.util.Log;

import com.google.gson.Gson;
import com.news.mobile.base.BaseResponse;
import com.news.mobile.entiyt.UserDatasResponse;
import com.news.mobile.entiyt.request.UserMsgRequest;
import com.news.mobile.http.DataCallBack;
import com.news.mobile.http.DataResponseCallback;
import com.news.mobile.main.mine.contract.PersonContract;

import java.io.File;

/**
 * 作者：created by hcj
 * 邮箱：2654313873@qq.com
 * 日期：2018/11/5 21
 */
public class PersonModel extends PersonContract.Model {

    @Override
    public void requestUserInfo(final DataResponseCallback<UserDatasResponse> callback) {
        getRetrofit().getUserPerSonWorkDetails(new DataCallBack() {
            @Override
            public void onComplete() {
                callback.onComplete();
            }

            @Override
            public void onSucceed(String json) {
                UserDatasResponse datasResponse = new Gson().fromJson(json, UserDatasResponse.class);
                callback.onSucceed(datasResponse);
            }

            @Override
            public void onFail(BaseResponse baseResponse) {
                callback.onFail(baseResponse);
            }
        });
    }

    @Override
    public void requestUploadHeadImage(File file, final DataCallBack callBack) {
        getRetrofit().uploadImage(file, new DataCallBack() {
            @Override
            public void onComplete() {
                callBack.onComplete();
            }

            @Override
            public void onSucceed(String json) {
//                    new JSONObject(json).getJSONObject("data").getString("markId")
                callBack.onSucceed(json);

            }

            @Override
            public void onFail(BaseResponse baseResponse) {
                callBack.onFail(baseResponse);
            }
        });
    }

    @Override
    public void requestUploadPerMsg(UserMsgRequest request, final DataCallBack callBack) {
        getRetrofit().setUserMsg(request, new DataCallBack() {
            @Override
            public void onComplete() {
                callBack.onComplete();
            }

            @Override
            public void onSucceed(String json) {
                callBack.onSucceed(json);
                Log.d("onSucceed", "onSucceed: " + json);
            }

            @Override
            public void onFail(BaseResponse baseResponse) {
                callBack.onFail(baseResponse);
            }
        });
    }


}
