package com.news.mobilephone.main.bind.contract;


import com.news.mobilephone.base.BaseModel;
import com.news.mobilephone.base.BasePresenter;
import com.news.mobilephone.base.BaseView;
import com.news.mobilephone.entiyt.request.BindEmailRequest;
import com.news.mobilephone.entiyt.request.GetCodeRequest;
import com.news.mobilephone.http.DataCallBack;
import com.news.mobilephone.http.DataResponseCallback;

/**
 * Created by sfy. on 2018/11/1 0001.
 */

public interface BindEmailContract {

    abstract class Model extends BaseModel {

        public abstract void getSmsCode(GetCodeRequest request, DataCallBack callBack);

        public abstract void requestBindEmail(BindEmailRequest request, DataResponseCallback<String> callback);
    }

    interface View extends BaseView {

        GetCodeRequest getSmsRequest();

        BindEmailRequest getBindEmailRequest();

        void getsmsCodeSuccess();

        void bindEmailSuccess(String s);

    }

    abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void getSmsCode(GetCodeRequest request);

        public abstract void bindEmail();

    }
}
