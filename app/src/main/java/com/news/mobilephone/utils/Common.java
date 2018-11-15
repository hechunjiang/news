package com.news.mobilephone.utils;

import android.os.Environment;

import java.io.File;

/**
 * Created by sfy. on 2018/11/3 0003.
 */

public class Common {

    public static final int JS_RESPONSE_CODE_SUCCEED = 200;
    public static final int JS_RESPONSE_CODE_FAIL = -1;
    public static final int JS_RESPONSE_CODE_CANCEL = -2;
    public static final String TYPE_FACEBOOK = "facebook";
    public static final int TWITTER_SHARE_IAMGE = 1;
    public static final String REFRESH_USERINFO = "refresh_userinfo";
    public static final int SHARE_TYPE_FACEBOOK = 0; // facebook
    public static final int SHARE_TYPE_TWITTER = 1; //twitter
    public static final int SHARE_TYPE_INS = 7; //gmail
    public static final int SHARE_TYPE_WHATS = 2; //whatsapp
    public static final int SHARE_TYPE_LINKEDIN = 3; //LinkedIn
    public static final int SHARE_TYPE_REPORT = 4; //举报
    public static final int SHARE_TYPE_DELETE = 5; //删除
    public static final String BUNDLE_TO_ADVERTISEMENT = "bundle_to_advertisement";
    public static final String LLURL = "weburl";
    public static final String REFRESH_TIPS = "refresh_item";  //刷新
    public static final String PROGRESS = "progress";  //进度
    public static final String SELECT_MAIN = "select_main";  //首页选中
    public static final String REFRESH_NEWS_LIST = "refresh_news_list";  //刷新新闻列表
    public static final String REFRESH_TASK_LIST = "refresh_task_list";  //刷新任务大厅


    //分享图片地址
    public static final String SAVE_SHARE_IMAGE_PATH = Environment.getExternalStorageDirectory() + File.separator + "juNews" + File.separator + "shareImage" + File.separator;
    public static final int TWITTER_SHARE_URL = 0;

}
