package com.news.mobile.main.mine.contract;

import com.news.mobile.JsShareType;
import com.news.mobile.base.BaseModel;
import com.news.mobile.base.BasePresenter;
import com.news.mobile.base.BaseView;
import com.news.mobile.entiyt.UserInfoResponse;
import com.news.mobile.entiyt.request.SharedRequest;
import com.news.mobile.http.DataResponseCallback;

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
