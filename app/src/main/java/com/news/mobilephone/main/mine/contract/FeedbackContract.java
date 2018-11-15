package com.news.mobilephone.main.mine.contract;

import com.news.mobilephone.base.BaseModel;
import com.news.mobilephone.base.BasePresenter;
import com.news.mobilephone.base.BaseView;
import com.news.mobilephone.entiyt.FeedBackClassifyResponse;
import com.news.mobilephone.entiyt.FeedBackResponse;
import com.news.mobilephone.entiyt.request.FeedBackRequest;
import com.news.mobilephone.http.DataResponseCallback;

/**
 * 作者：created by hcj
 * 邮箱：2654313873@qq.com
 * 日期：2018/11/5 17
 */
public interface FeedbackContract {
    /**
     * 意见反馈
     */

    abstract class Model extends BaseModel {
        public abstract void getFeedClassify(DataResponseCallback<FeedBackClassifyResponse> callBack);

        public abstract void sendFeed(FeedBackRequest request, DataResponseCallback<FeedBackResponse> callBack);
    }

    interface View extends BaseView {
        void getFeedClassify(FeedBackClassifyResponse response);

        void sendFeed(FeedBackResponse response);
    }

    abstract class Presenter extends BasePresenter<View, Model> {

        public abstract void getFeedClassifyList();

        public abstract void sendFeed(FeedBackRequest request);

    }
}
