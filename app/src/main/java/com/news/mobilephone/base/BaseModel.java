package com.news.mobilephone.base;


import com.news.mobilephone.MyApplication;
import com.news.mobilephone.http.MyRetrofit;

/**
 * 作者：created by hcj
 * 邮箱：2654313873@qq.com
 * 日期：2018/11/5 17
 */
public abstract class BaseModel {

    protected MyRetrofit getRetrofit() {

        return MyRetrofit.getInstance();
    }

}
