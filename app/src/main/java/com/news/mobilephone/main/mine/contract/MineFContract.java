package com.news.mobilephone.main.mine.contract;

import com.news.mobilephone.entiyt.JsShareType;
import com.news.mobilephone.base.BaseModel;
import com.news.mobilephone.base.BasePresenter;
import com.news.mobilephone.base.BaseView;
import com.news.mobilephone.entiyt.UserInfoResponse;
import com.news.mobilephone.entiyt.request.SharedRequest;
import com.news.mobilephone.http.DataResponseCallback;

/**
 * 作者：created by hcj
 * 邮箱：2654313873@qq.com
 * 日期：2018/11/4 15
 */
public interface MineFContract {
    abstract class Model extends BaseModel {

        public abstract void requestPersonMsg(DataResponseCallback<UserInfoResponse> callback);

        public abstract void requestLinkUrl(SharedRequest request, DataResponseCallback<String> callback);

    }

    interface View extends BaseView {

        void getPersonMsgSuccess(UserInfoResponse user);

        void toShare(int type, JsShareType jsShareType);

    }

    abstract class Presenter extends BasePresenter<MineFContract.View, MineFContract.Model> {

        public abstract void getPersonMsg();

        public abstract void getLinkShareUrl(final int type);


    }
}
