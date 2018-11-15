package com.news.mobilephone.main.web.js;

import android.content.Context;
import android.webkit.JavascriptInterface;

import com.news.mobilephone.entiyt.event.LogoutEvent;
import com.news.mobilephone.utils.UserSpCache;

import org.greenrobot.eventbus.EventBus;

/**
 * 作者：created by hcj
 * 邮箱：2654313873@qq.com
 * 日期：2018/11/5 14
 */
public class SettingJs {
    //频道设置
    public static final String METHOD_CHANNEL_SETTING = "channelSetting";
    //推送设置
    public static final String METHOD_PUSH_SETTING = "pushSetting";
    //图片模式设置
    public static final String METHOD_IMAGE_TYPE_SETTING = "imageTypeSetting";
    //文字大小设置
    public static final String METHOD_TEXT_SIZE_SETTING = "textSizeSetting";
    //清除缓存
    public static final String METHOD_CLEAR_CACHE = "clearCache";
    //检查更新
    public static final String METHOD_CHECK_UPDATE = "checkUpdate";
    //锁屏新闻展示
    public static final String METHOD_IS_LOCK_SHOW = "isLockShow";
    //音效设置
    public static final String METHOD_IS_OPEN_MUSIC = "isOpenMusic";
    //退出登录
    public static final String METHOD_LOGIN_OUT = "loginOut";

    private Context mContext;

    public SettingJs(Context context) {
        mContext = context;
    }

    //频道设置
    @JavascriptInterface
    public void channelSetting(String channelListJson) {
    }

    @JavascriptInterface
    public void pushSetting(String pushSettingJson) {

        // 1.天气推送 1：0
        //2.奖励推送 1:0
        //3,时间段 （） 小时 1-5
    }

    @JavascriptInterface
    public void imageTypeSetting(String imageTypeJson) {
        //3种类型

    }

    @JavascriptInterface
    public void textSizeSetting(String json) {
        //直接调用即可 ，本地弹窗
    }

    @JavascriptInterface
    public void checkUpdate() {
        //直接调用即可,本地检查
    }

    @JavascriptInterface
    public void isLockShow(String json) {

    }

    @JavascriptInterface
    public void isOpenMusic(String json) {

    }

    public void logout() {
        int totalCount = UserSpCache.getInstance(mContext).getInt(UserSpCache.NEEDCOUNT_LOGIN);
        long signTime = UserSpCache.getInstance(mContext).getLong(UserSpCache.SIGN_SERVICE_TIME);
        long localTime = UserSpCache.getInstance(mContext).getLong(UserSpCache.SIGN_LOCAL_TIME);
        int openGoldCount = UserSpCache.getInstance(mContext).getInt(UserSpCache.OPEN_GOLD_COUNT);
        int openRedCount = UserSpCache.getInstance(mContext).getInt(UserSpCache.OPEN_RED_COUNT);
        UserSpCache.getInstance(mContext.getApplicationContext()).clearCache();
        UserSpCache.getInstance(mContext).putString(UserSpCache.KEY_IS_FIRST_OPEN_APP, "has_open_app");
        UserSpCache.getInstance(mContext).putString(UserSpCache.KEY_IS_SECEND_OPEN_APP, "isSecend");
        UserSpCache.getInstance(mContext).putInt(UserSpCache.NEEDCOUNT_LOGIN, totalCount);
        UserSpCache.getInstance(mContext).putLong(UserSpCache.SIGN_SERVICE_TIME, signTime);
        UserSpCache.getInstance(mContext).putLong(UserSpCache.SIGN_LOCAL_TIME, localTime);
        UserSpCache.getInstance(mContext).putInt(UserSpCache.OPEN_GOLD_COUNT, openGoldCount);
        UserSpCache.getInstance(mContext).putInt(UserSpCache.OPEN_RED_COUNT, openRedCount);
        EventBus.getDefault().post(new LogoutEvent());
    }

}
