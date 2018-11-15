package com.news.mobilephone.main.web.js;

import com.google.gson.annotations.SerializedName;

/**
 * 作者：created by hcj
 * 邮箱：2654313873@qq.com
 * 日期：2018/11/5 14
 */
public class JsLogin {
    @SerializedName("ticket")
    private String loginTicket;
    @SerializedName("os")
    private String systemName;

    @SerializedName("meid")
    private String meid;
    private String sign;
    private String version;

    private String language;

    public String getVersion() {
        return version;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getMeid() {
        return meid;
    }

    public void setMeid(String meid) {
        this.meid = meid;
    }

    public String getLoginTicket() {
        return loginTicket;
    }

    public void setLoginTicket(String loginTicket) {
        this.loginTicket = loginTicket;
    }

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}
