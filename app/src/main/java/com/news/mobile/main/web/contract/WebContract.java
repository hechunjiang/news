package com.news.mobile.main.web.contract;

import com.news.mobile.base.BaseModel;
import com.news.mobile.base.BasePresenter;
import com.news.mobile.base.BaseView;
import com.news.mobile.entiyt.ShareResponse;
import com.news.mobile.entiyt.request.ShareVisitRequest;
import com.news.mobile.http.DataCallBack;

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
