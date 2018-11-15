package com.news.mobilephone.entiyt.request;

import com.news.mobilephone.base.BaseRequest;

/**
 * 作者：created by hcj
 * 邮箱：2654313873@qq.com
 * 日期：2018/11/4 16
 */
public class PlatformLogin extends BaseRequest {
    private String twitter_id;
    private String fb_id;
    private String lk_id;
    private String platform;

    public String getLk_id() {
        return lk_id;
    }

    public void setLk_id(String lk_id) {
        this.lk_id = lk_id;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getTwitter_id() {
        return twitter_id;
    }

    public void setTwitter_id(String twitter_id) {
        this.twitter_id = twitter_id;
    }

    public String getFb_id() {
        return fb_id;
    }

    public void setFb_id(String fb_id) {
        this.fb_id = fb_id;
    }
}

