package com.news.mobilephone.main.mine.contract;

import com.news.mobilephone.base.BaseModel;
import com.news.mobilephone.base.BasePresenter;
import com.news.mobilephone.base.BaseView;
import com.news.mobilephone.entiyt.MessageResponse;
import com.news.mobilephone.http.DataResponseCallback;

/**
 * 作者：created by hcj
 * 邮箱：2654313873@qq.com
 * 日期：2018/11/5 16
 */
public interface MessageContract {
    /**
     * 新闻列表
     */

    abstract class Model extends BaseModel {
        public abstract void getMessageList(DataResponseCallback<MessageResponse> callBack);
    }

    interface View extends BaseView {
        void setMessageData(MessageResponse response);
    }

    abstract class Presenter extends BasePresenter<View, Model> {

        public abstract void getMessageList();
    }
}
