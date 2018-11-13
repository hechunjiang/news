package com.news.mobile.main.news.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.google.gson.Gson;
import com.news.mobile.R;
import com.news.mobile.base.BaseActivity;
import com.news.mobile.base.Constant;
import com.news.mobile.db.AppDatabase;
import com.news.mobile.db.NewsDb;
import com.news.mobile.entiyt.JsShareType;
import com.news.mobile.entiyt.NewsAddGoodResponse;
import com.news.mobile.entiyt.NewsCommonListResponse;
import com.news.mobile.entiyt.NewsCommonResponse;
import com.news.mobile.entiyt.NewsDetailResponse;
import com.news.mobile.entiyt.NewsGoldResponse;
import com.news.mobile.entiyt.NewsInfoResponse;
import com.news.mobile.entiyt.NewsSharedContent;
import com.news.mobile.entiyt.request.NewsAddGoodRequest;
import com.news.mobile.entiyt.request.NewsCommontListRequest;
import com.news.mobile.entiyt.request.NewsCommontRequest;
import com.news.mobile.entiyt.request.NewsDetailRequest;
import com.news.mobile.entiyt.request.NewsGoldRequest;
import com.news.mobile.entiyt.request.ShareNewsRequest;
import com.news.mobile.main.news.adapter.NewsCommitAdapter;
import com.news.mobile.main.news.contract.NewsDetailContract;
import com.news.mobile.main.news.model.NewsDetailModel;
import com.news.mobile.main.news.presenter.NewsDetailPresenter;
import com.news.mobile.tplatform.facebook.FaceBookShare;
import com.news.mobile.tplatform.linkedin.LinkedInPlatform;
import com.news.mobile.tplatform.twitter.TwitterLogin;
import com.news.mobile.tplatform.whatsapp.WhatsAppShare;
import com.news.mobile.utils.Common;
import com.news.mobile.utils.LogUtil;
import com.news.mobile.utils.StatusBarUtils;
import com.news.mobile.utils.ToastUtils;
import com.news.mobile.utils.UserSpCache;
import com.news.mobile.view.EdittextUtlis;
import com.news.mobile.view.EmptyLayout;
import com.news.mobile.view.GifView;
import com.news.mobile.view.MyNewsProgress;
import com.news.mobile.view.MyRecyclerView;
import com.news.mobile.view.MyRefreshLayout;
import com.news.mobile.view.MyScrollView;
import com.news.mobile.view.MyWebView;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.umeng.analytics.MobclickAgent;
import com.wx.goodview.GoodView;
import com.wx.goodview.IGoodView;

import java.util.ArrayList;
import java.util.List;

