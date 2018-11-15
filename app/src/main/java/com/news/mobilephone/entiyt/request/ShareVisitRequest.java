package com.news.mobilephone.entiyt.request;

import com.google.gson.annotations.SerializedName;
import com.news.mobilephone.base.BaseRequest;

/**
 * 作者：created by hcj
 * 邮箱：2654313873@qq.com
 * 日期：2018/11/5 12
 */
public class ShareVisitRequest extends BaseRequest {
    public static final String VIDEO_LIST = "videolist";
    public static final String VIDEO_DETAIL = "videodeail";


    @SerializedName("activity_type")
    private String activityType;
    @SerializedName("code")
    private String code;
    @SerializedName("share_channel")
    private String shareChannel;
    @SerializedName("du_type")
    private String duType;
    @SerializedName("vid")
    private String videoId;

    public String getDuType() {
        return duType;
    }

    public void setDuType(String duType) {
        this.duType = duType;
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public String getActivityType() {
        return activityType;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getShareChannel() {
        return shareChannel;
    }

    public void setShareChannel(String shareChannel) {
        this.shareChannel = shareChannel;
    }
}
