package com.news.mobile.http;

import android.content.Context;
import android.text.TextUtils;

import com.news.mobile.BuildConfig;
import com.news.mobile.MyApplication;
import com.news.mobile.base.BaseRequest;
import com.news.mobile.base.Constant;
import com.news.mobile.entiyt.request.FeedBackRequest;
import com.news.mobile.entiyt.request.GetCodeRequest;
import com.news.mobile.entiyt.request.GetboxtimeRequst;
import com.news.mobile.entiyt.request.InfoRequest;
import com.news.mobile.entiyt.request.LoginRequest;
import com.news.mobile.entiyt.request.NewsAddGoodRequest;
import com.news.mobile.entiyt.request.NewsDetailRequest;
import com.news.mobile.entiyt.request.NewsGoldRequest;
import com.news.mobile.entiyt.request.NewsListRequest;
import com.news.mobile.entiyt.request.PariseRequest;
import com.news.mobile.entiyt.request.PlatformLogin;
import com.news.mobile.entiyt.request.PushTokenRequest;
import com.news.mobile.entiyt.request.ResetPassRequst;
import com.news.mobile.entiyt.request.ShareNewsRequest;
import com.news.mobile.entiyt.request.ShareVisitRequest;
import com.news.mobile.entiyt.request.SharedRequest;
import com.news.mobile.entiyt.request.TaskListRequest;
import com.news.mobile.entiyt.request.TaskRequest;
import com.news.mobile.entiyt.request.TaskRequestAdVideo;
import com.news.mobile.entiyt.request.TempLoginRequest;
import com.news.mobile.entiyt.request.ThirdRequest;
import com.news.mobile.entiyt.request.ThridLoginRequest;
import com.news.mobile.entiyt.request.UserMsgRequest;
import com.news.mobile.entiyt.request.VideoReportRequest;
import com.news.mobile.utils.ACache;
import com.news.mobile.utils.HasUtils;
import com.news.mobile.utils.LogUtil;
import com.news.mobile.utils.PhoneUtils;
import com.news.mobile.utils.TimeUtils;
import com.news.mobile.utils.UserSpCache;

