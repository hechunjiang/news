package com.news.mobilephone.main.news.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.news.mobilephone.R;
import com.news.mobilephone.base.BaseActivity;
import com.news.mobilephone.base.Constant;
import com.news.mobilephone.entiyt.NewsCommonListResponse;
import com.news.mobilephone.entiyt.NewsInfoResponse;
import com.news.mobilephone.main.news.adapter.NewsCommitAdapter;
import com.news.mobilephone.utils.ToastUtils;
import com.news.mobilephone.view.GifView;
import com.news.mobilephone.view.MyNewsProgress;
import com.news.mobilephone.view.MyScrollView;
import com.news.mobilephone.view.MyWebView;

import java.util.ArrayList;

public class NewsDetailsActivity extends BaseActivity {

    private NewsInfoResponse.DataBeanX.DataBean dataBean;
    private MyWebView webView;
    private MyScrollView scrollView;
    private MyNewsProgress mProgress;
    private TextView tvGold, tvFrequency;
    private SwipeRefreshLayout webSr;
    private RelativeLayout fWebLoading;
    private GifView gifWebLoading;
    //    private AdView mAdView;
    private FrameLayout fAdView;
    private LinearLayout llRewardTips;
    private TextView action_bar_close_tv;
    private ImageView action_bar_back_iv;
    private  RelativeLayout video_progress_layout;
    private ImageView iv_gold;

    private RecyclerView rv_commit;

    private long DURATION = 40 * 1000;  //金币总进度

    public static void toThis(Context mContext, NewsInfoResponse.DataBeanX.DataBean response) {
        Intent intent = new Intent(mContext, NewsDetailsActivity.class);
        Bundle bundle = new Bundle();
//        bundle.putParcelable(Constant.NEWSINFO, response);
        intent.putExtras(bundle);
        mContext.startActivity(intent);

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_news_details;
    }

    @Override
    public void initView() {
        dataBean = getIntent().getParcelableExtra(Constant.NEWSINFO);
        webView = findViewById(R.id.wv_news_details);
        scrollView = findViewById(R.id.sv_news_details);
        mProgress = findViewById(R.id.video_progress);
        tvGold = findViewById(R.id.tv_gold);
        tvFrequency = findViewById(R.id.tv_frequency);
        webSr = findViewById(R.id.web_sr);
        gifWebLoading = findViewById(R.id.gif_web_loading);
        fWebLoading = findViewById(R.id.f_web_loading);
//        mAdView = findViewById(R.id.video_banner_adView);
        fAdView = findViewById(R.id.f_ad_view);
        llRewardTips = findViewById(R.id.ll_reward_tips);
        webSr.setColorSchemeColors(getResources().getColor(R.color.tab_tv_color_cli));
        action_bar_close_tv = findViewById(R.id.action_bar_close_tv);
        action_bar_back_iv = findViewById(R.id.action_bar_back_iv);
        video_progress_layout = findViewById(R.id.video_progress_layout);
        iv_gold = findViewById(R.id.iv_gold);
        rv_commit = findViewById(R.id.rv_commit);
        rv_commit.setLayoutManager(new LinearLayoutManager(this));
        rv_commit.setNestedScrollingEnabled(false);

    }

    @Override
    public void initEvents() {
        action_bar_close_tv.setOnClickListener(this);
        action_bar_back_iv.setOnClickListener(this);
        webSr.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                webView.reload();
            }
        });

        scrollView.setOnScrollStateListener(new MyScrollView.OnScrollStateListener() {
            @Override
            public void onScrollStop() {
                mProgress.animStart(DURATION);
            }
        });

        mProgress.setOnNewsProgressLisenter(new MyNewsProgress.OnNewsProgressLisenter() {
            @Override
            public void end() {
                ToastUtils.showGoldCoinToast(mContext,"模拟加金币","+30");
            }
        });

    }

    @Override
    public void onClickEvent(View v) {
        if (v == action_bar_close_tv || v == action_bar_back_iv) {
            finish();
        }
    }

    @Override
    public void initObject() {
        webView.getSettings().setJavaScriptEnabled(true);
//        webView.loadUrl(dataBean.getHref());
        //TODO:测试
        webView.loadUrl("https://blog.csdn.net/lowprofile_coding/article/details/77928614");
        webView.setWebViewClient(new WebViewClient() {

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                //加载完成后显示是否获取到金币
                video_progress_layout.setVisibility(View.VISIBLE);
                mProgress.animStart(DURATION);
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                webView.loadUrl(url);
                return true;
            }
        });

        setCommit();
    }

    private void setCommit() {
        rv_commit.setAdapter(new NewsCommitAdapter(new ArrayList<NewsCommonListResponse.DataBean>()));
    }

    private void startGold(){
        RotateAnimation rotate  = new RotateAnimation(0f, 360f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        LinearInterpolator lin = new LinearInterpolator();
        rotate.setInterpolator(lin);
        rotate.setDuration(2000);//设置动画持续周期
        rotate.setRepeatCount(-1);//设置重复次数
        rotate.setFillAfter(true);//动画执行完后是否停留在执行完的状态
        rotate.setStartOffset(10);//执行前的等待时间
        iv_gold.setAnimation(rotate);

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
        float progressCurrent = mProgress.getProgressCurrent();
        if(progressCurrent < 0) progressCurrent = 0;
        else if(progressCurrent >= 360f){
            //progressCurrent = 358f;  //以防万一用户结束progress时，正好处于加金币状态
        }
    }
}
