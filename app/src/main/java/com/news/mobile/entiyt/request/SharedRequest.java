package com.news.mobile.entiyt.request;

import com.google.gson.annotations.SerializedName;
import com.news.mobile.base.BaseRequest;

/**
 * 作者：created by hcj
 * 邮箱：2654313873@qq.com
 * 日期：2018/11/5 12
 */
public class SharedRequest extends BaseRequest {

    @SerializedName("to_platfrom")
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
