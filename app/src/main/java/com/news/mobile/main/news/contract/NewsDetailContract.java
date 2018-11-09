package com.news.mobile.main.news.contract;

import com.news.mobile.base.BaseModel;
import com.news.mobile.base.BasePresenter;
import com.news.mobile.base.BaseView;
import com.news.mobile.entiyt.NewsAddGoodResponse;
import com.news.mobile.entiyt.NewsDetailResponse;
import com.news.mobile.entiyt.NewsGoldResponse;
import com.news.mobile.entiyt.NewsInfoResponse;
import com.news.mobile.entiyt.request.NewsAddGoodRequest;
import com.news.mobile.entiyt.request.NewsDetailRequest;
import com.news.mobile.entiyt.request.NewsGoldRequest;
import com.news.mobile.entiyt.request.NewsListRequest;
import com.news.mobile.http.DataResponseCallback;

/**
 * Created by sfy. on 2018/11/3 0003.
 */

public interface NewsDetailContract {

    abstract class Model extends BaseModel {

        public abstract void requestNewsList(NewsDetailRequest request, DataResponseCallback<NewsDetailResponse> callback);
        public abstract void requestGold(NewsGoldRequest request, DataResponseCallback<NewsGoldResponse> callback);
        public abstract void addGood(NewsAddGoodRequest request,DataResponseCallback<NewsAddGoodResponse> callback);
    }

    interface View extends BaseView {
        void getNewsListSuccess(NewsDetailResponse.DataBean response);
        void getGoldSuccess(NewsGoldResponse response);
        void addGood(NewsAddGoodResponse response);
    }

    abstract class Presenter extends BasePresenter<View, Model> {

        public abstract void getNewsDetail(NewsDetailRequest request);//获取新闻
        public abstract void getNewsGold(NewsGoldRequest request);//加金币
        public abstract void addGood(NewsAddGoodRequest request);//点赞
    }

}
