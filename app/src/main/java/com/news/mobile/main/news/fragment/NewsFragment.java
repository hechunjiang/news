package com.news.mobile.main.news.fragment;

import android.graphics.drawable.Drawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.news.mobile.R;
import com.news.mobile.base.BaseFragment;
import com.news.mobile.entiyt.NewsInfoResponse;
import com.news.mobile.entiyt.request.NewsListRequest;
import com.news.mobile.entiyt.request.PariseRequest;
import com.news.mobile.entiyt.request.ShareNewsRequest;
import com.news.mobile.main.news.adapter.NewsInforAdapter;
import com.news.mobile.main.news.activity.NewsDetailsRvActivity;
import com.news.mobile.main.news.contract.NewsContract;
import com.news.mobile.main.news.model.NewsListModel;
import com.news.mobile.main.news.presenter.NewsListPresenter;
import com.news.mobile.utils.Common;
import com.news.mobile.utils.CommonUtils;
import com.news.mobile.utils.LogUtil;
import com.news.mobile.utils.ToastUtils;
import com.news.mobile.view.CustomShareDialog;
import com.news.mobile.view.EmptyLayout;
import com.news.mobile.view.MyRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

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


    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_news;
    }

    @Override
    protected void initView(View v) {
        refresh_view = v.findViewById(R.id.refresh_view);
        rv_news = v.findViewById(R.id.rv_news);
        mEmptyLayout = v.findViewById(R.id.mEmptyLayout);
        unlike = getResources().getDrawable(R.mipmap.zan);
        like = getResources().getDrawable(R.mipmap.zaned);

        unlike.setBounds(0, 0, unlike.getMinimumWidth(), unlike.getMinimumHeight());
        like.setBounds(0, 0, like.getMinimumWidth(), like.getMinimumHeight());

        inforAdapter = new NewsInforAdapter(new ArrayList<NewsInfoResponse.DataBeanX.DataBean>());
        rv_news.setLayoutManager(new LinearLayoutManager(mContext));
        rv_news.setAdapter(inforAdapter);
    }

    @Override
    public void initObject() {
        setMVP();
        mEmptyLayout.setErrorType(EmptyLayout.LOADING, -1);
        mPresenter.getNewsList(true);
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
                        mPresenter.getSharedConttent(getShareNewRequest(dataBean.getId(), dataBean.getKeywords()));
                    } else {
                        //举报  网络链接
//                        mReportPresenter.videoReport(Video_id);
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
        //item点击事件
        inforAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                NewsInfoResponse.DataBeanX.DataBean dataBean = (NewsInfoResponse.DataBeanX.DataBean) adapter.getData().get(position);
                if (!CommonUtils.isFastClick()) {
                    if (!"".equals(dataBean.getHref())) {
//                        NewsDetailsRvActivity.toThis(getContext(), dataBean);
                    }
                }

            }
        });
        inforAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                NewsInfoResponse.DataBeanX.DataBean response = (NewsInfoResponse.DataBeanX.DataBean) adapter.getItem(position);
//                islike = !response.isIs_liked();
                switch (adapter.getItemViewType(position)) {
                    case NewsInfoResponse.NEWS_INFO_THREE_IMAGE_TYPE0:
                        switch (view.getId()) {
                            case R.id.tv_like:
                                ((TextView) (view.findViewById(R.id.tv_like))).setCompoundDrawables(islike ? like : unlike, null, null, null);
                                ((TextView) (view.findViewById(R.id.tv_like))).setTextColor(islike ? getResources().getColor(R.color.cff0000) : getResources().getColor(R.color.c999999));

                                ToastUtils.showShort(mContext, "点赞");
                                break;
                        }
                        break;
                    case NewsInfoResponse.NEWS_INFO_ONE_BIG_IMAGE_TYPE1:
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
            dataBeans.get(i).setType(NewsInfoResponse.NEWS_INFO_ONE_NORMAL_TYPE2);
        }

        if (isRefresh) {
            refresh_view.finishRefresh();
            if (infoResponse.getData().getData().size() == 0) {
                mEmptyLayout.setErrorType(EmptyLayout.NO_DATA, EmptyLayout.NO_DATA);
            } else {
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


// 模拟数据

    public List<NewsInfoResponse.DataBeanX.DataBean> setInforAdapter() {
        List<NewsInfoResponse.DataBeanX.DataBean> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            NewsInfoResponse.DataBeanX.DataBean dataBean = new NewsInfoResponse.DataBeanX.DataBean();

            dataBean.setDesc("xxxxx" + i);
            dataBean.setTitle("title" + i);
            dataBean.setHref("https://www.baidu.com");
            dataBean.setSource("source" + i);
//            dataBean.setCover_img("http://i1.umei.cc/uploads/tu/201711/10077/dd671ebd2f.jpg");
            dataBean.setAuthor_name("author_avatar" + i);
            dataBean.setCreate_time("123456" + i);
//            dataBean.setVisit_count(32450 + "");
//            dataBean.setType(NewsInfoResponse.NEWS_INFO_THREE_IMAGE_TYPE0);
            list.add(dataBean);
        }

        for (int i = 0; i < list.size(); i++) {
            if (i == 2 || i == 6) {
//                list.get(i).setType(NewsInfoResponse.NEWS_INFO_ONE_BIG_IMAGE_TYPE1);
            }
            if (i == 4 || i == 8) {
//                list.get(i).setType(NewsInfoResponse.NEWS_INFO_ONE_NORMAL_TYPE2);
            }

        }

        return list;
    }
}




















