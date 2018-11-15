package com.news.mobilephone.main.mine.presenter;

import com.google.gson.Gson;
import com.news.mobilephone.entiyt.JsShareType;
import com.news.mobilephone.base.BaseResponse;
import com.news.mobilephone.entiyt.UserInfoResponse;
import com.news.mobilephone.entiyt.request.SharedRequest;
import com.news.mobilephone.http.DataResponseCallback;
import com.news.mobilephone.main.mine.contract.MineFContract;
import com.news.mobilephone.utils.Common;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * 作者：created by hcj
 * 邮箱：2654313873@qq.com
 * 日期：2018/11/4 16
 */
public class MineFPresenter extends MineFContract.Presenter {
    private JsShareType jsShareType;

    @Override
    public void getPersonMsg() {

        mModel.requestPersonMsg(new DataResponseCallback<UserInfoResponse>() {
            @Override
            public void onSucceed(UserInfoResponse user) {

                mView.getPersonMsgSuccess(user);

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
    public void getLinkShareUrl(final int type) {
        String s_type = "";
        SharedRequest request = new SharedRequest();
        if (type == Common.SHARE_TYPE_TWITTER) {
            s_type = "twitter";
        } else if (type == Common.SHARE_TYPE_FACEBOOK) {
            s_type = "facebook";
        } else if (type == Common.SHARE_TYPE_INS) {
            s_type = "instgram";
        } else if (type == Common.SHARE_TYPE_WHATS) {
            s_type = "whatsapp";
        }
        request.setType(s_type);

        mModel.requestLinkUrl(request, new DataResponseCallback<String>() {
            @Override
            public void onSucceed(String s) {
                try {
                    JSONObject jsonObject = new JSONObject(s);
                    jsonObject = jsonObject.getJSONObject("data");
                    jsonObject = jsonObject.getJSONObject("default");
                    jsShareType = new Gson().fromJson(jsonObject.toString(), JsShareType.class);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                if (mView != null) mView.toShare(type, jsShareType);
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
