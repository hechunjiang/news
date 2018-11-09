package com.news.mobile.main.advert.contract;

import com.news.mobile.base.BaseModel;
import com.news.mobile.base.BasePresenter;
import com.news.mobile.base.BaseView;
import com.news.mobile.http.DataCallBack;

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
