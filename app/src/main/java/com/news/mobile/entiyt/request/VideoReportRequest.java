package com.news.mobile.entiyt.request;

import com.google.gson.annotations.SerializedName;
import com.news.mobile.base.BaseRequest;

/**
 * 作者：created by hcj
 * 邮箱：2654313873@qq.com
 * 日期：2018/11/5 13
 */
public class VideoReportRequest extends BaseRequest {
    @SerializedName("id")
    private String videoId;

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }
}
