package com.news.mobile.main.mine.activity;

import android.graphics.Color;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;

import com.news.mobile.R;
import com.news.mobile.base.BaseActivity;
import com.news.mobile.entiyt.MessageResponse;
import com.news.mobile.main.mine.adapter.MessageAdapter;
import com.news.mobile.main.mine.contract.MessageContract;
import com.news.mobile.main.mine.model.MessageModel;
import com.news.mobile.main.mine.presenter.MessagePresenter;
import com.news.mobile.utils.Common;
import com.news.mobile.utils.StatusBarUtils;
import com.news.mobile.utils.UserSpCache;
import com.news.mobile.view.EmptyLayout;
import com.news.mobile.view.MyRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import org.greenrobot.eventbus.EventBus;

public class MessageActivity extends BaseActivity<MessagePresenter, MessageModel> implements MessageContract.View {

    private MyRefreshLayout refreshLayout;
    private RecyclerView msg_rv;
    private MessageAdapter messageAdapter;
    private ImageButton btn_close;
    private EmptyLayout emptyLayout;


    @Override
    public int getLayoutId() {
        return R.layout.activity_message;
    }

    @Override
    public void initView() {
        refreshLayout = findViewById(R.id.refresh_view);
        msg_rv = findViewById(R.id.messgae_rv);
        btn_close = findViewById(R.id.btn_close);
        emptyLayout = findViewById(R.id.mEmptyLayout);
    }

    @Override
    public void initEvents() {
        btn_close.setOnClickListener(this);
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                mPresenter.getMessageList();
                emptyLayout.setErrorType(EmptyLayout.LOADING, -1);
            }
        });
    }

    @Override
    public void onClickEvent(View v) {
        if (v == btn_close) {
            finish();
        }
    }

    @Override
    public void initObject() {
        StatusBarUtils.setColor(this, Color.parseColor("#FFFFFF"));
        setMVP();
        refreshLayout.autoRefresh();
        messageAdapter = new MessageAdapter(mContext);
        msg_rv.setLayoutManager(new LinearLayoutManager(mContext));
        msg_rv.setAdapter(messageAdapter);
    }

    @Override
    public void setMessageData(MessageResponse response) {
        emptyLayout.setErrorType(EmptyLayout.HIDE_LAYOUT, -1);
        if (response.getData().getList().size() == 0 && isRefresh) {
            emptyLayout.setErrorType(EmptyLayout.NO_DATA, 10002);
        } else {
            emptyLayout.setVisibility(View.GONE);
        }
        UserSpCache.getInstance(mContext).putInt(UserSpCache.TIPS_LOCAL_FLAG, response.getData().getMaxId());
        EventBus.getDefault().post(Common.REFRESH_TIPS);
        refreshLayout.finishRefresh();
        messageAdapter.refreshItem(response.getData().getList(), isRefresh);
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
}
