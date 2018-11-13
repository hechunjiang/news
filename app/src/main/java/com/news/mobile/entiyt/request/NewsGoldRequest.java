package com.news.mobile.entiyt.request;

import com.news.mobile.base.BaseRequest;

/**
 * 作者：created by hcj
 * 邮箱：2654313873@qq.com
 * 日期：2018/11/6 11
 */
public class NewsGoldRequest extends BaseRequest {

    private String id;
    private String news_id;
    private String debug;

    public String getNews_id() {
        return news_id;
    }

    public void setNews_id(String news_id) {
        this.news_id = news_id;
    }

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
