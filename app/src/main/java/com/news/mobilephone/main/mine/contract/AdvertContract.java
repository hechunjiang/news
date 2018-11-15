package com.news.mobilephone.main.mine.contract;

import com.news.mobilephone.base.BaseModel;
import com.news.mobilephone.base.BasePresenter;
import com.news.mobilephone.base.BaseView;
import com.news.mobilephone.entiyt.request.PushTokenRequest;
import com.news.mobilephone.http.DataCallBack;

/**
 * 作者：created by hcj
 * 邮箱：2654313873@qq.com
 * 日期：2018/11/5 18
 */
public interface AdvertContract {
    /**
     * 临时登录
     */
    abstract class Model extends BaseModel {
        public abstract void requestIstemp(DataCallBack dataCallBack);

        public abstract void pushToken(PushTokenRequest request, DataCallBack callBack);
    }

    interface View extends BaseView {
        void tempLoginSuccess(String s);

        PushTokenRequest onPushTokenRequest();
    }

    abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void checkIstemp();

        public abstract void pushToken();
    }
}
