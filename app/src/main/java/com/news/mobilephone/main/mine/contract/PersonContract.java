package com.news.mobilephone.main.mine.contract;

import com.news.mobilephone.base.BaseModel;
import com.news.mobilephone.base.BasePresenter;
import com.news.mobilephone.base.BaseView;
import com.news.mobilephone.entiyt.UserDatasResponse;
import com.news.mobilephone.entiyt.request.UserMsgRequest;
import com.news.mobilephone.http.DataCallBack;
import com.news.mobilephone.http.DataResponseCallback;

import java.io.File;

/**
 * 作者：created by hcj
 * 邮箱：2654313873@qq.com
 * 日期：2018/11/5 21
 */
public interface PersonContract {
    abstract class Model extends BaseModel {

        public abstract void requestUserInfo(DataResponseCallback<UserDatasResponse> callback);

        public abstract void requestUploadHeadImage(File file, DataCallBack callBack);

        public abstract void requestUploadPerMsg(UserMsgRequest request, DataCallBack callBack);


    }

    interface View extends BaseView {
        UserMsgRequest getUserMsgRequest();

        void setUserInfo(UserDatasResponse userInfo);

        void uploadImageSuccess(String markId);


        void uploadPerMsgSuccess();

    }

    abstract class Presenter extends BasePresenter<View, Model> {
        //获取用户个人信息
        public abstract void getUserDetailsDataInfo(boolean fasle);

        public abstract void uploadeHeadImage(File file);

        public abstract void upLoadPerMsg();


    }
}
