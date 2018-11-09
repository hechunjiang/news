package com.news.mobile.entiyt.request;

import com.google.gson.annotations.SerializedName;
import com.news.mobile.base.BaseRequest;

/**
 * 作者：created by hcj
 * 邮箱：2654313873@qq.com
 * 日期：2018/11/4 17
 */
public class GetCodeRequest extends BaseRequest {
    @SerializedName("type")
    private String type;   //reg , findpwd
    private String mail;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
