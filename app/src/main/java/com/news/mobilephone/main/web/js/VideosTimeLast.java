package com.news.mobilephone.main.web.js;

import com.google.gson.annotations.SerializedName;

/**
 * 作者：created by hcj
 * 邮箱：2654313873@qq.com
 * 日期：2018/11/5 14
 */
public class VideosTimeLast {
    @SerializedName("lastTime")
    private Long lastTime;

    @SerializedName("lookTime")
    private Long lookTime;

    public Long getLastTime() {
        return lastTime;
    }

    public void setLastTime(Long lastTime) {
        this.lastTime = lastTime;
    }

    public Long getLookTime() {
        return lookTime;
    }

    public void setLookTime(Long lookTime) {
        this.lookTime = lookTime;
    }
}