import java.io.File;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class MyRetrofit {
    private Context mContext;
    private static MyRetrofit mInstance;
    private HttpService mHttpService;

    public MyRetrofit(Context mContext) {
        this.mContext = mContext;
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        //设定日志级别
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .sslSocketFactory(SSLSocketClient.getSSLSocketFactory())
                .hostnameVerifier(SSLSocketClient.getHostnameVerifier())
                //添加拦截器
                .addInterceptor(httpLoggingInterceptor)
                .addInterceptor(interceptor)
                .build();
        Retrofit retrofit = new Retrofit
                .Builder()
                .client(okHttpClient)
                .baseUrl(BuildConfig.BASE_URL)
//                 .baseUrl(Api.BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        mHttpService = retrofit.create(HttpService.class);
    }

    public MyRetrofit(Context mContext, String httpUrl) {
        this.mContext = mContext;
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .retryOnConnectionFailure(true)
                .connectTimeout(60, TimeUnit.SECONDS)
                .sslSocketFactory(SSLSocketClient.getSSLSocketFactory())
                .hostnameVerifier(SSLSocketClient.getHostnameVerifier())
                .addInterceptor(interceptor)
                .build();
        Retrofit retrofit = new Retrofit
                .Builder()
                .client(okHttpClient)
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        mHttpService = retrofit.create(HttpService.class);
    }

    public static MyRetrofit getInstance(Context context, String httpUrl) {
        if (mInstance == null) {
            synchronized (MyRetrofit.class) {
                if (mInstance == null) {
                    mInstance = new MyRetrofit(context, httpUrl);
                }
            }
        }
        return mInstance;
    }

    public static MyRetrofit getInstance(Context context) {

        synchronized (MyRetrofit.class) {
            mInstance = new MyRetrofit(context);
        }
        return mInstance;
    }

    public HttpService getService() {
        return mHttpService;
    }


    /**
     * 临时登录
     *
     * @param request
     * @param callBack
     */
    public void requestTempLogin(TempLoginRequest request, DataCallBack callBack) {
        request.setTime(nowTime());
        request.setNonce_str(nonceStr());
        request.setSign(signStr(request.getTime(), request.getNonce_str(), SignJson.signTempLogin(request)));
        mHttpService.requestTempLogin(getHeaderMap(), request)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(callBack);
    }


    public void onPushToken(PushTokenRequest request, DataCallBack callBack) {
        request.setNonce_str(nonceStr());
        request.setTime(nowTime());
        request.setSign(signStr(request.getTime(), request.getNonce_str(), SignJson.signPushToken(request)));
        mHttpService.onPushToken(getHeaderMap(), request)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(callBack);
    }

    //个人work信息
    public void getUserPerSonWorkDetails(DataCallBack callBack) {
        mHttpService.getUserCommentList(getHeaderMap())
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(callBack);
    }

    public void uploadImage(File file, DataCallBack callBack) {
        RequestBody requestFile = RequestBody.create(MediaType.parse("text/plain"), file);
        MultipartBody.Part body = MultipartBody.Part.createFormData("uploadFile", file.getName(), requestFile);

        mHttpService.uploadFile(getHeaderMap(), body)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(callBack);
    }

    /**
     * 上传个人信息
     *
     * @param request
     * @param callBack
     */
    public void setUserMsg(UserMsgRequest request, DataCallBack callBack) {
        request.setTime(nowTime());
        request.setNonce_str(nonceStr());
        request.setSign(signStr(request.getTime(), request.getNonce_str(), SignJson.signUserMsg(request)));
        mHttpService.setUserMsg(getHeaderMap(), request)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(callBack);
    }

    /**
     * 新闻列表
     *
     * @param request
     * @param callBack
     */
    public void requestNewsList(NewsListRequest request, DataCallBack callBack) {
        request.setTime(nowTime());
        request.setNonce_str(nonceStr());
        request.setSign(signStr(request.getTime(), request.getNonce_str(), SignJson.NewsList(request)));
        mHttpService.requestNewsList(getHeaderMap(), request)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(callBack);
    }

    /**
     * 新闻点赞
     *
     * @param request
     * @param callBack
     */
    public void requestParseNews(PariseRequest request, DataCallBack callBack) {
        request.setTime(nowTime());
        request.setNonce_str(nonceStr());
        request.setSign(signStr(request.getTime(), request.getNonce_str(), SignJson.signParseNews(request)));
        mHttpService.requestParsenews(getHeaderMap(), request)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(callBack);
    }


    /**
     * 请求新闻分享内容
     *
     * @param request
     * @param callBack
     */
    public void requestShareNewsConntent(ShareNewsRequest request, DataCallBack callBack) {
        request.setTime(nowTime());
        request.setNonce_str(nonceStr());
        request.setSign(signStr(request.getTime(), request.getNonce_str(), SignJson.signShareNewsConntent(request)));
        mHttpService.requestSharedConttent(getHeaderMap(), request)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(callBack);

    }


    /**
     * 获取用户信息
     *
     * @param callBack
     */

    public void requestPersonMsg(DataCallBack callBack) {
        BaseRequest baseRequest = new BaseRequest();
        baseRequest.setNonce_str(nonceStr());
        baseRequest.setTime(nowTime());
        baseRequest.setSign(signStr(baseRequest.getTime(), baseRequest.getNonce_str(), ""));
        mHttpService.requestPersonMsg(getHeaderMap(), baseRequest)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(callBack);
    }


    /**
     * 注册验证码
     *
     * @param request
     * @param callBack
     */
    public void getSmsCode(GetCodeRequest request, DataCallBack callBack) {
        request.setTime(nowTime());
        request.setNonce_str(nonceStr());
        request.setSign(signStr(request.getTime(), request.getNonce_str(), SignJson.signGetSmsCode(request)));
        mHttpService.getSmsCode(getHeaderMap(), request)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(callBack);
    }


    /**
     * 重新设置密码
     *
     * @param request
     * @param callBack
     */
    public void resetPassWord(ResetPassRequst request, DataCallBack callBack) {
        request.setTime(nowTime());
        request.setNonce_str(nonceStr());
        request.setSign(signStr(request.getTime(), request.getNonce_str(), SignJson.signFindPass(request)));
        mHttpService.resetPss(getHeaderMap(), request)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(callBack);
    }

    /**
     * 登录
     *
     * @param request
     * @param callBack
     */
    public void onLogin(LoginRequest request, DataCallBack callBack) {
        request.setTime(nowTime());
        request.setNonce_str(nonceStr());
        request.setSign(signStr(request.getTime(), request.getNonce_str(), SignJson.singOnLogin(request.getAccount(), request.getPassword())));
        mHttpService.onLogin(getHeaderMap(), request)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(callBack);
    }

    public void thridLogin(ThridLoginRequest request, DataCallBack callBack) {
        request.setTime(nowTime());
        request.setNonce_str(nonceStr());
        request.setSign(signStr(request.getTime(), request.getNonce_str(), SignJson.signThridLogin(request)));
        mHttpService.getGold(getHeaderMap(), request)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(callBack);
    }


    /**
     * 分享计数
     */
    public void shareVisit(ShareVisitRequest request, DataCallBack callBack) {
        request.setTime(nowTime());
        request.setNonce_str(nonceStr());
        request.setSign(signStr(request.getTime(), request.getNonce_str(), SignJson.signShareVisit(request)));
        mHttpService.shareVisit(getHeaderMap(), request).subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(callBack);
    }

    public void getAdVideoByTask(TaskRequestAdVideo request, DataCallBack callBack) {
        request.setTime(nowTime());
        request.setNonce_str(nonceStr());
        request.setSign(signStr(request.getTime(), request.getNonce_str(), SignJson.signTaskGoldAdVideo(request)));
        mHttpService.getAdVideoByTask(getHeaderMap(), request)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(callBack);
    }

    /**
     * 获取分享信息
     *
     * @param
     */
    public void getShareInfo(final DataCallBack callBack) {
        mHttpService.getShareInfo(getHeaderMap()).subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(callBack);
    }

    /**
     * 分享
     *
     * @param request
     * @param callBack
     */
    public void inviteShareDatas(SharedRequest request, DataCallBack callBack) {
        request.setTime(nowTime());
        request.setNonce_str(nonceStr());
        request.setSign(signStr(request.getTime(), request.getNonce_str(), ""));
        mHttpService.videoShareUrl(getHeaderMap(), request)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(callBack);
    }

    /**
     * 任务大厅
     *
     * @param request
     * @param callBack
     */
    public void getTaskList(TaskListRequest request, DataCallBack callBack) {
        request.setTime(nowTime());
        request.setNonce_str(nonceStr());
        request.setSign(signStr(request.getTime(), request.getNonce_str(), ""));
        mHttpService.getTaskList(getHeaderMap(), request)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(callBack);
    }

    /**
     * 任务列表
     *
     * @param request
     * @param callBack
     */

    public void getTaskListNew(TaskListRequest request, DataCallBack callBack) {
        request.setTime(nowTime());
        request.setNonce_str(nonceStr());
        request.setSign(signStr(request.getTime(), request.getNonce_str(), ""));
        mHttpService.getTaskListNew(getHeaderMap(), request)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(callBack);
    }


    /**
     * 获取收益列表
     *
     * @param request
     * @param callBack
     */
    public void getTaskInfo(InfoRequest request, DataCallBack callBack) {
        request.setTime(nowTime());
        request.setNonce_str(nonceStr());
        request.setSign(signStr(request.getTime(), request.getNonce_str(), ""));
        mHttpService.getTaskInfo(getHeaderMap(), request)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(callBack);
    }


    /**
     * 获取开宝箱时间
     *
     * @param requst
     * @param callBack
     */
    public void getGoldBoxTime(GetboxtimeRequst requst, DataCallBack callBack) {
        requst.setTime(nowTime());
        requst.setNonce_str(nonceStr());
        requst.setSign(signStr(requst.getTime(), requst.getNonce_str(), SignJson.signGoldTime(requst)));
        mHttpService.getGoldboxTime(getHeaderMap(), requst)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(callBack);

    }


    /**
     * 开宝箱
     *
     * @param request
     * @param callBack
     */
    public void getGoldByTask(TaskRequest request, DataCallBack callBack) {
        request.setTime(nowTime());
        request.setNonce_str(nonceStr());
        request.setSign(signStr(request.getTime(), request.getNonce_str(), SignJson.signTaskGold(request)));
        mHttpService.getGoldByTask(getHeaderMap(), request)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(callBack);
    }

    public void apprenticePageData(DataCallBack callBack) {
        BaseRequest baseRequest = new BaseRequest();
        baseRequest.setNonce_str(nonceStr());
        baseRequest.setTime(nowTime());
        baseRequest.setSign(signStr(baseRequest.getTime(), baseRequest.getNonce_str(), ""));
        mHttpService.apprenticePageData(getHeaderMap(), baseRequest).subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(callBack);
    }

    /**
     * new 三方登录
     */
    public void checkIsLogin(ThirdRequest request, DataCallBack callBack) {
        request.setTime(nowTime());
        request.setNonce_str(nonceStr());
        request.setSign(signStr(request.getTime(), request.getNonce_str(), SignJson.checkIsLogin(request)));
        mHttpService.checkLogin(getHeaderMap(), request)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(callBack);
    }

    /**
     * 举报
     *
     * @param request
     * @param callBack
     */
    public void videoRepost(VideoReportRequest request, DataCallBack callBack) {
        request.setTime(nowTime());
        request.setNonce_str(nonceStr());
        request.setSign(signStr(request.getTime(), request.getNonce_str(), SignJson.signVideoReport(request)));
        mHttpService.videoReport(getHeaderMap(), request)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(callBack);
    }


    /**
     * 消息列表
     *
     * @param callBack
     */
    public void onMessageList(DataCallBack callBack) {
        BaseRequest request = new BaseRequest();
        request.setNonce_str(nonceStr());
        request.setTime(nowTime());
        request.setSign(signStr(request.getTime(), request.getNonce_str(), ""));
        mHttpService.onMessageList(getHeaderMap(), request)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(callBack);
    }


    /**
     * 获取意见分类
     *
     * @param callBack
     */
    public void onFeedClassify(DataCallBack callBack) {
        BaseRequest request = new BaseRequest();
        request.setNonce_str(nonceStr());
        request.setTime(nowTime());
        request.setSign(signStr(request.getTime(), request.getNonce_str(), ""));
        mHttpService.feedbackClassify(getHeaderMap(), request)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(callBack);
    }

    /**
     * 发送意见
     *
     * @param request
     * @param callBack
     */
    public void sendFeedBack(FeedBackRequest request, DataCallBack callBack) {
        request.setNonce_str(nonceStr());
        request.setTime(nowTime());
        request.setSign(signStr(request.getTime(), request.getNonce_str(), SignJson.signFeedBack(request)));
        mHttpService.feedbackSend(getHeaderMap(), request)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(callBack);
    }

    /**
     * 获取当前时间
     *
     * @return
     */
    private String nowTime() {
        TimeUtils timeUtils = new TimeUtils();
        return timeUtils.phoneTime(MyApplication.getAppContext()) + "";
    }

    /**
     * 随机字符串
     *
     * @return
     */
    private String nonceStr() {
        return HasUtils.getInstance().nonceStr();
    }

    /**
     * 加密串
     *
     * @param time
     * @param nonceStr
     * @param json
     * @return
     */
    private String signStr(String time, String nonceStr, String json) {
        try {
            String ticket = UserSpCache.getInstance(mContext).getStringData(UserSpCache.KEY_TICKET);
            return HasUtils.getInstance().sign(time, nonceStr, json, ticket);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 头部信息
     *
     * @return
     */
    private HashMap<String, String> getHeaderMap() {
        HashMap<String, String> map = new HashMap<>();
        map.put(Api.HEADER_OS, "android");
        map.put(Api.HEADER_MEID, PhoneUtils.getAndroidId(mContext));
        map.put(Api.HEADER_VERSION, BuildConfig.VERSION_NAME);
        map.put(Api.HEADER_TICKET, UserSpCache.getInstance(mContext).getStringData(UserSpCache.KEY_TICKET));
        map.put(Api.HEADER_RATIO, PhoneUtils.getScreenWidth(mContext) + "*" + PhoneUtils.getScreenHeight(mContext));
        map.put(Api.HEADER_BRAND, PhoneUtils.getPhoneBrand());
        map.put(Api.HEADER_BLUETOOTH, PhoneUtils.notHasBlueTooth());
        map.put(Api.HEADER_OPTICAL_SENSOR, PhoneUtils.notHasLightSensorManager(mContext));
        map.put(Api.HEADER_CPU, PhoneUtils.checkIsNotRealPhone());
        map.put(Api.LANGUAGE, PhoneUtils.getLocalLanguage());
        if (!TextUtils.isEmpty(ACache.get(mContext).getAsString(Constant.CACHE_COUNTRY))) {
            map.put(Api.LAT, ACache.get(mContext).getAsString(Constant.CACHE_LAT) + "");
            map.put(Api.LNG, ACache.get(mContext).getAsString(Constant.CACHE_LNG) + "");
            map.put(Api.COUNTRY, ACache.get(mContext).getAsString(Constant.CACHE_COUNTRY) + "");
        }
        LogUtil.showLog(map + "");
        return map;
    }


    /**
     * 新闻详情
     *
     * @param request
     * @param callBack
     */
    public void requestNewsDetail(NewsDetailRequest request, DataCallBack callBack) {
        request.setTime(nowTime());
        request.setNonce_str(nonceStr());
        request.setSign(signStr(request.getTime(), request.getNonce_str(), SignJson.signNewsDetail(request)));
        mHttpService.getNewsDetail(getHeaderMap(), request)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(callBack);
    }

    /**
     * 新闻加金币
     *
     * @param request
     * @param callBack
     */
    public void requestNewsGold(NewsGoldRequest request, DataCallBack callBack) {
        request.setTime(nowTime());
        request.setNonce_str(nonceStr());
        request.setSign(signStr(request.getTime(), request.getNonce_str(), SignJson.signNewsGold(request)));
        mHttpService.getNewsGold(getHeaderMap(), request)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(callBack);
    }

    /**
     * 新闻点赞
     *
     * @param request
     * @param callBack
     */
    public void addGood(NewsAddGoodRequest request, DataCallBack callBack) {
        request.setTime(nowTime());
        request.setNonce_str(nonceStr());
        request.setSign(signStr(request.getTime(), request.getNonce_str(), SignJson.signAddGood(request)));
        mHttpService.addGood(getHeaderMap(), request)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(callBack);
    }

}
