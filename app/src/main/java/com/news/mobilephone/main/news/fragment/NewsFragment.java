package com.news.mobilephone.main.news.fragment;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.google.gson.Gson;
import com.news.mobilephone.R;
import com.news.mobilephone.base.BaseFragment;
import com.news.mobilephone.base.Constant;
import com.news.mobilephone.entiyt.JsShareType;
import com.news.mobilephone.entiyt.NewsInfoResponse;
import com.news.mobilephone.entiyt.NewsSharedContent;
import com.news.mobilephone.entiyt.event.MessageEvent;
import com.news.mobilephone.entiyt.request.NewsListRequest;
import com.news.mobilephone.entiyt.request.PariseRequest;
import com.news.mobilephone.entiyt.request.ShareNewsRequest;
import com.news.mobilephone.entiyt.request.SharedVistRequest;
import com.news.mobilephone.main.news.activity.NewsDetailsRvActivity;
import com.news.mobilephone.main.news.adapter.NewsInforAdapter;
import com.news.mobilephone.main.news.contract.NewsContract;
import com.news.mobilephone.main.news.model.NewsListModel;
import com.news.mobilephone.main.news.presenter.NewsListPresenter;
import com.news.mobilephone.tplatform.facebook.FaceBookShare;
import com.news.mobilephone.tplatform.linkedin.LinkedInPlatform;
import com.news.mobilephone.tplatform.twitter.TwitterLogin;
import com.news.mobilephone.tplatform.whatsapp.WhatsAppShare;
import com.news.mobilephone.utils.Common;
import com.news.mobilephone.utils.CommonUtils;
import com.news.mobilephone.utils.LogUtil;
import com.news.mobilephone.utils.ToastUtils;
import com.news.mobilephone.view.CustomShareDialog;
import com.news.mobilephone.view.EmptyLayout;
import com.news.mobilephone.view.MyRefreshLayout;
import com.news.mobilephone.view.OpenTheTreasureBoxDialog;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;


public class NewsFragment extends BaseFragment<NewsListPresenter, NewsListModel> implements NewsContract.View {

    private MyRefreshLayout refresh_view;
    private RecyclerView rv_news;
    private EmptyLayout mEmptyLayout;
    private NewsInforAdapter inforAdapter;
    private Drawable like, unlike;
    private CustomShareDialog mCustomShareDialog;
    private NewsInfoResponse.DataBeanX.DataBean dataBean;
    private TwitterLogin mTwitterLogin;
    private FaceBookShare mFaceBookShare;
    private WhatsAppShare whatsAppShare;
    private OpenTheTreasureBoxDialog mOpenTheTreasureBoxDialog;
    private int mPositon;


