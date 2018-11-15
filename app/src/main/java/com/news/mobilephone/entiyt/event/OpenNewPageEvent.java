package com.news.mobilephone.entiyt.event;

/**
 * 作者：created by hcj
 * 邮箱：2654313873@qq.com
 * 日期：2018/11/5 14
 */
public class OpenNewPageEvent {
    private String url;
    private int type = -1;

    public OpenNewPageEvent(String url) {
        this.url = url;
    }

    public OpenNewPageEvent(String url, int type) {
        this.url = url;
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
