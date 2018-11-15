package com.news.mobilephone.entiyt.request;

import com.google.gson.annotations.SerializedName;
import com.news.mobilephone.base.BaseRequest;

/**
 * 作者：created by hcj
 * 邮箱：2654313873@qq.com
 * 日期：2018/11/4 17
 */
public class LoginRequest extends BaseRequest {

    @SerializedName("mail")
    private String account;

    @SerializedName("pass")
    private String password;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
