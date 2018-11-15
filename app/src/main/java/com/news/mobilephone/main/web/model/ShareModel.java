package com.news.mobilephone.main.web.model;

import android.content.Context;

import com.google.gson.Gson;
import com.news.mobilephone.R;
import com.news.mobilephone.base.BaseResponse;
import com.news.mobilephone.entiyt.TaskResponse;
import com.news.mobilephone.entiyt.request.ShareVisitRequest;
import com.news.mobilephone.entiyt.request.TaskRequest;
import com.news.mobilephone.entiyt.request.TaskRequestAdVideo;
import com.news.mobilephone.entiyt.request.VideoReportRequest;
import com.news.mobilephone.http.DataCallBack;
import com.news.mobilephone.http.MyRetrofit;
import com.news.mobilephone.utils.ToastUtils;

/**
 * 作者：created by hcj
 * 邮箱：2654313873@qq.com
 * 日期：2018/11/5 13
 */
public class ShareModel {
    MyRetrofit mMyRetrofit;
    private Context mContext;

    public ShareModel(Context context) {
        this.mContext = context;
        mMyRetrofit = new MyRetrofit(context);
    }

    public void videoReport(VideoReportRequest request, final DataCallBack dataCacheBack) {
        mMyRetrofit.videoRepost(request, new DataCallBack() {
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


    public void shareVisit(ShareVisitRequest request, final DataCallBack dataCacheBack) {
        mMyRetrofit.shareVisit(request, new DataCallBack() {
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

    public void getShareInfo(final DataCallBack dataCacheBack) {
        mMyRetrofit.getShareInfo(new DataCallBack() {
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


    public void getAdVideoByTask(final TaskRequestAdVideo request, final DataCallBack cacheBack, final int coins, final String type) {
        mMyRetrofit.getAdVideoByTask(request, new DataCallBack() {
            @Override
            public void onComplete() {
                cacheBack.onComplete();
            }

            @Override
            public void onSucceed(String json) {
                TaskResponse taskResponse = new Gson().fromJson(json, TaskResponse.class);
                if (request.getId().equals(TaskRequest.TASK_ID_READ_SHARE_AD + "")) {
                    String message = mContext.getString(R.string.sharing_reward);
                    String addMessage = "";
                    addMessage = "+" + 10 + "" + mContext.getString(R.string.me_coins);
                    ToastUtils.showZDYToast(mContext, addMessage, message);
                }
                cacheBack.onSucceed(taskResponse.getData().getCount() + "");
            }

            @Override
            public void onFail(BaseResponse baseResponse) {
                cacheBack.onFail(baseResponse);
            }
        });
    }
}
