package com.news.mobile.db;

import android.content.Context;

import com.news.mobile.entiyt.NewsDetailResponse;

/**
 * @Author weiwei
 * create by 2018/11/9
 * Des: <功能简述>
 * 代码不优雅，写锤子代码
 */
public class NewsDb {

    private final NewsDao newsDao;

    public NewsDb(Context context){
        newsDao = AppDatabase.getDatabase(context).newsDao();
    }

    public NewsDetailResponse.DataBean getNews(String id){
        return newsDao.getNews(id);
    }

    public void saveNews(NewsDetailResponse.DataBean news){
        newsDao.insert(news);
    }

    public void updateNews(NewsDetailResponse.DataBean news){
        newsDao.update(news);
    }
}
