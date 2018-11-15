package com.news.mobilephone.main.web.contract;

import com.news.mobilephone.base.BaseView;
import com.news.mobilephone.entiyt.ShareResponse;

/**
 * 作者：created by hcj
 * 邮箱：2654313873@qq.com
 * 日期：2018/11/5 13
 */
public interface JsWebView extends BaseView {
    void onBindWxSucceed(int count);

    void onShareInfo(ShareResponse shareResponse);
}