public class NewsDetailsRvActivity
        extends BaseActivity<NewsDetailPresenter, NewsDetailModel> implements NewsDetailContract.View {

    private NewsInfoResponse.DataBeanX.DataBean dataBean;
    private MyWebView webView;
    private MyNewsProgress mProgress;
    private TextView tvGold, tvFrequency;
    private MyRefreshLayout webSr;
    private RelativeLayout fWebLoading;
    private GifView gifWebLoading;
    //    private AdView mAdView;
    private FrameLayout fAdView;
    private LinearLayout llRewardTips;
    private ImageView action_bar_back_iv;
    private RelativeLayout video_progress_layout;
    private ImageView iv_gold;
    private CheckBox iv_good;
    private TextView tv_input;

    private EmptyLayout empty;
    private MyRecyclerView rv_commit;
    private TextView tv_commont_num;
    private TextView tv_title;
    private TextView tv_author_time;
    private TextView tv_watch;
    private TextView tv_review_size;

    private long DURATION = 40 * 1000;  //金币总进度
    private NewsCommitAdapter adapter;

    private ProgressBar web_progress;
    private LinearLayout ll_commit_top;
    private float progress;
    private RelativeLayout rl_commont;

    private String task_id = "1004";
    private String newsId = "15";
    private String isDebug = "ok";
    private NewsDetailResponse.DataBean data;
    private NewsDetailResponse.DataBean dbData;

    private boolean hasAddGold = false;
    private NewsDb newsDb;

    private int page = 1;
    private int size = 20;
    private String order = "time";

    private ImageView iv_facebook, iv_twitter, iv_whats;
    TwitterLogin mTwitterLogin;
    FaceBookShare mFaceBookShare;
    private WhatsAppShare whatsAppShare;

    public static void toThis(Context mContext, NewsInfoResponse.DataBeanX.DataBean response) {
        Intent intent = new Intent(mContext, NewsDetailsRvActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable(Constant.NEWSINFO, response);
        bundle.putString(Constant.NEWS_ID, response.getId() + "");
        intent.putExtras(bundle);
        mContext.startActivity(intent);

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_new_details_rv;
    }

    @Override
    public void initView() {
        //dataBean = getIntent().getParcelableExtra(Constant.NEWSINFO);
        newsId = getIntent().getStringExtra(Constant.NEWS_ID);
        //newsId = "2";


        rl_commont = findViewById(R.id.rl_commont);
        webView = findViewById(R.id.wv_news_details);
        mProgress = findViewById(R.id.video_progress);
        webSr = findViewById(R.id.web_sr);
        gifWebLoading = findViewById(R.id.gif_web_loading);
        fWebLoading = findViewById(R.id.f_web_loading);
//        mAdView = findViewById(R.id.video_banner_adView);
        fAdView = findViewById(R.id.f_ad_view);
        llRewardTips = findViewById(R.id.ll_reward_tips);
        //webSr.setColorSchemeColors(getResources().getColor(R.color.tab_tv_color_cli));
        action_bar_back_iv = findViewById(R.id.action_bar_back_iv);
        video_progress_layout = findViewById(R.id.video_progress_layout);
        iv_gold = findViewById(R.id.iv_gold);
        empty = findViewById(R.id.empty);
        iv_good = findViewById(R.id.iv_good);
        tv_input = findViewById(R.id.tv_input);

        tv_commont_num = findViewById(R.id.tv_commont_num);

        web_progress = findViewById(R.id.web_progress);

        //分享相关
        iv_facebook = findViewById(R.id.iv_facebook);
        iv_twitter = findViewById(R.id.iv_twitter);
        iv_whats = findViewById(R.id.iv_whats);


        rv_commit = findViewById(R.id.rv_commit);
        rv_commit.setLayoutManager(new LinearLayoutManager(this));

        adapter = new NewsCommitAdapter(new ArrayList<NewsCommonListResponse.DataBean>());
        rv_commit.setAdapter(adapter);

        whatsAppShare = new WhatsAppShare(mContext);


        progress = UserSpCache.getInstance(getApplicationContext()).getFloat(Common.PROGRESS);
        mProgress.setProgress(progress);
        empty.setErrorType(EmptyLayout.LOADING, -1);

        newsDb = new NewsDb(this);

        dbData = newsDb.getNews(newsId);
        if (dbData == null) {
            hasAddGold = false;
        } else {
            hasAddGold = dbData.isHasGold();
        }

    }

    private void initHeader(NewsDetailResponse.DataBean response) {
        View view = getLayoutInflater().inflate(R.layout.header_new_details, (ViewGroup) rv_commit.getParent(), false);

        webView = view.findViewById(R.id.wv_news_details);
        tv_title = view.findViewById(R.id.tv_title);
        tv_author_time = view.findViewById(R.id.tv_author_time);
        tv_watch = view.findViewById(R.id.tv_watch);
        tv_review_size = view.findViewById(R.id.tv_review_size);

        tv_title.setText(response.getTitle());
        tv_author_time.setText(response.getAuthor_name() + "," + response.getCreate_time());
        tv_watch.setText(response.getVisit_count() + "");
        tv_review_size.setText(getString(R.string.review_size, response.getComment_count()));

        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient() {

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                ll_commit_top.setVisibility(View.INVISIBLE);
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                webView.loadUrl(url);
                return true;
            }

            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                super.onReceivedError(view, request, error);
                LogUtil.showLog("网页加载错误");
                empty.setErrorType(EmptyLayout.LOAD_ERROR, EmptyLayout.NET_WORK_ERROR);
            }
        });
        webView.setmOnScrollChangeListener(new MyWebView.OnScrollChangeListener() {
            @Override
            public void progress(int progress) {
                if (progress == 100) {
                    web_progress.setVisibility(View.GONE);

                    if (hasAddGold) {
                        video_progress_layout.setVisibility(View.GONE);
                    } else {
                        //加载完成后显示是否获取到金币
                        video_progress_layout.setVisibility(View.VISIBLE);
                        mProgress.animStart(DURATION);
                    }

                    ll_commit_top.setVisibility(View.VISIBLE);
                    //页面加载完成在设置评论
                    page = 1;
                    isRefresh = true;
                    NewsCommontListRequest request = new NewsCommontListRequest();
                    request.setNews_id(newsId);
                    request.setPage(page + "");
                    request.setSize(size + "");
                    request.setOrder(order);
                    mPresenter.commontList(request);
                } else {
                    web_progress.setVisibility(View.VISIBLE);
                    web_progress.setProgress(progress);
                }
            }
        });


        if (!TextUtils.isEmpty(response.getContent())) {
            webView.loadDataWithBaseURL(null, response.getContent(), "text/html", "utf-8", null);
        }

        ll_commit_top = view.findViewById(R.id.ll_commit_top);

        adapter.addHeaderView(view);
    }

    @Override
    public void initEvents() {
        action_bar_back_iv.setOnClickListener(this);
        tv_input.setOnClickListener(this);
        rl_commont.setOnClickListener(this);
        iv_facebook.setOnClickListener(this);
        iv_twitter.setOnClickListener(this);
        iv_whats.setOnClickListener(this);
        rv_commit.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (mShouldScroll && RecyclerView.SCROLL_STATE_IDLE == newState) {
                    mShouldScroll = false;
                    smoothMoveToPosition(rv_commit, mToPosition);
                }
            }
        });

        empty.setOnEmptyRefreshLisenter(new EmptyLayout.onEmptyRefreshLisenter() {
            @Override
            public void onEmptyRefresh() {
                NewsDetailRequest request = new NewsDetailRequest();
                request.setDebug(isDebug);
                request.setId(newsId);
                mPresenter.getNewsDetail(request);
            }
        });
        webSr.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                isRefresh = true;
                page = 1;
                //评论上拉加载
                NewsCommontListRequest request = new NewsCommontListRequest();
                request.setNews_id(newsId);
                request.setPage(page + "");
                request.setSize(size + "");
                request.setOrder(order);
                mPresenter.commontList(request);
            }
        });

        webSr.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                isRefresh = false;
                page += 1;
                //评论上拉加载
                NewsCommontListRequest request = new NewsCommontListRequest();
                request.setNews_id(newsId);
                request.setPage(page + "");
                request.setSize(size + "");
                request.setOrder(order);
                mPresenter.commontList(request);
            }
        });

        rv_commit.setOnProgressListener(new MyRecyclerView.OnProgressListener() {
            @Override
            public void onStopScroll() {
                if (!hasAddGold) {
                    mProgress.animStart(DURATION);
                }
            }
        });

        mProgress.setOnNewsProgressLisenter(new MyNewsProgress.OnNewsProgressLisenter() {
            @Override
            public void end() {
                NewsGoldRequest request = new NewsGoldRequest();
                request.setId(task_id);
                request.setNews_id(newsId);
                request.setDebug(isDebug);
                mPresenter.getNewsGold(request);
                mProgress.setProgress(0);
                hasAddGold = true;
            }
        });

        iv_good.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (data == null) {
                    //ToastUtils.showShort(mContext, getString(R.string.sendCodeerror));
                    return;
                }

                NewsAddGoodRequest request = new NewsAddGoodRequest();
                request.setNews_id(newsId);
                request.setDu_type(data.getDu_type() + "");
                if (isChecked) {
                    final GoodView goodView = new GoodView(mContext);
                    goodView.setImage(R.mipmap.good);
                    goodView.show(buttonView);

                    mPresenter.addGood(request);

                } else {
                    final GoodView goodView = new GoodView(mContext);
                    goodView.setImage(R.mipmap.good_un);
                    goodView.show(buttonView);

                    mPresenter.addGood(request);
                }
            }
        });

    }

    //目标项是否在最后一个可见项之后
    private boolean mShouldScroll;
    //记录目标项位置
    private int mToPosition;

    /**
     * 滑动到指定位置
     */
    private void smoothMoveToPosition(RecyclerView mRecyclerView, final int position) {
        // 第一个可见位置
        int firstItem = mRecyclerView.getChildLayoutPosition(mRecyclerView.getChildAt(0));
        // 最后一个可见位置
        int lastItem = mRecyclerView.getChildLayoutPosition(mRecyclerView.getChildAt(mRecyclerView.getChildCount() - 1));
        if (position < firstItem) {
            // 第一种可能:跳转位置在第一个可见位置之前，使用smoothScrollToPosition
            mRecyclerView.smoothScrollToPosition(position);
        } else if (position <= lastItem) {
            // 第二种可能:跳转位置在第一个可见位置之后，最后一个可见项之前
            int movePosition = position - firstItem;
            if (movePosition >= 0 && movePosition < mRecyclerView.getChildCount()) {
                int top = mRecyclerView.getChildAt(movePosition).getTop();
                // smoothScrollToPosition 不会有效果，此时调用smoothScrollBy来滑动到指定位置
                mRecyclerView.smoothScrollBy(0, top);
            }
        } else {
            // 第三种可能:跳转位置在最后可见项之后，则先调用smoothScrollToPosition将要跳转的位置滚动到可见位置
            // 再通过onScrollStateChanged控制再次调用smoothMoveToPosition，执行上一个判断中的方法
            mRecyclerView.smoothScrollToPosition(position);
            mToPosition = position;
            mShouldScroll = true;
        }
    }

    @Override
    public void onClickEvent(View v) {
        if (v == action_bar_back_iv) {
            finish();
        } else if (v == tv_input) {
            editLisenter();
        } else if (v == rl_commont) {
            smoothMoveToPosition(rv_commit, 1);
        } else if (v == iv_facebook) {
            mPresenter.getSharedConttent(getShareNewRequest(newsId, ""), Common.SHARE_TYPE_FACEBOOK);
        } else if (v == iv_twitter) {
            mPresenter.getSharedConttent(getShareNewRequest(newsId, ""), Common.SHARE_TYPE_TWITTER);
        } else if (v == iv_whats) {
            mPresenter.getSharedConttent(getShareNewRequest(newsId, ""), Common.SHARE_TYPE_WHATS);
        }
    }

    @Override
    public void initObject() {
        StatusBarUtils.setStatusBar(this, Color.WHITE);

        setMVP();

        NewsDetailRequest request = new NewsDetailRequest();
        request.setDebug(isDebug);
        request.setId(newsId);
        mPresenter.getNewsDetail(request);

    }

    private void editLisenter() {
        EdittextUtlis.showCommentEdit(NewsDetailsRvActivity.this, tv_input, new EdittextUtlis.liveCommentResult() {
            @Override
            public void onResult(boolean confirmed, String comment) {
                if (confirmed) {
                    NewsCommontRequest request = new NewsCommontRequest();
                    request.setNews_id(newsId);
                    request.setContent(comment);
                    mPresenter.commont(request);
                }
            }
        });
        //EdittextUtlis.setSendText(getString(R.string.ok));
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && webView.canGoBack()) {
            webView.goBack();
            return true;
        } else {
            onBackPressed();
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //TODO:此处要缓存进度
        progress = mProgress.getProgressCurrent();
        if (progress < 0) progress = 0;
        else if (progress >= 360f) {
            progress = 0f;  //以防万一用户结束progress时，正好处于加金币状态
        }
        UserSpCache.getInstance(getApplicationContext()).putFloat(Common.PROGRESS, progress);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mProgress.stopProgress();
    }

    @Override
    public void getNewsListSuccess(NewsDetailResponse.DataBean response) {
        empty.setErrorType(EmptyLayout.HIDE_LAYOUT, -1);

        initHeader(response);
        tv_commont_num.setText(response.getComment_count() + "");
        iv_good.setChecked(response.isIs_liked());

        data = response;
        data.setHasGold(hasAddGold);
        newsDb.saveNews(data);

    }

    @Override
    public void getGoldSuccess(NewsGoldResponse response) {
        ToastUtils.showGoldCoinToast(mContext, response.getMsg(), response.getData().getCount() + "");
        data.setHasGold(true);
        newsDb.updateNews(data);

    }

    @Override
    public void addGood(NewsAddGoodResponse response) {
        ToastUtils.showShort(mContext, response.getMsg());
    }

    @Override
    public void commontList(NewsCommonListResponse response) {

        if (isRefresh) {
            webSr.finishRefresh();
            adapter.setNewData(response.getData());
        } else {
            webSr.finishLoadmore();
            adapter.addData(response.getData());
        }
    }

    @Override
    public void commont(NewsCommonResponse response) {
        ToastUtils.showShort(mContext, response.getMsg());

        tv_review_size.setText(getString(R.string.review_size, response.getData().getComment_count()));
        tv_commont_num.setText(response.getData().getComment_count() + "");

        page = 1;
        isRefresh = true;
        NewsCommontListRequest request = new NewsCommontListRequest();
        request.setNews_id(newsId);
        request.setPage(page + "");
        request.setSize(size + "");
        request.setOrder(order);
        mPresenter.commontList(request);
    }

    @Override
    public void getSharedConttentSuccess(NewsSharedContent content, int type) {
        String jsShare = mPresenter.getShareJson(content, type);
        final JsShareType jsShareType = new Gson().fromJson(jsShare, JsShareType.class);

        if (type == Common.SHARE_TYPE_TWITTER) {
            if (mTwitterLogin == null) mTwitterLogin = new TwitterLogin();
            mTwitterLogin.setTwitterShareLisenter(new TwitterLogin.TwitterShareLisenter() {
                @Override
                public void getShareOk(String response) {
                    LogUtil.showLog("twtter分享成功");

                }

                @Override
                public void getShareFail(String response) {
                    LogUtil.showLog("twtter分享失败");
                    ToastUtils.showShort(mContext, getString(R.string.sharedFialed));
                }

                @Override
                public void getShareCancel(String response) {
                    LogUtil.showLog("twtter分享取消");
                    ToastUtils.showShort(mContext, getString(R.string.sharedCancel));
                }
            });
            mTwitterLogin.twitterShare(NewsDetailsRvActivity.this, jsShareType, Common.TWITTER_SHARE_IAMGE);
        } else if (type == Common.SHARE_TYPE_FACEBOOK) {
            if (mFaceBookShare == null)
                mFaceBookShare = new FaceBookShare(NewsDetailsRvActivity.this, new FacebookCallback() {
                    @Override
                    public void onSuccess(Object o) {
                        LogUtil.showLog("face 分享成功");
                        //ToastUtils.showShort(mContext, getString(R.string.sharedSuccess));
                        mPresenter.shareVisit(dataBean.getId());
                    }

                    @Override
                    public void onCancel() {
                        LogUtil.showLog("face 分享失败");
                        ToastUtils.showShort(mContext, getString(R.string.sharedCancel));
                    }

                    @Override
                    public void onError(FacebookException error) {
                        LogUtil.showLog("face 分享取消");
                        ToastUtils.showShort(mContext, getString(R.string.sharedFialed));

                    }
                });


            mFaceBookShare.share(jsShareType);
        } else if (type == Common.SHARE_TYPE_LINKEDIN) {
            LinkedInPlatform mLinkedInPlatform = new LinkedInPlatform(NewsDetailsRvActivity.this);
            mLinkedInPlatform.linkedInShareLisenter(new LinkedInPlatform.linkedInShareLisenter() {
                @Override
                public void getShareOk(String response) {
                    //ToastUtils.showShort(mContext, getString(R.string.sharedSuccess));
                    mPresenter.shareVisit(dataBean.getId());


                }

                @Override
                public void getShareFail(String response) {
                    ToastUtils.showShort(mContext, getString(R.string.sharedFialed));
                }
            });
            mLinkedInPlatform.linkedInShare(jsShareType);
        } else if (type == Common.SHARE_TYPE_WHATS) {
            mPresenter.shareVisit(dataBean.getId());
            whatsAppShare.shareLink(jsShareType.getUrl());
        }
    }

    @Override
    public ShareNewsRequest getShareNewRequest(String newsid, String key_code) {
        ShareNewsRequest request = new ShareNewsRequest();
        request.setKey_code("old");//默认为old
        request.setNews_id(newsid);
        return request;
    }

    @Override
    public void sharednewsSuccess() {
        ToastUtils.showShort(mContext, getResources().getString(R.string.success));
    }

    @Override
    public void showLoading() {
        if (dbData != null) {
            data = dbData;
            getNewsListSuccess(data);
        } else {
            empty.setErrorType(EmptyLayout.LOAD_ERROR, EmptyLayout.NET_WORK_ERROR);
        }
    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showErrorTip(int code, String msg) {
        ToastUtils.showShort(mContext, msg);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

    }
}
