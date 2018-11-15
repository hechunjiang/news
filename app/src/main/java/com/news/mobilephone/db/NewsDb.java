package com.news.mobilephone.db;

import android.content.Context;

import com.news.mobilephone.entiyt.NewsDetailResponse;

import java.util.List;

/**
 * @Author weiwei
 * create by 2018/11/9
 * Des: <功能简述>
 * 代码不优雅，写锤子代码
 */
public class NewsDb {

    private final NewsDao newsDao;
    private final AppDatabase database;

    public NewsDb(Context context){
        database = AppDatabase.getDatabase(context);
        newsDao = database.newsDao();
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

    public void delete(List<NewsDetailResponse.DataBean> list){
        newsDao.delete(list);
    }

    public List<NewsDetailResponse.DataBean> getAll(){
        return newsDao.getNewsAll();
    }

    public void clear(){
        database.clearAllTables();
    }

    public void clearMemLow(int size){
        NewsDao newsDao = database.newsDao();
        List<NewsDetailResponse.DataBean> newsAll = newsDao.getNewsAll();
        if(newsAll != null){
            if(newsAll.size() > size){
                database.clearAllTables();
            }
        }
    }
}
