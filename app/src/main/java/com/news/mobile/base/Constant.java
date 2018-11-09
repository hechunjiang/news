package com.news.mobile.base;

import android.os.Environment;

import com.news.mobile.BuildConfig;

import java.io.File;

/**
 * Created by sfy. on 2018/11/2 0002.
 */

public class Constant {
    public static final String UPDATE_URL = BuildConfig.BASE_URL + "juNew_update.xml";
    public static final String SAVE_APK_PATH = Environment.getExternalStorageDirectory() + File.separator + "watch$earn" + File.separator + "apk" + File.separator;

    public static final String CACHE_LAT = "lat";
    public static final String CACHE_LNG = "lng";
    public static final String CACHE_COUNTRY = "country";
    public static final String FACEBOOK = "fb";
    public static final String TWITTER = "tt";
    public static final String GOOGLELOGIN = "gmail";
    public static final String KEY_TICKET = "key_ticket";
    public static final String KEY_IS_USER_LOGIN = "key_is_user_login";
    public static final String LINKEDIN = "lk";
    public static final String WEB_URL = "webUrl";
    public static final String NIKE_NAME = "NIKE_NAME";


    //bundle常量
    public static final String NEWSINFO = "newsinfo";
    public static final String NEWS_ID = "news_id";



}