    @Override
    protected int getLayoutResource() {
        EventBus.getDefault().register(this);
        return R.layout.fragment_news;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override
    protected void initView(View v) {
        refresh_view = v.findViewById(R.id.refresh_view);
        rv_news = v.findViewById(R.id.rv_news);
        mEmptyLayout = v.findViewById(R.id.mEmptyLayout);
        unlike = getResources().getDrawable(R.mipmap.zan);
        like = getResources().getDrawable(R.mipmap.zaned);

        whatsAppShare = new WhatsAppShare(mContext);

        unlike.setBounds(0, 0, unlike.getMinimumWidth(), unlike.getMinimumHeight());
        like.setBounds(0, 0, like.getMinimumWidth(), like.getMinimumHeight());

        inforAdapter = new NewsInforAdapter(new ArrayList<NewsInfoResponse.DataBeanX.DataBean>(), getActivity());
        rv_news.setLayoutManager(new LinearLayoutManager(mContext));
        rv_news.setAdapter(inforAdapter);
    }

    @Override
    public void initObject() {
        setMVP();
        refresh_view.setVisibility(View.GONE);
        mEmptyLayout.setErrorType(EmptyLayout.LOADING, -1);
        mPresenter.getNewsList(true);
        mPresenter.getSignInDay(Constant.SIGNINADAY);
        initShare();
    }

    public void initShare() {
        //初始化分享
        if (mCustomShareDialog == null) {
            mCustomShareDialog = new CustomShareDialog(getActivity());
            mCustomShareDialog.setOnShareListener(new CustomShareDialog.OnShareListener() {
                @Override
                public void onShare(int type) {
                    if (type != Common.SHARE_TYPE_REPORT) {
                        //获取分享数据
                        mPresenter.getSharedConttent(getShareNewRequest(dataBean.getId(), dataBean.getKeywords()), type);
                    }
                }
            });
        }
    }

    @Override
    protected void loadData() {

    }

    private boolean islike = false;

    @Override
    public void initEvents() {
        initRefreshListen();
        mEmptyLayout.setOnEmptyRefreshLisenter(new EmptyLayout.onEmptyRefreshLisenter() {
            @Override
            public void onEmptyRefresh() {
                mPresenter.getNewsList(true);
            }
        });
        //item点击事件
        inforAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                NewsInfoResponse.DataBeanX.DataBean dataBean = (NewsInfoResponse.DataBeanX.DataBean) adapter.getData().get(position);
                if (!CommonUtils.isFastClick()) {
                    NewsDetailsRvActivity.toThis(getContext(), dataBean);
                }

            }
        });
        inforAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                mPositon = position;
                NewsInfoResponse.DataBeanX.DataBean response = (NewsInfoResponse.DataBeanX.DataBean) adapter.getItem(position);
