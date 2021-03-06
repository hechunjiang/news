package com.news.mobilephone.main.mine.presenter;

import android.annotation.SuppressLint;

import com.google.gson.Gson;
import com.news.mobilephone.entiyt.JsShareType;
import com.news.mobilephone.R;
import com.news.mobilephone.base.BaseResponse;
import com.news.mobilephone.entiyt.ApprenticePageDataResponse;
import com.news.mobilephone.entiyt.JsShareResponse;
import com.news.mobilephone.entiyt.request.ShareVisitRequest;
import com.news.mobilephone.entiyt.request.SharedRequest;
import com.news.mobilephone.http.DataCallBack;
import com.news.mobilephone.http.MyRetrofit;
import com.news.mobilephone.main.mine.contract.EarnActivityContract;
import com.news.mobilephone.utils.Common;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * 作者：created by hcj
 * 邮箱：2654313873@qq.com
 * 日期：2018/11/5 12
 */
public class EarnAPresenter extends EarnActivityContract.Presenter {
    private JsShareType jsShareType;

    @Override
    public void getDatas() {
        if (mView == null) return;
        MyRetrofit.getInstance(mContext).apprenticePageData(new DataCallBack() {
            @Override
            public void onComplete() {

            }

            @Override
            public void onSucceed(String json) {
                ApprenticePageDataResponse apprenticePageDataResponse =
                        new Gson().fromJson(json, ApprenticePageDataResponse.class);
                mView.setViewData(apprenticePageDataResponse);
            }

            @Override
            public void onFail(BaseResponse baseResponse) {
                mView.setViewData(null);
            }
        });


    }

    /**
     * 获取分享信息
     */
    @Override
    public void getShareDatas(final int type) {
        String s_type = "";
        SharedRequest request = new SharedRequest();
        if (type == Common.SHARE_TYPE_TWITTER) {
            s_type = "twitter";
        } else if (type == Common.SHARE_TYPE_FACEBOOK) {
            s_type = "facebook";
        } else if (type == Common.SHARE_TYPE_LINKEDIN) {
            s_type = "linkin";
        }
        request.setType(s_type);

        mModel.inviteShareDatas(request, new DataCallBack() {
            @Override
            public void onComplete() {

            }

            @Override
            public void onSucceed(String json) {
                try {
                    JSONObject jsonObject = new JSONObject(json);
                    jsonObject = jsonObject.getJSONObject("data");
                    jsonObject = jsonObject.getJSONObject("default");
                    jsShareType = new Gson().fromJson(jsonObject.toString(), JsShareType.class);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                if (mView != null) mView.toShare(type, jsShareType);
            }

            @Override
            public void onFail(BaseResponse baseResponse) {

            }
        });

    }

    //分享计数
    @Override
    public void shareVisit(String response, String videoType, int type) {
        JsShareResponse mJsShareResponse = new Gson().fromJson(response, JsShareResponse.class);
        ShareVisitRequest request = new ShareVisitRequest();
        request.setActivityType(videoType);
        request.setCode(mJsShareResponse.getCode() + "");
        request.setShareChannel(type + "");
        mModel.shareVisit(request, new DataCallBack() {
            @Override
            public void onComplete() {

            }

            @Override
            public void onSucceed(String json) {

            }

            @Override
            public void onFail(BaseResponse baseResponse) {

            }
        });
    }

    @SuppressLint("StringFormatMatches")
    @Override
    public void vw_toplayout(int friendsize) {
        if (friendsize == 0) {
            mView.setViewupdate(mContext.getResources().getString(R.string.earn_title), 130);
        } else if (friendsize >= 0 && friendsize < 2) {
            mView.setViewupdate(String.format(mContext.getResources().getString(R.string.earn_value), friendsize, (2 - friendsize), 3000), 153);
        } else if (friendsize >= 2 && friendsize < 4) {
            mView.setViewupdate(String.format(mContext.getResources().getString(R.string.earn_value), friendsize, (4 - friendsize), 6000), 153);
        } else if (friendsize >= 4 && friendsize < 7) {
            mView.setViewupdate(String.format(mContext.getResources().getString(R.string.earn_value), friendsize, (7 - friendsize), 12000), 153);
        } else if (friendsize >= 7 && friendsize < 14) {
            mView.setViewupdate(String.format(mContext.getResources().getString(R.string.earn_value), friendsize, (14 - friendsize), 24000), 153);
        } else {
            mView.setViewupdate(mContext.getResources().getString(R.string.earn_title_stock), 130);
        }
    }

}
