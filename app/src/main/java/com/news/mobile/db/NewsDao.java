package com.news.mobile.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.news.mobile.entiyt.NewsDetailResponse;

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

    @Insert(onConflict = REPLACE)
    void insert(NewsDetailResponse.DataBean news);

    @Update
    void update(NewsDetailResponse.DataBean news);

    @Delete
    void delete(NewsDetailResponse.DataBean news);
}
