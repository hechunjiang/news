package com.news.mobile.http;


import com.news.mobile.base.BaseResponse;

/**
 * auther: sunfuyi
 * data: 2018/5/15
 * effect:
 */
public interface DataResponseCallback<T> {
    void onSucceed(T t);

    void onFail(BaseResponse response);

    void onComplete();
}
