package com.news.mobile.main.web.presenter;

import android.content.Context;
import android.os.Handler;


import com.google.gson.Gson;
import com.news.mobile.base.BasePresenter;
import com.news.mobile.base.BaseResponse;
import com.news.mobile.entiyt.JsShareResponse;
import com.news.mobile.entiyt.ShareResponse;
import com.news.mobile.entiyt.request.ShareVisitRequest;
import com.news.mobile.http.DataCallBack;
import com.news.mobile.main.web.contract.JsWebView;
import com.news.mobile.main.web.model.ShareModel;

/**
 * 作者：created by hcj
 * 邮箱：2654313873@qq.com
 * 日期：2018/11/5 13
 */
public class WebPresenter extends BasePresenter {
    private JsWebView mJsWebView;
    private Context mContext;
    private ShareModel mShareModel;
    private Handler mHandler = new Handler();

    public WebPresenter(JsWebView jsWebView, Context context) {
        mJsWebView = jsWebView;
        mContext = context;
        mShareModel = new ShareModel(context);
    }

    public WebPresenter(Context context) {
        mContext = context;
        mShareModel = new ShareModel(context);
    }

    /**
     * 分享计数
     *
     * @param response
     */
    public void shareVisit(String response, String videoType, int type) {
        JsShareResponse mJsShareResponse = new Gson().fromJson(response, JsShareResponse.class);
        ShareVisitRequest request = new ShareVisitRequest();
        request.setActivityType(videoType);
        request.setCode(mJsShareResponse.getCode() + "");
        request.setShareChannel(type + "");
        mShareModel.shareVisit(request, new DataCallBack() {
            @Override
            public void onSucceed(String s) {

            }

            @Override
            public void onFail(BaseResponse response) {

            }

            @Override
            public void onComplete() {

            }
        });
    }


    /**
     * 获取分享信息
     */
    public void getShareInfo() {
        mShareModel.getShareInfo(new DataCallBack() {
            @Override
            public void onSucceed(String s) {
//                JsShareType jsShareType = new Gson().fromJson(s, JsShareType.class);
                ShareResponse shareResponse = new Gson().fromJson(s, ShareResponse.class);
                mJsWebView.onShareInfo(shareResponse);
            }

            @Override
            public void onFail(BaseResponse response) {
            }

            @Override
            public void onComplete() {
            }
        });
    }

}