//                islike = !response.isIs_liked();
                switch (adapter.getItemViewType(position)) {
                    case NewsInfoResponse.NEWS_INFO_THREE_IMAGE_TYPE0:
                        switch (view.getId()) {
                            case R.id.tv_like:
                                response.setIs_liked(!response.isIs_liked());
                                ((TextView) (view.findViewById(R.id.tv_like))).setText(response.isIs_liked() ? (Integer.parseInt(response.getLike_count()) + 1) + "" : (Integer.parseInt(response.getLike_count())) + "");
                                ((TextView) (view.findViewById(R.id.tv_like))).setCompoundDrawables(response.isIs_liked() ? like : unlike, null, null, null);
                                ((TextView) (view.findViewById(R.id.tv_like))).setTextColor(response.isIs_liked() ? getResources().getColor(R.color.cff0000) : getResources().getColor(R.color.c999999));
                                mPresenter.getParise(getPariseRequest(response.getId(), response.getDu_type()));
                                break;
                            case R.id.tv_share:
                                dataBean = response;
                                mCustomShareDialog.show();
                                break;
                        }
                        break;
                    case NewsInfoResponse.NEWS_INFO_ONE_BIG_IMAGE_TYPE1:
                        switch (view.getId()) {
                            case R.id.tv_like:
                                response.setIs_liked(!response.isIs_liked());
                                ((TextView) (view.findViewById(R.id.tv_like))).setText(response.isIs_liked() ? (Integer.parseInt(response.getLike_count()) + 1) + "" : (Integer.parseInt(response.getLike_count())) + "");
                                ((TextView) (view.findViewById(R.id.tv_like))).setCompoundDrawables(response.isIs_liked() ? like : unlike, null, null, null);
                                ((TextView) (view.findViewById(R.id.tv_like))).setTextColor(response.isIs_liked() ? getResources().getColor(R.color.cff0000) : getResources().getColor(R.color.c999999));
                                mPresenter.getParise(getPariseRequest(response.getId(), response.getDu_type()));
                                break;
                            case R.id.tv_share:
                                dataBean = response;
                                mCustomShareDialog.show();
                                break;
                        }
                        break;
                    case NewsInfoResponse.NEWS_INFO_ONE_NORMAL_TYPE2:
                        switch (view.getId()) {
                            case R.id.tv_like:
                                response.setIs_liked(!response.isIs_liked());
                                ((TextView) (view.findViewById(R.id.tv_like))).setText(response.isIs_liked() ? (Integer.parseInt(response.getLike_count()) + 1) + "" : (Integer.parseInt(response.getLike_count())) + "");
                                ((TextView) (view.findViewById(R.id.tv_like))).setCompoundDrawables(response.isIs_liked() ? like : unlike, null, null, null);
                                ((TextView) (view.findViewById(R.id.tv_like))).setTextColor(response.isIs_liked() ? getResources().getColor(R.color.cff0000) : getResources().getColor(R.color.c999999));
                                mPresenter.getParise(getPariseRequest(response.getId(), response.getDu_type()));
                                break;
                            case R.id.tv_share:
                                dataBean = response;
                                mCustomShareDialog.show();
                                break;
                        }
                        break;
                }
            }
        });

    }

    private void initRefreshListen() {
        refresh_view.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                PAGE = 1;
                isRefresh = true;
                mPresenter.getNewsList(isRefresh);
            }
        });
        refresh_view.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                PAGE += 1;
                isRefresh = false;
                mPresenter.getNewsList(isRefresh);
            }
        });
    }

    @Override
    public void OnClickEvents(View v) {

    }


    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showErrorTip(int code, String msg) {
        ToastUtils.showShort(mContext, msg);
    }

    @Override
    public NewsListRequest getnewsListRequest() {
        NewsListRequest request = new NewsListRequest();
        request.setPage(PAGE + "");
        request.setR_type(2 + "");
        return request;
    }

    @Override
    public PariseRequest getPariseRequest(String newsId, String dutype) {
        PariseRequest request = new PariseRequest();
        request.setNews_id(newsId);
        request.setDu_type(dutype);
        return request;
    }

    @Override
    public ShareNewsRequest getShareNewRequest(String newsid, String key_code) {
        ShareNewsRequest request = new ShareNewsRequest();
        request.setKey_code("old");//默认为old
        request.setNews_id(newsid);
        return request;
    }

    @Override
    public SharedVistRequest getSharedRequest(String channel) {
        SharedVistRequest request = new SharedVistRequest();
        request.code = "200";
        request.du_type = dataBean.getDu_type();
        request.news_id = dataBean.getId();
        request.setShare_channel(channel);


        return request;
    }

    @Override
    public void getNewsListSuccess(NewsInfoResponse infoResponse, boolean isRefresh) {
        mEmptyLayout.setErrorType(EmptyLayout.HIDE_LAYOUT, -1);
        List<NewsInfoResponse.DataBeanX.DataBean> dataBeans = infoResponse.getData().getData();
        //1.删除广告位
        for (int i = 0; i < dataBeans.size(); i++) {
            if (dataBeans.get(i).getIs_ad().equals("1")) {
                dataBeans.remove(i);
            }
        }
        for (int i = 0; i < dataBeans.size(); i++) {
            if (dataBeans.get(i).getCover_show_type() == 1) {//大图
                dataBeans.get(i).setCover_show_type(NewsInfoResponse.NEWS_INFO_ONE_BIG_IMAGE_TYPE1);
            } else if (dataBeans.get(i).getCover_show_type() == 2) {//右边
                dataBeans.get(i).setCover_show_type(NewsInfoResponse.NEWS_INFO_ONE_NORMAL_TYPE2);
            } else if (dataBeans.get(i).getCover_show_type() == 3) {//三张
                dataBeans.get(i).setCover_show_type(NewsInfoResponse.NEWS_INFO_THREE_IMAGE_TYPE0);
            } else {
                dataBeans.get(i).setCover_show_type(NewsInfoResponse.NEWS_INFO_THREE_IMAGE_TYPE0);
            }
        }

        if (isRefresh) {
            refresh_view.finishRefresh();
            if (infoResponse.getData().getData().size() == 0) {
                refresh_view.setVisibility(View.GONE);
                mEmptyLayout.setErrorType(EmptyLayout.NO_DATA, EmptyLayout.NET_ODATA);
            } else {
                refresh_view.setVisibility(View.VISIBLE);
                inforAdapter.setNewData(dataBeans);
            }

        } else {
            refresh_view.finishLoadmore();
            inforAdapter.addData(dataBeans);
        }

    }

    @Override
    public void pariseSuccess() {
        ToastUtils.showShort(mContext, getResources().getString(R.string.success));
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
                    inforAdapter.getData().get(mPositon).setShare_count((Integer.parseInt(inforAdapter.getData().get(mPositon).getShare_count()) + 1) + "");
                    mPresenter.shareVisit(Common.SHARE_TYPE_TWITTER + "");

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
            mTwitterLogin.twitterShare(getActivity(), jsShareType, Common.TWITTER_SHARE_IAMGE);
        } else if (type == Common.SHARE_TYPE_FACEBOOK) {
            if (mFaceBookShare == null)
                mFaceBookShare = new FaceBookShare(getActivity(), new FacebookCallback() {
                    @Override
                    public void onSuccess(Object o) {
                        LogUtil.showLog("face 分享成功");
                        inforAdapter.getData().get(mPositon).setShare_count((Integer.parseInt(inforAdapter.getData().get(mPositon).getShare_count()) + 1) + "");
                        mPresenter.shareVisit(Common.SHARE_TYPE_FACEBOOK + "");

                        //ToastUtils.showShort(mContext, getString(R.string.sharedSuccess));
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
            LinkedInPlatform mLinkedInPlatform = new LinkedInPlatform(getActivity());
            mLinkedInPlatform.linkedInShareLisenter(new LinkedInPlatform.linkedInShareLisenter() {
                @Override
                public void getShareOk(String response) {
                    //ToastUtils.showShort(mContext, getString(R.string.sharedSuccess));
                    inforAdapter.getData().get(mPositon).setShare_count((Integer.parseInt(inforAdapter.getData().get(mPositon).getShare_count()) + 1) + "");
                    mPresenter.shareVisit(Common.SHARE_TYPE_LINKEDIN + "");


                }

                @Override
                public void getShareFail(String response) {
                    ToastUtils.showShort(mContext, getString(R.string.sharedFialed));
                }
            });
            mLinkedInPlatform.linkedInShare(jsShareType);
        } else if (type == Common.SHARE_TYPE_WHATS) {
            whatsAppShare.shareLink(jsShareType.getUrl());
            inforAdapter.getData().get(mPositon).setShare_count((Integer.parseInt(inforAdapter.getData().get(mPositon).getShare_count()) + 1) + "");
            mPresenter.shareVisit(Common.SHARE_TYPE_WHATS + "");

        }
    }

    @Override
    public void sharednewsSuccess() {
        inforAdapter.notifyItemChanged(mPositon, 1);
//        ToastUtils.showShort(mContext, getString(R.string.success));

    }

    @Override
    public void showGoldCome(int count, int type, String masgess) {
        if (mOpenTheTreasureBoxDialog == null) {
            mOpenTheTreasureBoxDialog = new OpenTheTreasureBoxDialog(getActivity());
        }
        if (!mOpenTheTreasureBoxDialog.isShowing()) {
            mOpenTheTreasureBoxDialog.setCanceledOnTouchOutside(false);//点击空白处不消失
            mOpenTheTreasureBoxDialog.showDialog(count);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (mFaceBookShare != null) {
            mFaceBookShare.getCallbackManager().onActivityResult(requestCode, resultCode, data);
        }
    }

    @Subscribe
    public void onRefreshNewListEvent(MessageEvent event) {
        if (event.getMessage().equals(Common.REFRESH_NEWS_LIST)) {
            mPresenter.getNewsList(true);
        }
    }

}




















