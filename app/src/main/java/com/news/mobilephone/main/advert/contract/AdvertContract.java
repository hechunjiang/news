package com.news.mobilephone.main.advert.contract;

import com.news.mobilephone.base.BaseModel;
import com.news.mobilephone.base.BasePresenter;
import com.news.mobilephone.base.BaseView;
import com.news.mobilephone.http.DataCallBack;

/**
 * Created by sfy. on 2018/11/2 0002.
 */

public interface AdvertContract {

    abstract class Model extends BaseModel {

        public abstract void requestTempLogin(DataCallBack callBack);

    }

    interface View extends BaseView {

        void templeLoginSuccess();
    }

    abstract class Presenter extends BasePresenter<View, Model> {
        //临时登录
        public abstract void TempLogin();
    }
}
