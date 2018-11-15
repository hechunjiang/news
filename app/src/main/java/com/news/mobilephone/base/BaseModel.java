package com.news.mobilephone.base;


import com.news.mobilephone.MyApplication;
import com.news.mobilephone.http.MyRetrofit;

/**
 * auther: sunfuyi
 * data: 2018/5/12
 * effect:
 */
public abstract class BaseModel {

    protected MyRetrofit myRetrofit;

    protected MyRetrofit getRetrofit() {
        if (myRetrofit == null) {
            myRetrofit = new MyRetrofit(MyApplication.getAppContext(), null);
        }
        return myRetrofit;
    }

    protected MyRetrofit getRetrofit(String https) {
        return new MyRetrofit(MyApplication.getAppContext(), https);
    }
}
