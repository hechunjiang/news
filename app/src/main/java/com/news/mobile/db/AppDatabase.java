package com.news.mobile.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.news.mobile.entiyt.NewsDetailResponse;

/**
 * @Author weiwei
 * create by 2018/11/9
 * Des: <功能简述>
 * 代码不优雅，写锤子代码
 */

@Database(entities = {NewsDetailResponse.DataBean.class},version = 1)
public  abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase INSTANCE;

    public static AppDatabase getDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                    Room.databaseBuilder(context, AppDatabase.class, "news_db")
                            .allowMainThreadQueries()  //不开启主线程查询
                            // .addMigrations(MIGRATION_1_2) 升级数据库版本 version = 2
                            // .addMigrations(MIGRATION_1_2, MIGRATION_2_3) 升级数据库版本 version = 3
                            .build();
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }

    public abstract NewsDao newsDao();
}
