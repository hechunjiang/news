package com.news.mobilephone.main.web.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.widget.SwipeRefreshLayout;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.github.lzyzsd.jsbridge.BridgeHandler;
import com.github.lzyzsd.jsbridge.BridgeWebView;
import com.github.lzyzsd.jsbridge.BridgeWebViewClient;
import com.github.lzyzsd.jsbridge.CallBackFunction;
import com.github.lzyzsd.jsbridge.DefaultHandler;
import com.google.gson.Gson;
import com.linkedin.platform.LISessionManager;
import com.news.mobilephone.entiyt.JsShareType;
import com.news.mobilephone.MyApplication;
import com.news.mobilephone.R;
import com.news.mobilephone.base.BaseActivity;
import com.news.mobilephone.base.Constant;
import com.news.mobilephone.view.dialog.GoldComeDialog;
import com.news.mobilephone.view.dialog.OtherActivityDialog;
import com.news.mobilephone.entiyt.ShareResponse;
import com.news.mobilephone.entiyt.TwitterBindReponse;
import com.news.mobilephone.entiyt.TwitterRegResponse;
import com.news.mobilephone.entiyt.event.ClosePageEvent;
import com.news.mobilephone.entiyt.event.JsPageLoadCompletion;
import com.news.mobilephone.entiyt.event.ToMePageEvent;
import com.news.mobilephone.http.Api;
import com.news.mobilephone.main.web.contract.JsWebView;
import com.news.mobilephone.main.web.contract.WebContract;
import com.news.mobilephone.main.web.js.JsGoldCome;
import com.news.mobilephone.main.web.js.JsOpenTheTreasureBox;
import com.news.mobilephone.main.web.js.PersonalJs;
import com.news.mobilephone.main.web.js.SettingJs;
import com.news.mobilephone.main.web.model.WebModel;
import com.news.mobilephone.main.web.presenter.WebPresenter;
import com.news.mobilephone.tplatform.facebook.FaceBookShare;
import com.news.mobilephone.tplatform.facebook.FacebookPlatform;
import com.news.mobilephone.tplatform.linkedin.LinkedInPlatform;
import com.news.mobilephone.tplatform.twitter.TwitterLogin;
import com.news.mobilephone.utils.Common;
import com.news.mobilephone.utils.CommonUtils;
import com.news.mobilephone.utils.LogUtil;
import com.news.mobilephone.utils.StatusBarUtils;
import com.news.mobilephone.utils.ToastUtils;
import com.news.mobilephone.utils.UserSpCache;
import com.news.mobilephone.view.EmptyLayout;
import com.news.mobilephone.view.OpenTheTreasureBoxDialog;
import com.news.mobilephone.view.TitleBar;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.Timer;

public class WebActivity extends BaseActivity<WebPresenter, WebModel> implements WebContract.View, JsWebView {
    private TitleBar titleBar;
    private SwipeRefreshLayout refreshLayout;
    private BridgeWebView webview;
    private EmptyLayout emptyLayout;
    private String mUrl;
    private boolean isError;
    private PersonalJs mPersonalJs;
    private boolean isAdvertisement, isTimmerRunning; //是否为web广告进入
    private SettingJs mSettingJs;
    private OpenTheTreasureBoxDialog mOpenTheTreasureBoxDialog;
    private GoldComeDialog mGoldComeDialog;
    private MediaPlayer mediaPlayer;
    private RelativeLayout loading_view;
    //    private PushTaskResponse.DataBean.PageListBean pageListBean;
    String otherActivityUrl = "";
    private long delayMillis = 2000;//首页活动推送弹框
    private OtherActivityDialog mOtherActivityDialog;
    private UserSpCache mUserSpCache = UserSpCache.getInstance(MyApplication.getAppContext());
    private int counter;
    Timer timer = new Timer();
    private FaceBookShare faceBookShare;
    private TwitterLogin twitterLogin;
    private FacebookPlatform facebookPlatform;
    private Handler mHandler = new Handler();
    private TwitterBindReponse twitterBindReponse;
    private FrameLayout fAdView;
    //    private AdView mAdView;
    private ImageView close_ad;
    private TranslateAnimation mShowAction;//显示动画
    private TranslateAnimation mHiddenAction;//隐藏动画
    private WebPresenter mWebPresenter;

    public static void toThis(Context mContext, String url) {
        Intent intent = new Intent(mContext, WebActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString(Constant.WEB_URL, url);
        intent.putExtras(bundle);
        mContext.startActivity(intent);
    }

    @Override
    public int getLayoutId() {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            this.mUrl = bundle.getString(Constant.WEB_URL);
            isAdvertisement = bundle.getBoolean(Common.BUNDLE_TO_ADVERTISEMENT);
        }
        return R.layout.activity_web;
    }

