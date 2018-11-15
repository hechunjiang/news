package com.news.mobilephone.entiyt.request;

import com.news.mobilephone.base.BaseRequest;

/**
 * 作者：created by hcj
 * 邮箱：2654313873@qq.com
 * 日期：2018/11/6 11
 */
public class NewsDetailRequest extends BaseRequest {

    private String id;
    private String debug;



    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }

    public String getDebug() {
        return debug;
    }

    public void setDebug(String debug) {
        this.debug = debug;
    }
}
