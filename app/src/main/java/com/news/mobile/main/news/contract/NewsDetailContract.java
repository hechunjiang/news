package com.news.mobile.main.news.contract;

import com.news.mobile.base.BaseModel;
import com.news.mobile.base.BasePresenter;
import com.news.mobile.base.BaseView;
import com.news.mobile.entiyt.NewsAddGoodResponse;
import com.news.mobile.entiyt.NewsCommonListResponse;
import com.news.mobile.entiyt.NewsCommonResponse;
import com.news.mobile.entiyt.NewsDetailResponse;
import com.news.mobile.entiyt.NewsGoldResponse;
import com.news.mobile.entiyt.NewsInfoResponse;
import com.news.mobile.entiyt.NewsSharedContent;
import com.news.mobile.entiyt.request.NewsAddGoodRequest;
import com.news.mobile.entiyt.request.NewsCommontListRequest;
import com.news.mobile.entiyt.request.NewsCommontRequest;
import com.news.mobile.entiyt.request.NewsDetailRequest;
import com.news.mobile.entiyt.request.NewsGoldRequest;
import com.news.mobile.entiyt.request.NewsListRequest;
import com.news.mobile.entiyt.request.ShareNewsRequest;
import com.news.mobile.entiyt.request.SharedVistRequest;
import com.news.mobile.http.DataCallBack;
import com.news.mobile.http.DataResponseCallback;

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

        void sharednewsSuccess();
    }

    abstract class Presenter extends BasePresenter<View, Model> {

        public abstract void getNewsDetail(NewsDetailRequest request);//获取新闻

        public abstract void getNewsGold(NewsGoldRequest request);//加金币

        public abstract void addGood(NewsAddGoodRequest request);//点赞

        public abstract void commontList(NewsCommontListRequest request);//评论列表

        public abstract void commont(NewsCommontRequest request); //发布评论

        public abstract void getSharedConttent(ShareNewsRequest request, int type);//获取分享内容


        public abstract String getShareJson(NewsSharedContent content, final int type);

        public abstract void shareVisit(String newsid);
    }

}
