package com.news.mobile;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;
import android.util.Log;

import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.common.memory.MemoryTrimType;
import com.facebook.common.memory.MemoryTrimmable;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.common.memory.NoOpMemoryTrimmableRegistry;
import com.facebook.common.util.ByteConstants;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.imagepipeline.core.ImagePipelineFactory;
import com.facebook.stetho.Stetho;
import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.news.mobile.tplatform.PlatformConstant;
import com.news.mobile.utils.LolipopBitmapMemoryCacheSupplier;
import com.twitter.sdk.android.core.DefaultLogger;
import com.twitter.sdk.android.core.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterConfig;
import com.umeng.analytics.MobclickAgent;
import com.umeng.commonsdk.UMConfigure;

import okhttp3.OkHttpClient;

/**
 * Created by sfy. on 2018/11/2 0002.
 */

public class MyApplication extends MultiDexApplication {

    public static MyApplication mContext;

    public static Context getAppContext() {
        return mContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        MultiDex.install(this);
        mContext = this;

        initTiwtter();
        setFresco();//fresco必须初始化
        initFacebook();

        UMConfigure.init(this, "5be27cf2f1f5564573000492", getChannel(), UMConfigure.DEVICE_TYPE_PHONE, "");

        //添加统计代码
        MobclickAgent.setScenarioType(getApplicationContext(), MobclickAgent.EScenarioType.E_UM_NORMAL);
        MobclickAgent.openActivityDurationTrack(false);

        initGoogleDevice();
    }


    private void initTiwtter() {
        TwitterConfig config = new TwitterConfig.Builder(this)
                .logger(new DefaultLogger(Log.DEBUG))
                .twitterAuthConfig(new TwitterAuthConfig(PlatformConstant.TIWTTER_KEY, PlatformConstant.TIWTTER_SECRET))
                .debug(true)
                .build();
        Twitter.initialize(config);
    }

    private void initFacebook() {
        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);
    }

    private void setFresco() {
        MemoryTrimmableRegistry memoryTrimmableRegistry = NoOpMemoryTrimmableRegistry.getInstance();
        memoryTrimmableRegistry.registerMemoryTrimmable(new MemoryTrimmable() {
            @Override
            public void trim(MemoryTrimType trimType) {
                final double suggestedTrimRatio = trimType.getSuggestedTrimRatio();
                if (MemoryTrimType.OnCloseToDalvikHeapLimit.getSuggestedTrimRatio() == suggestedTrimRatio
                        || MemoryTrimType.OnSystemLowMemoryWhileAppInBackground.getSuggestedTrimRatio() == suggestedTrimRatio
                        || MemoryTrimType.OnSystemLowMemoryWhileAppInForeground.getSuggestedTrimRatio() == suggestedTrimRatio) {
                    //清空内存缓存
                    ImagePipelineFactory.getInstance().getImagePipeline().clearMemoryCaches();
                    /*
                     * 添加清楚内存缓存
                     * */
                    Fresco.getImagePipeline().clearMemoryCaches();

                }
            }
        });
        //小图片的磁盘配置,用来储存用户头像之类的小图
        DiskCacheConfig diskSmallCacheConfig = DiskCacheConfig.newBuilder(this)
                .setBaseDirectoryPath(this.getCacheDir())//缓存图片基路径
                .setBaseDirectoryName(getString(R.string.app_name))//文件夹名
                .setMaxCacheSize(20 * ByteConstants.MB)//默认缓存的最大大小。
                .setMaxCacheSizeOnLowDiskSpace(10 * ByteConstants.MB)//缓存的最大大小,使用设备时低磁盘空间。
                .setMaxCacheSizeOnVeryLowDiskSpace(5 * ByteConstants.MB)//缓存的最大大小,当设备极低磁盘空间
                .build();


        ImagePipelineConfig config = ImagePipelineConfig.newBuilder(this)
                .setDownsampleEnabled(true)
                .setResizeAndRotateEnabledForNetwork(true)
                .setBitmapMemoryCacheParamsSupplier(new LolipopBitmapMemoryCacheSupplier((ActivityManager) getSystemService(ACTIVITY_SERVICE)))
                .setMemoryTrimmableRegistry(memoryTrimmableRegistry)
                .setSmallImageDiskCacheConfig(diskSmallCacheConfig)
                .setBitmapsConfig(Bitmap.Config.RGB_565)
                .build();

//        ImagePipelineConfig config = ImagePipelineConfig.newBuilder(this)
//                .setDownsampleEnabled(true)
//                .setMemoryTrimmableRegistry(memoryTrimmableRegistry)
//                .build();
        Fresco.initialize(getApplicationContext(), config);
    }

    /**
     * 获取渠道名称
     *
     * @return
     */
    private String getChannel() {
        try {
            PackageManager pm = getPackageManager();
            ApplicationInfo appInfo = pm.getApplicationInfo(getPackageName(), PackageManager.GET_META_DATA);
            String channelName = appInfo.metaData.getString("CHANNEL_NAME");
            return channelName;
        } catch (PackageManager.NameNotFoundException ignored) {
        }
        return "";
    }

    private void initGoogleDevice() {
        Stetho.initializeWithDefaults(this);
        new OkHttpClient.Builder()
                .addNetworkInterceptor(new StethoInterceptor())
                .build();
    }

}
