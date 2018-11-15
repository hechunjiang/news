package com.news.mobilephone.entiyt.request;

import com.news.mobilephone.base.BaseRequest;

/**
 * Created by sfy. on 2018/11/2 0002.
 */

public class TempLoginRequest extends BaseRequest {
    private String mobile_brand;

    public String getMobile_brand() {
        return mobile_brand;
    }

    public void setMobile_brand(String mobile_brand) {
        this.mobile_brand = mobile_brand;
    }
}
