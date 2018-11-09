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

import com.news.mobile.R;
import com.news.mobile.base.BaseActivity;
import com.news.mobile.base.Constant;
import com.news.mobile.db.AppDatabase;
import com.news.mobile.db.NewsDb;
import com.news.mobile.entiyt.NewsAddGoodResponse;
import com.news.mobile.entiyt.NewsDetailResponse;
import com.news.mobile.entiyt.NewsGoldResponse;
import com.news.mobile.entiyt.NewsInfoResponse;
import com.news.mobile.entiyt.request.NewsAddGoodRequest;
import com.news.mobile.entiyt.request.NewsDetailRequest;
import com.news.mobile.entiyt.request.NewsGoldRequest;
import com.news.mobile.main.news.adapter.NewsCommitAdapter;
import com.news.mobile.main.news.contract.NewsDetailContract;
import com.news.mobile.main.news.model.NewsDetailModel;
import com.news.mobile.main.news.presenter.NewsDetailPresenter;
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
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
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

    private long DURATION = 40 * 1000;  //金币总进度
    private NewsCommitAdapter adapter;

    private ProgressBar web_progress;
    private LinearLayout ll_commit_top;
    private float progress;

    private String newsId = "15";
    private String isDebug = "ok";
    private NewsDetailResponse.DataBean data;
    private NewsDetailResponse.DataBean dbData;

    private boolean hasAddGold = false;
    private NewsDb newsDb;

    public static void toThis(Context mContext, NewsInfoResponse.DataBeanX.DataBean response) {
        Intent intent = new Intent(mContext, NewsDetailsRvActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable(Constant.NEWSINFO, response);
        bundle.putString(Constant.NEWS_ID,response.getId()+"");
        intent.putExtras(bundle);
        mContext.startActivity(intent);

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_new_details_rv;
    }

    @Override
    public void initView() {
        dataBean = getIntent().getParcelableExtra(Constant.NEWSINFO);
        //newsId = getIntent().getStringExtra(Constant.NEWS_ID);
        newsId = "12";


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

        rv_commit = findViewById(R.id.rv_commit);
        rv_commit.setLayoutManager(new LinearLayoutManager(this));

        adapter = new NewsCommitAdapter(new ArrayList<String>());
        rv_commit.setAdapter(adapter);

        progress = UserSpCache.getInstance(getApplicationContext()).getFloat(Common.PROGRESS);
        mProgress.setProgress(progress);
        empty.setErrorType(EmptyLayout.LOADING, -1);

        newsDb = new NewsDb(this);

        dbData = newsDb.getNews(newsId);
        if(dbData == null){
            hasAddGold = false;
        }else{
            hasAddGold = dbData.isHasGold();
        }

    }

    private void initHeader(NewsDetailResponse.DataBean response) {
        View view = getLayoutInflater().inflate(R.layout.header_new_details, (ViewGroup) rv_commit.getParent(), false);

        webView = view.findViewById(R.id.wv_news_details);
        tv_title = view.findViewById(R.id.tv_title);
        tv_author_time = view.findViewById(R.id.tv_author_time);
        tv_watch = view.findViewById(R.id.tv_watch);

        tv_title.setText(response.getTitle());
        tv_author_time.setText(response.getAuthor_name() + "," + response.getCreate_time());
        tv_watch.setText(response.getVisit_count() + "");

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
                    setCommit();
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
                webView.reload();
            }
        });

        rv_commit.setOnProgressListener(new MyRecyclerView.OnProgressListener() {
            @Override
            public void onStopScroll() {
                if(!hasAddGold){
                    mProgress.animStart(DURATION);
                }
            }
        });

        mProgress.setOnNewsProgressLisenter(new MyNewsProgress.OnNewsProgressLisenter() {
            @Override
            public void end() {
                NewsGoldRequest request = new NewsGoldRequest();
                request.setId(newsId);
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
                    ToastUtils.showShort(mContext, getString(R.string.sendCodeerror));
                    return;
                }

                NewsAddGoodRequest request = new NewsAddGoodRequest();
                request.setNew_id(newsId);
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

    @Override
    public void onClickEvent(View v) {
        if (v == action_bar_back_iv) {
            finish();
        } else if (v == tv_input) {
            editLisenter();
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

                }
            }
        });
        //EdittextUtlis.setSendText(getString(R.string.ok));
    }

    private void setCommit() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {

            if (i == 5) {
                list.add("item = 5 sssssssssssssssndndndnndndndndndndndndndndndndndndndndndndndndn");
                continue;
            }
            list.add("item = " + i);
        }
        adapter.setNewData(list);
        webSr.finishRefresh();
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
        data = response;

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
    public void showLoading() {
        if(dbData != null){
            data = dbData;
            getNewsListSuccess(data);
        }else {
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
}
