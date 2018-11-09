package com.news.mobile.entiyt.request;

import com.news.mobile.base.BaseRequest;

/**
 * Created by sfy. on 2018/11/3 0003.
 */

public class NewsListRequest extends BaseRequest {

    public String page;
    public String r_type;

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getR_type() {
        return r_type;
    }

    public void setR_type(String r_type) {
        this.r_type = r_type;
    }
}
