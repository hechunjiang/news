package com.news.mobilephone.main.mine.contract;

import com.news.mobilephone.base.BaseModel;
import com.news.mobilephone.base.BasePresenter;
import com.news.mobilephone.base.BaseView;
import com.news.mobilephone.entiyt.request.GetCodeRequest;
import com.news.mobilephone.entiyt.request.ResetPassRequst;
import com.news.mobilephone.http.DataCallBack;

/**
 * 作者：created by hcj
 * 邮箱：2654313873@qq.com
 * 日期：2018/11/4 17
 */
public interface FindPassContract {
    /***
     * 找回密码
     */
    abstract class Model extends BaseModel {

        public abstract void requestFindPassCode(GetCodeRequest request, DataCallBack callBack);

        public abstract void requestResetPassReset(ResetPassRequst requst, DataCallBack callBack);
    }

    interface View extends BaseView {
        GetCodeRequest getFindPassCodeRequest();

        ResetPassRequst getResetPassRequset();

        void resetPassSuccess(String s);
    }

    abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void getFindPassCode();

        public abstract void resetNotPass();
    }
}
