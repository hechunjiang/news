package com.news.mobilephone.entiyt.request;

import com.news.mobilephone.base.BaseRequest;

/**
 * 作者：created by hcj
 * 邮箱：2654313873@qq.com
 * 日期：2018/11/13 10
 */
public class SharedVistRequest extends BaseRequest {
    public String news_id;

    public String code;

    public String du_type;

    public String share_channel;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDu_type() {
        return du_type;
    }

    public void setDu_type(String du_type) {
        this.du_type = du_type;
    }

    public String getShare_channel() {
        return share_channel;
    }

    public void setShare_channel(String share_channel) {
        this.share_channel = share_channel;
    }

    public String getNews_id() {
        return news_id;
    }

    public void setNews_id(String news_id) {
        this.news_id = news_id;
    }
}
