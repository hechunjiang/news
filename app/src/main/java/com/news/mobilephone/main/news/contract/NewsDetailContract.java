package com.news.mobilephone.main.news.contract;

import com.news.mobilephone.base.BaseModel;
import com.news.mobilephone.base.BasePresenter;
import com.news.mobilephone.base.BaseResponse;
import com.news.mobilephone.base.BaseView;
import com.news.mobilephone.entiyt.NewsAddGoodResponse;
import com.news.mobilephone.entiyt.NewsCommonListResponse;
import com.news.mobilephone.entiyt.NewsCommonResponse;
import com.news.mobilephone.entiyt.NewsDetailResponse;
import com.news.mobilephone.entiyt.NewsGoldResponse;
import com.news.mobilephone.entiyt.NewsSharedContent;
import com.news.mobilephone.entiyt.request.NewsAddGoodRequest;
import com.news.mobilephone.entiyt.request.NewsCommontListRequest;
import com.news.mobilephone.entiyt.request.NewsCommontRequest;
import com.news.mobilephone.entiyt.request.NewsDetailRequest;
import com.news.mobilephone.entiyt.request.NewsGoldRequest;
import com.news.mobilephone.entiyt.request.NewsVisitRequest;
import com.news.mobilephone.entiyt.request.ShareNewsRequest;
import com.news.mobilephone.entiyt.request.SharedVistRequest;
import com.news.mobilephone.http.DataCallBack;
import com.news.mobilephone.http.DataResponseCallback;

/**
 * Created by sfy. on 2018/11/3 0003.
 */

public interface NewsDetailContract {

    abstract class Model extends BaseModel {

        public abstract void requestNewsList(NewsDetailRequest request, DataResponseCallback<NewsDetailResponse> callback);

        public abstract void requestGold(NewsGoldRequest request, DataResponseCallback<NewsGoldResponse> callback);

        public abstract void addGood(NewsAddGoodRequest request, DataResponseCallback<NewsAddGoodResponse> callback);

        public abstract void getCommontList(NewsCommontListRequest request, DataResponseCallback<NewsCommonListResponse> callback);

        public abstract void commont(NewsCommontRequest request, DataResponseCallback<NewsCommonResponse> callback);

        public abstract void requestSharedConttent(ShareNewsRequest request, DataResponseCallback<String> callback);//获取分享内容

        public abstract void newsVisit(NewsVisitRequest request, DataResponseCallback<BaseResponse> callback);//获取分享内容

        public abstract void requestSharedVisit(SharedVistRequest request, DataCallBack callBack);

    }

    interface View extends BaseView {
        void getNewsListSuccess(NewsDetailResponse.DataBean response);

        void getGoldSuccess(NewsGoldResponse response);

        void addGood(NewsAddGoodResponse response);

        void commontList(NewsCommonListResponse response);

        void commont(NewsCommonResponse response);

        void getSharedConttentSuccess(NewsSharedContent content, final int type);

        ShareNewsRequest getShareNewRequest(String newsid, String key_code);

        void visitSuccess();

        void sharednewsSuccess();

        SharedVistRequest getSharedRequest(String channel);


    }

    abstract class Presenter extends BasePresenter<View, Model> {

        public abstract void getNewsDetail(NewsDetailRequest request);//获取新闻

        public abstract void getNewsGold(NewsGoldRequest request);//加金币

        public abstract void addGood(NewsAddGoodRequest request);//点赞

        public abstract void commontList(NewsCommontListRequest request);//评论列表

        public abstract void commont(NewsCommontRequest request); //发布评论

        public abstract void getSharedConttent(ShareNewsRequest request, int type);//获取分享内容


        public abstract String getShareJson(NewsSharedContent content, final int type);

        public abstract void newsVisit(NewsVisitRequest request);

        public abstract void shareVisit(String Channel);
    }

}