    @Override
    public void initView() {
        titleBar = findViewById(R.id.titlebar);
        refreshLayout = findViewById(R.id.web_sr);
        webview = findViewById(R.id.webview);
        webview.getSettings().setTextZoom(100);
        emptyLayout = findViewById(R.id.mEmptyLayout);
        loading_view = findViewById(R.id.loading_view);
//        mAdView = findViewById(R.id.video_banner_adView);
        fAdView = findViewById(R.id.f_ad_view);
        close_ad = findViewById(R.id.close_ad);
        mOtherActivityDialog = new OtherActivityDialog(WebActivity.this);
        Window window = mOtherActivityDialog.getWindow();
        window.setGravity(Gravity.CENTER);
        WindowManager.LayoutParams lp = window.getAttributes();
        window.setAttributes(lp);

        mOtherActivityDialog.setOnOpenBagListener(new OtherActivityDialog.OnOpenBagListener() {
            @Override
            public void onOpen(int typePage) {
                //跳转网页
                mPersonalJs.openNewWebPage(otherActivityUrl);
            }
        });

        //初始化动画
        mShowAction = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF,
                1.0f, Animation.RELATIVE_TO_SELF, 0.0f);
        mShowAction.setDuration(500);

        mHiddenAction = new TranslateAnimation(Animation.RELATIVE_TO_SELF,
                0.0f, Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF,
                1.0f);
        mHiddenAction.setDuration(500);


    }

    @Override
    public void initEvents() {
        close_ad.setOnClickListener(this);
        titleBar.setBackOnClick(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (webview.canGoBack()) {
                    webview.goBack();
                    return;
                }
                finish();
            }
        });
        titleBar.setCloseClickLisenter(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        emptyLayout.setOnEmptyRefreshLisenter(new EmptyLayout.onEmptyRefreshLisenter() {
            @Override
            public void onEmptyRefresh() {
                isError = false;
                webview.reload();
            }
        });
    }

    @Override
    public void onClickEvent(View v) {
        if (v == close_ad) {
            if (fAdView != null) {
                fAdView.startAnimation(mHiddenAction);
                fAdView.setVisibility(View.GONE);
            }
        }
    }

    @Override
    public void initObject() {
        mPresenter = new WebPresenter(this, this);
//        emptyLayout.setErrorType(EmptyLayout.LOADING, -1);
        mPersonalJs = new PersonalJs(this);
        mSettingJs = new SettingJs(this);
        StatusBarUtils.setColor(WebActivity.this, Color.parseColor("#FFFFFF"));
        EventBus.getDefault().register(this);
        setWebInfor();
        initJsMethod();
//        pageListBean = mUserSpCache.getPageListBean();
//        startTimer();
    }

    private void initJsMethod() {
        webview.addJavascriptInterface(mPersonalJs, "personal");

        //回首页
        webview.registerHandler(PersonalJs.METHOD_TO_MAIN_PAGE, new BridgeHandler() {
            @Override
            public void handler(String data, CallBackFunction function) {
                finish();
                mPersonalJs.goToMainNewsPage();
            }
        });
        webview.registerHandler(PersonalJs.METHOD_CLOSE_NEW_WEB_PAGE, new BridgeHandler() {
            @Override
            public void handler(String data, CallBackFunction function) {
                showBaseToast(PersonalJs.METHOD_CLOSE_NEW_WEB_PAGE);
                mPersonalJs.closeNewWebPage();
            }
        });
        webview.registerHandler(PersonalJs.METHOD_OPEN_SMS, new BridgeHandler() {
            @Override
            public void handler(String data, CallBackFunction function) {
                mPersonalJs.sendSms(data);
            }
        });
        webview.registerHandler(PersonalJs.METHOD_WECHAT_LOGIN, new BridgeHandler() {
            @Override
            public void handler(String data, final CallBackFunction function) {
                showBaseToast(mContext.getString(R.string.updateApk));
                if (facebookPlatform == null) {
                    facebookPlatform = new FacebookPlatform(WebActivity.this);
                }

                if (twitterLogin == null) {
                    twitterLogin = new TwitterLogin();
                }

                twitterLogin.loginTwitter(WebActivity.this, new TwitterLogin.titterLoginCallback() {
                    @Override
                    public void onSuccess(TwitterRegResponse data) {
                        TwitterBindReponse twitterBindReponse = new TwitterBindReponse();
                        twitterBindReponse.setCode(Common.JS_RESPONSE_CODE_SUCCEED);
                        twitterBindReponse.setHeadImg(data.getHeadImg());
                        twitterBindReponse.setNickName(data.getNickName());
                        twitterBindReponse.setTwitter_id(data.getTwitter_id());
                        final String responseData = new Gson().toJson(twitterBindReponse);
                        LogUtil.showLog("msg---bind twitter:" + responseData);
                        mHandler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                function.onCallBack(responseData);
                            }
                        }, 1000);
                    }

                    @Override
                    public void onFailure() {
                    }
                });
            }
        });

        webview.registerHandler(PersonalJs.METHOD_INI_ON_SUCCEED, new BridgeHandler() {
            @Override
            public void handler(String data, CallBackFunction function) {
                //邀请码输入成功关闭界面
                WebActivity.this.finish();
                EventBus.getDefault().post(new ToMePageEvent());
            }
        });

        webview.registerHandler(PersonalJs.OPEN_INTRODUCE_VIDEO, new BridgeHandler() {
            @Override
            public void handler(String data, CallBackFunction function) {
                //打开新手视频页面
//                startActivity(VideoPlayerActivity.class);
            }
        });

        webview.registerHandler(PersonalJs.METHOD_TO_ME_PAGE, new BridgeHandler() {
            @Override
            public void handler(String data, CallBackFunction function) {
                WebActivity.this.finish();
            }
        });

        webview.registerHandler(PersonalJs.METHOD_SCAN_COLLECT_VIDEO, new BridgeHandler() {
            @Override
            public void handler(String data, CallBackFunction function) {
                LogUtil.showLog(data);
//                showBaseToast("正在打开我的收藏");
//                VideoStatisticsRequest videoStatisticsRequest = new Gson().fromJson(data, VideoStatisticsRequest.class);
//              /*  MyNews myNews = new Gson().fromJson(data, MyNews.class);
//                if (myNews != null) {
//                    Bundle bundle = new Bundle();
//                    bundle.putParcelable(Common.BUNDLE_TO_VIDEO_DETAIL, myNews);
//                    openActivity(VideoActivity.class, bundle);
//                }*/
//
//                if (videoStatisticsRequest != null) {
//                    Bundle bundle = new Bundle();
//                    bundle.putString(Common.BUNDLE_TO_VIDEO_ID, videoStatisticsRequest.getVideoId());
//                    openActivity(VideoActivity.class, bundle);
//                }
            }
        });


        webview.registerHandler(PersonalJs.METHOD_SHARE_TO_ONE, new BridgeHandler() {
            @Override
            public void handler(final String data, final CallBackFunction function) {
                // LogUtils.logD("msg---点击分享:" + data);
                showBaseToast(mContext.getString(R.string.s_shared));
                final JsShareType jsShareType = new Gson().fromJson(data, JsShareType.class);
                LogUtil.showLog("msg---jsShare:" + jsShareType.toString());

                if (jsShareType.getType() == Common.SHARE_TYPE_FACEBOOK) {
                    if (faceBookShare == null)
                        faceBookShare = new FaceBookShare(WebActivity.this, new FacebookCallback() {
                            @Override
                            public void onSuccess(Object o) {
                                LogUtil.showLog("msg---Facebook分享成功");
//                                showBaseToast(getResources().getString(R.string.s_shared));
                                function.onCallBack(CommonUtils.getShareSuccesResponse());//结果回调给web
                                //分享成功计数
                                mPresenter.shareVisit(CommonUtils.getShareSuccesResponse(), jsShareType.getActivity_type(), jsShareType.getType());
                            }

                            @Override
                            public void onCancel() {
                                LogUtil.showLog("msg---Facebook分享取消");
                                function.onCallBack(CommonUtils.getShareCancelResponse());
                            }

                            @Override
                            public void onError(FacebookException error) {
                                LogUtil.showLog("msg---Facebook分享失败");
                                function.onCallBack(CommonUtils.getShareFailResponse());
//                                showBaseToast(getResources().getString(R.string.s_share_faild));
                            }
                        });
                    faceBookShare.share(jsShareType);
                } else if (jsShareType.getType() == Common.SHARE_TYPE_TWITTER) {
                    if (twitterLogin == null) {
                        twitterLogin = new TwitterLogin();
                        twitterLogin.register();
                    }
                    twitterLogin.setTwitterShareLisenter(new TwitterLogin.TwitterShareLisenter() {
                        @Override
                        public void getShareOk(String response) {
                            function.onCallBack(response);
                            LogUtil.showLog("msg---分享成功");
//                            showBaseToast(getResources().getString(R.string.s_shared));
                            mPresenter.shareVisit(response, jsShareType.getActivity_type(), jsShareType.getType());
                        }

                        @Override
                        public void getShareFail(String response) {
                            function.onCallBack(response);
                            LogUtil.showLog("msg---分享失败");
//                            showBaseToast(getResources().getString(R.string.s_share_faild));
                        }

                        @Override
                        public void getShareCancel(String response) {
                            function.onCallBack(response);
                            LogUtil.showLog("msg---分享取消");
                        }
                    });
                    twitterLogin.twitterShare(WebActivity.this, jsShareType, Common.TWITTER_SHARE_URL);
                } else if (jsShareType.getType() == Common.SHARE_TYPE_LINKEDIN) {
                    LinkedInPlatform linkedInPlatform = new LinkedInPlatform(WebActivity.this);
                    linkedInPlatform.linkedInShare(jsShareType);
                    linkedInPlatform.linkedInShareLisenter(new LinkedInPlatform.linkedInShareLisenter() {
                        @Override
                        public void getShareOk(String response) {
                            function.onCallBack(response);
                            //分享成功计数
                            mPresenter.shareVisit(response, jsShareType.getActivity_type(), jsShareType.getType());
//                            showBaseToast(getResources().getString(R.string.s_shared));
                            LogUtil.showLog("msg---分享成功");
                        }

                        @Override
                        public void getShareFail(String response) {
                            function.onCallBack(response);
                            LogUtil.showLog("msg---分享失败");
//                            showBaseToast(getResources().getString(R.string.s_share_faild));
                        }
                    });
                }
            }
        });
        //频道设置
        webview.registerHandler(SettingJs.METHOD_CHANNEL_SETTING, new BridgeHandler() {
            @Override
            public void handler(String data, CallBackFunction function) {
                showBaseToast(SettingJs.METHOD_CHANNEL_SETTING);
                mSettingJs.channelSetting(data);
            }
        });
        webview.registerHandler(SettingJs.METHOD_CLEAR_CACHE, new BridgeHandler() {
            @Override
            public void handler(String data, CallBackFunction function) {
                showBaseToast(mContext.getString(R.string.clear));
                //    mSettingJs.clearCache();
            }
        });
        webview.registerHandler(SettingJs.METHOD_LOGIN_OUT, new BridgeHandler() {
            @Override
            public void handler(String data, CallBackFunction function) {
//                showBaseToast("Logged Out");
                mSettingJs.logout();
            }
        });
        webview.registerHandler(SettingJs.METHOD_CHECK_UPDATE, new BridgeHandler() {
            @Override
            public void handler(String data, CallBackFunction function) {
                // Beta.checkUpgrade();
                /*showBaseToast("Check for Updates");
                UpdateInfo updateInfo = new UpdateInfo(WebActivity.this);
                updateInfo.getVersionInfo(false);*/
                //版本更新
            }
        });
        webview.registerHandler(SettingJs.METHOD_IMAGE_TYPE_SETTING, new BridgeHandler() {
            @Override
            public void handler(String data, CallBackFunction function) {
//                showBaseToast("已设置图片类型");
            }
        });
        webview.registerHandler(SettingJs.METHOD_TEXT_SIZE_SETTING, new BridgeHandler() {
            @Override
            public void handler(String data, CallBackFunction function) {
//                showBaseToast("已设置文字大小");
            }
        });
    }

    private void setWebInfor() {
        if (!TextUtils.isEmpty(mUrl)) {
            refreshLayout.setRefreshing(true);
            webview.loadUrl(mUrl);
        }
        refreshLayout.setColorSchemeColors(getResources().getColor(R.color.color_def));
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                if (webview != null) {
                    if (mPersonalJs.isRefreshUrl()) {
                        webview.reload();
                    } else {
                        refreshLayout.setRefreshing(false);
                    }
                }
            }
        });
        refreshLayout.setOnChildScrollUpCallback(new SwipeRefreshLayout.OnChildScrollUpCallback() {
            @Override
            public boolean canChildScrollUp(SwipeRefreshLayout parent, @Nullable View child) {
                return webview.getScrollY() > 0;
            }
        });
        webview.clearCache(true);
        webview.setDefaultHandler(new DefaultHandler());
        webview.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onReceivedTitle(WebView view, String title) {
                //为解决6.0系统上，这个api会调用两次，而且第一次是显示url的系统bug
                if (null != title && !view.getUrl().contains(title)) {
                    titleBar.setTitle(title);
                }
                super.onReceivedTitle(view, title);
            }
        });
        webview.getSettings().setJavaScriptEnabled(true);
        webview.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);

        webview.setWebViewClient(new MyWebClient(webview) {
                                     @RequiresApi(api = Build.VERSION_CODES.M)
                                     @Override
                                     public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                                         super.onReceivedError(view, request, error);
                                         //todo 临时方法，h5 加载出错
                                         if (mUrl.equals(Common.LLURL)) {
                                             return;
                                         }
                                         isError = true;
                                     }

                                     @Override
                                     public void onPageStarted(WebView view, String url, Bitmap favicon) {
                                         if (url.contains(Api.BASE_WEB_URL)) {
                                             mUrl = url;
                                         }
                                         super.onPageStarted(view, url, favicon);
                                     }

                                     @Override
                                     public void onPageFinished(WebView view, String url) {
                                         super.onPageFinished(view, url);
                                         if (refreshLayout != null) {
//                                             startTimer();
                                         }
                                         if (isError) {
                                             refreshLayout.setRefreshing(false);
                                             webview.setVisibility(View.GONE);
                                             emptyLayout.setErrorType(EmptyLayout.NO_DATA, EmptyLayout.NETWORK_ERROR);
                                             titleBar.setTitle(getResources().getString(R.string.app_name));
                                             isError = false;
                                         }
                                     }
                                 }
        );
    }

    class MyWebClient extends BridgeWebViewClient {

        public MyWebClient(BridgeWebView webView) {
            super(webView);
        }
    }

    /**
     * JS调用 eventbus处理
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onClosePageEvent(ClosePageEvent event) {
        finish();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onGoldComeEvent(JsGoldCome event) {
        // 0 金币代表今日次数已领完
        if (event.getCount() == 0) {
            return;
        }
        if (mGoldComeDialog == null) {
            mGoldComeDialog = new GoldComeDialog(this);
        }
        if (!mGoldComeDialog.isShowing()) {
            mGoldComeDialog.setCanceledOnTouchOutside(false);//点击空白处不消失
            mGoldComeDialog.showDialog(event.getCount());
        }
        /**
         * 声音
         */
        if (mediaPlayer == null) {
            mediaPlayer = MediaPlayer.create(this, R.raw.gold_come);
        }
        mediaPlayer.start();

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onOpenTheTreasureBox(JsOpenTheTreasureBox event) {
        //百度海外版广告激励视频
//        if (mBaiDuVideoAdUtils.isDuAdShow()) {
//            mBaiDuVideoAdUtils.DuAdShow();
//        }

        if (mOpenTheTreasureBoxDialog == null) {
            mOpenTheTreasureBoxDialog = new OpenTheTreasureBoxDialog(this);
        }
        if (!mOpenTheTreasureBoxDialog.isShowing()) {
            mOpenTheTreasureBoxDialog.setCanceledOnTouchOutside(false);//点击空白处不消失
            mOpenTheTreasureBoxDialog.showDialog(event.getCount());
        }

    }

    @RequiresApi(api = Build.VERSION_CODES.HONEYCOMB)
    @Override
    protected void onResume() {
        super.onResume();
        if (webview != null) {
            webview.onResume();
        }

    }

    @RequiresApi(api = Build.VERSION_CODES.HONEYCOMB)
    @Override
    protected void onPause() {
        super.onPause();
        if (webview != null) {
            webview.onPause();
        }

    }

    @Override
    public void onBindWxSucceed(int count) {

    }

    @Override
    public void onShareInfo(ShareResponse shareResponse) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showErrorTip(int code, String msg) {

    }

    public void showBaseToast(String msg) {
        ToastUtils.showLong(this, msg);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (facebookPlatform != null) {
            facebookPlatform.getCallbackManager().onActivityResult(requestCode, resultCode, data);
        }
        super.onActivityResult(requestCode, resultCode, data);

        if (twitterLogin != null) {
            twitterLogin.setActivityResult(requestCode, resultCode, data);
        }

        if (faceBookShare != null) {
            faceBookShare.getCallbackManager().onActivityResult(requestCode, resultCode, data);
        }
        LISessionManager.getInstance(this).onActivityResult(this, requestCode, resultCode, data);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void showJsGoToRarn(JsPageLoadCompletion jsPageLoadCompletion) {
        //显示页面
        emptyLayout.setErrorType(EmptyLayout.HIDE_LAYOUT, -1);
        titleBar.setTitle(jsPageLoadCompletion.getTitle());
        if (webview.getVisibility() == View.INVISIBLE) {
            webview.setVisibility(View.VISIBLE);
        }
        if (refreshLayout.isRefreshing()) {
            refreshLayout.setRefreshing(false);
        }
    }
}
