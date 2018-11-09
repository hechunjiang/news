package com.news.mobile.main.mine.contract;

import com.news.mobile.base.BaseModel;
import com.news.mobile.base.BasePresenter;
import com.news.mobile.base.BaseView;
import com.news.mobile.entiyt.FeedBackClassifyResponse;
import com.news.mobile.entiyt.FeedBackResponse;
import com.news.mobile.entiyt.request.FeedBackRequest;
import com.news.mobile.http.DataResponseCallback;

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
