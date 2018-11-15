package com.news.mobilephone.main.web.contract;

import com.news.mobilephone.base.BaseModel;
import com.news.mobilephone.base.BasePresenter;
import com.news.mobilephone.base.BaseView;
import com.news.mobilephone.entiyt.ShareResponse;
import com.news.mobilephone.entiyt.request.ShareVisitRequest;
import com.news.mobilephone.http.DataCallBack;

/**
 * 作者：created by hcj
 * 邮箱：2654313873@qq.com
 * 日期：2018/11/5 13
 */
public interface WebContract {

    abstract class Model extends BaseModel {
        public abstract void shareVisit(ShareVisitRequest request, final DataCallBack dataCacheBack);

        public abstract void getShareInfo(final DataCallBack dataCacheBack);
    }

    interface View extends BaseView {
        void onBindWxSucceed(int count);
        void onShareInfo(ShareResponse shareResponse);
    }

    abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void shareVisit(String response, String videoType, int type);

        public abstract void getShareInfo();
    }
}
