package com.news.mobile.entiyt.request;

import com.news.mobile.base.BaseRequest;

/**
 * 作者：created by hcj
 * 邮箱：2654313873@qq.com
 * 日期：2018/11/6 11
 */
public class NewsAddGoodRequest extends BaseRequest {

    private String new_id;
    private String du_type;

    public String getNew_id() {
        return new_id;
    }

    public void setNew_id(String new_id) {
        this.new_id = new_id;
    }

    public String getDu_type() {
        return du_type;
    }

    public void setDu_type(String du_type) {
        this.du_type = du_type;
    }
}
