package com.news.mobilephone.main.news.contract;

import com.news.mobilephone.base.BaseModel;
import com.news.mobilephone.base.BasePresenter;
import com.news.mobilephone.base.BaseView;
import com.news.mobilephone.entiyt.NewsInfoResponse;
import com.news.mobilephone.entiyt.NewsSharedContent;
import com.news.mobilephone.entiyt.request.NewsListRequest;
import com.news.mobilephone.entiyt.request.PariseRequest;
import com.news.mobilephone.entiyt.request.ShareNewsRequest;
import com.news.mobilephone.entiyt.request.SharedVistRequest;
import com.news.mobilephone.entiyt.request.SignInAdayRequest;
import com.news.mobilephone.http.DataCallBack;
import com.news.mobilephone.http.DataResponseCallback;

import java.util.Map;

import retrofit2.http.PUT;

/**
 * Created by sfy. on 2018/11/3 0003.
 */

public interface NewsContract {

    abstract class Model extends BaseModel {

        public abstract void requestNewsList(NewsListRequest request, DataResponseCallback<NewsInfoResponse> callback);

        public abstract void requestParise(PariseRequest request, DataResponseCallback<String> callback);

        public abstract void requestSharedConttent(ShareNewsRequest request, DataResponseCallback<String> callback);

        public abstract void requestSharedVisit(SharedVistRequest request, DataCallBack callBack);

        public abstract void requestSignInAday(SignInAdayRequest request, DataResponseCallback<Map<String, String>> callBack);

    }

    interface View extends BaseView {

        NewsListRequest getnewsListRequest();

        PariseRequest getPariseRequest(String newsId, String dutype);

        ShareNewsRequest getShareNewRequest(String newsid, String key_code);

        SharedVistRequest getSharedRequest(String channel);

        void getNewsListSuccess(NewsInfoResponse infoResponse, boolean isRefresh);

        void pariseSuccess();

        void getSharedConttentSuccess(NewsSharedContent content, final int type);

        void sharednewsSuccess();

        void showGoldCome(int count, int type, String masgess);

    }

    abstract class Presenter extends BasePresenter<View, Model> {

        public abstract void getNewsList(boolean isRefresh);//获取新闻列表

        public abstract void getParise(PariseRequest request);//点赞

        public abstract void getSharedConttent(ShareNewsRequest request, int type);

        public abstract String getShareJson(NewsSharedContent content, final int type);

        public abstract void shareVisit(String channel);

        public abstract void getSignInDay(String id);
    }

}
