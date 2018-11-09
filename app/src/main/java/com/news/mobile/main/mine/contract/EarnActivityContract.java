package com.news.mobile.main.mine.contract;

import com.news.mobile.JsShareType;
import com.news.mobile.base.BaseModel;
import com.news.mobile.base.BasePresenter;
import com.news.mobile.base.BaseView;
import com.news.mobile.entiyt.ApprenticePageDataResponse;
import com.news.mobile.entiyt.request.ShareVisitRequest;
import com.news.mobile.entiyt.request.SharedRequest;
import com.news.mobile.http.DataCallBack;

/**
 * 作者：created by hcj
 * 邮箱：2654313873@qq.com
 * 日期：2018/11/5 11
 */
public interface EarnActivityContract {
    public abstract class Model extends BaseModel {
        //分享计数
        public abstract void shareVisit(ShareVisitRequest request, final DataCallBack dataCacheBack);

        //获取分享信息
        public abstract void inviteShareDatas(SharedRequest request, DataCallBack callBack);
    }

    public interface View extends BaseView {
        void setViewData(ApprenticePageDataResponse apprenticePageDataResponse);

        void setViewupdate(String context, int height);

        void toShare(int type, JsShareType jsShareType);
    }

    public abstract class Presenter extends BasePresenter<View, Model> {

        public abstract void getDatas();

        public abstract void getShareDatas(final int type);

        public abstract void shareVisit(String response, String videoType, int type);

        public abstract void vw_toplayout(int friendsize);
    }
}
