package com.news.mobilephone.entiyt;

import java.io.Serializable;

/**
 * 作者：created by hcj
 * 邮箱：2654313873@qq.com
 * 日期：2018/11/4 16
 */
public class FacebookRegResponse implements Serializable {


    private String nickName;
    private String headImg;
    private String fb_access_token;
    private String fb_id;
    private String sex;

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public String getFb_access_token() {
        return fb_access_token;
    }

    public void setFb_access_token(String fb_access_token) {
        this.fb_access_token = fb_access_token;
    }

    public String getFb_id() {
        return fb_id;
    }

    public void setFb_id(String fb_id) {
        this.fb_id = fb_id;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
