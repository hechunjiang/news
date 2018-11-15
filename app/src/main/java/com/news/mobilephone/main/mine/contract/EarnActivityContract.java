package com.news.mobilephone.main.mine.contract;

import com.news.mobilephone.entiyt.JsShareType;
import com.news.mobilephone.base.BaseModel;
import com.news.mobilephone.base.BasePresenter;
import com.news.mobilephone.base.BaseView;
import com.news.mobilephone.entiyt.ApprenticePageDataResponse;
import com.news.mobilephone.entiyt.request.ShareVisitRequest;
import com.news.mobilephone.entiyt.request.SharedRequest;
import com.news.mobilephone.http.DataCallBack;

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
