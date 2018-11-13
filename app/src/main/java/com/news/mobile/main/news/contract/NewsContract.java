package com.news.mobile.main.news.contract;

import com.news.mobile.base.BaseModel;
import com.news.mobile.base.BasePresenter;
import com.news.mobile.base.BaseView;
import com.news.mobile.entiyt.NewsInfoResponse;
import com.news.mobile.entiyt.NewsSharedContent;
import com.news.mobile.entiyt.request.NewsListRequest;
import com.news.mobile.entiyt.request.PariseRequest;
import com.news.mobile.entiyt.request.ShareNewsRequest;
import com.news.mobile.entiyt.request.SharedRequest;
import com.news.mobile.entiyt.request.SharedVistRequest;
import com.news.mobile.http.DataCallBack;
import com.news.mobile.http.DataResponseCallback;

/**
 * Created by sfy. on 2018/11/3 0003.
 */

public interface NewsContract {

    abstract class Model extends BaseModel {

        public abstract void requestNewsList(NewsListRequest request, DataResponseCallback<NewsInfoResponse> callback);

        public abstract void requestParise(PariseRequest request, DataResponseCallback<String> callback);

        public abstract void requestSharedConttent(ShareNewsRequest request, DataResponseCallback<String> callback);

        public abstract void requestSharedVisit(SharedVistRequest request, DataCallBack callBack);
    }

    interface View extends BaseView {

        NewsListRequest getnewsListRequest();

        PariseRequest getPariseRequest(String newsId, String dutype);

        ShareNewsRequest getShareNewRequest(String newsid, String key_code);

        void getNewsListSuccess(NewsInfoResponse infoResponse, boolean isRefresh);

        void pariseSuccess();

        void getSharedConttentSuccess(NewsSharedContent content, final int type);

        void sharednewsSuccess();
    }

    abstract class Presenter extends BasePresenter<View, Model> {

        public abstract void getNewsList(boolean isRefresh);//获取新闻列表

        public abstract void getParise(PariseRequest request);//点赞

        public abstract void getSharedConttent(ShareNewsRequest request, int type);

        public abstract String getShareJson(NewsSharedContent content, final int type);

        public abstract void shareVisit(String newsid);

    }

}
