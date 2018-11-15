package com.news.mobilephone.entiyt.request;

import com.news.mobilephone.base.BaseRequest;

/**
 * Created by sfy. on 2018/11/1 0001.
 */

public class BindEmailRequest extends BaseRequest {
    private String mail;
    private String verify;

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getVerify() {
        return verify;
    }

    public void setVerify(String verify) {
        this.verify = verify;
    }
}
