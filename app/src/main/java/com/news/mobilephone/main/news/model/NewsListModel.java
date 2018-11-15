package com.news.mobilephone.main.news.model;

import com.google.gson.Gson;
import com.news.mobilephone.MyApplication;
import com.news.mobilephone.R;
import com.news.mobilephone.base.BaseResponse;
import com.news.mobilephone.entiyt.NewsInfoResponse;
import com.news.mobilephone.entiyt.TaskSingInResponse;
import com.news.mobilephone.entiyt.request.NewsListRequest;
import com.news.mobilephone.entiyt.request.PariseRequest;
import com.news.mobilephone.entiyt.request.ShareNewsRequest;
import com.news.mobilephone.entiyt.request.SharedVistRequest;
import com.news.mobilephone.entiyt.request.SignInAdayRequest;
import com.news.mobilephone.http.Api;
import com.news.mobilephone.http.DataCallBack;
import com.news.mobilephone.http.DataResponseCallback;
import com.news.mobilephone.main.news.contract.NewsContract;
import com.news.mobilephone.utils.LogUtil;
import com.news.mobilephone.utils.ToastUtils;

import java.util.HashMap;
import java.util.Map;

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

    @Override
    public void requestSignInAday(SignInAdayRequest request, final DataResponseCallback<Map<String, String>> callBack) {
        getRetrofit().requestSignAday(request, new DataCallBack() {
            @Override
            public void onComplete() {
                callBack.onComplete();
            }

            @Override
            public void onSucceed(String json) {
                Map<String, String> map = new HashMap<>();
                TaskSingInResponse taskSingInResponse = new Gson().fromJson(json, TaskSingInResponse.class);
                map.put("Count", taskSingInResponse.getData().getGold_flag() + "");
                map.put("message", taskSingInResponse.getMsg());
                callBack.onSucceed(map);
            }

            @Override
            public void onFail(BaseResponse response) {
                if (response.getCode() == Api.API_CODE_GOLD_FAILD) {
                    //Toast提示用户无法获取更多金币
                    ToastUtils.showLong(MyApplication.getAppContext(), response.getMsg());
                } else if (response.getCode() == -1000001) {
                    ToastUtils.showLong(MyApplication.getAppContext(), MyApplication.getAppContext().getString(R.string.network_unavailable_try_again_later));
                }

            }
        });
    }


}
