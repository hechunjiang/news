package com.news.mobilephone.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.news.mobilephone.entiyt.NewsDetailResponse;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

/**
 * @Author weiwei
 * create by 2018/11/9
 * Des: <功能简述>
 * 代码不优雅，写锤子代码
 */

@Dao
public interface NewsDao {

    @Query("select * from news where id = :id")
    NewsDetailResponse.DataBean getNews(String id);

    @Query("select * from news")
    List<NewsDetailResponse.DataBean> getNewsAll();

    @Insert(onConflict = REPLACE)
    void insert(NewsDetailResponse.DataBean news);

    @Update
    void update(NewsDetailResponse.DataBean news);

    @Delete
    void delete(NewsDetailResponse.DataBean news);

    @Delete
    void delete(List<NewsDetailResponse.DataBean> list);
}
