package com.news.mobile.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.google.gson.Gson;
import com.news.mobile.entiyt.User;

/**
 * Created by sfy. on 2018/11/2 0002.
 */

public class UserSpCache {
    public static final String KEY_TICKET = "key_ticket";
    public static final String OPEN_COUNT = "open_count"; //记录打开的次数
    public static final String TIPS_FLAG = "tips_flag";


    private final static String CACHE_NAME = "USER_CACHE";
    public static final String SIGN_SERVICE_TIME = "sign_service_time"; //同步服务器时间之服务器时间
    public static final String SIGN_LOCAL_TIME = "sign_localtime"; //同步服务器时间之获取服务器时间时的手机时间

    public static final String KEY_IS_USER_LOGIN = "key_is_user_login";
    public static final String KEY_USER = "key_user";
    public static final String KEY_PHONE = "key_phone";
    public static final String KEY_PASS = "key_pass";
    public static final String KEY_IS_SECEND_OPEN_APP = "key_is_secend_open_app";
    public static final String NIKE_NAME = "NIKE_NAME";
    public static final String C_USERID = "key_pass";
    public static final String OPENID = "openId";
    public static final String KEY_USER_ID = "key_user_id";
    public static final String REQUEST_LONG = "request_long";//时长  持续时间
    public static final String REQUEST_ALLLONG = "request_all_long";//时长  持续时间
    public static final String NEEDCOUNT_LOGIN = "need_count_login"; //记录服务器打开次数
    public static final String OPEN_GOLD_COUNT = "open_gold_count"; //当前金币获取次数
    public static final String OPEN_RED_COUNT = "open_red_count";
    public static final String KEY_IS_FIRST_OPEN_APP = "key_is_first_open_app";
    public static final String TIPS_LOCAL_FLAG = "tips_local_flag";


    private SharedPreferences mSharedPreferences;
    private static UserSpCache mInstance;

    private UserSpCache(Context context) {
        mSharedPreferences = context.getSharedPreferences(CACHE_NAME, Context.MODE_PRIVATE);
    }

    public static UserSpCache getInstance(Context context) {
        if (mInstance == null) {
            synchronized (UserSpCache.class) {
                if (mInstance == null) {
                    mInstance = new UserSpCache(context);
                }
            }
        }
        return mInstance;
    }

    /**
     * 存储String类型的键值对
     *
     * @param key
     * @param value
     */
    public void putString(String key, String value) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public String getStringData(String key) {
        return mSharedPreferences.getString(key, "");
    }

    /**
     * 存储long
     *
     * @param key
     * @param value
     */
    public void putLong(String key, long value) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putLong(key, value);
        editor.commit();
    }

    public long getLong(String key) {
        return mSharedPreferences.getLong(key, -1);
    }

    /**
     * 存储int
     *
     * @param key
     * @param value
     */
    public void putInt(String key, int value) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putInt(key, value);
        editor.commit();
    }

    public int getInt(String key) {
        return mSharedPreferences.getInt(key, -1);
    }


    public void putBoolean(String key, boolean value) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putBoolean(key, value);
        editor.commit();
    }

    public void putFloat(String key, float value) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putFloat(key, value);
        editor.commit();
    }

    public float getFloat(String key) {
        return mSharedPreferences.getFloat(key, 0f);
    }

    public boolean getBoolean(String key) {
        return mSharedPreferences.getBoolean(key, false);
    }

    public void deleteData(String key) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.remove(key);
        editor.commit();
    }

    public void clearCache() {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.clear();
        editor.commit();
    }

    public void putUser(User user) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(KEY_USER, new Gson().toJson(user));
        editor.putString(KEY_USER_ID, user.getData().getUser_info().getId());
        editor.commit();
    }

}
