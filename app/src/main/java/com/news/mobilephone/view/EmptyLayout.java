package com.news.mobilephone.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.news.mobilephone.R;

/**
 * Created by sfy. on 2018/11/2 0002.
 */

public class EmptyLayout extends RelativeLayout implements View.OnClickListener {
    public static final int NETWORK_ERROR = 1; //网络错误
    public static final int NO_COMMENT = 7; //没有评论
    public static final int LOAD_ERROR = 9; //加载出错
    public static final int HIDE_LAYOUT = -1; //隐藏
    public static final int NO_DATA = 902; //无数据
    public static final int LOADING = 100; //加载中
    public static final int NET_WORK_ERROR = 10001;//网络错误
    public static final int NET_ODATA = 10002;//无数据
    public static final int NO_MESSAGE = 10003;//无消息

    private int mCurrentStatus;

    private Context context;
    private LinearLayout emptyLayout;
    private ImageView ivEmpty;
    private TextView tv_dis;
    private ImageView progressBar;

    public EmptyLayout(Context context) {
        super(context);
        this.context = context;
        init();
    }

    public EmptyLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init();
    }


    private void init() {
        View v = LayoutInflater.from(context).inflate(R.layout.empty_layout, null);
        ivEmpty = v.findViewById(R.id.iv_empty);
        tv_dis = v.findViewById(R.id.tv_dis);
        emptyLayout = v.findViewById(R.id.ll_empty);
        progressBar = v.findViewById(R.id.progress_bar);
        v.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        addView(v);
        emptyLayout.setOnClickListener(this);
        emptyLayout.setBackgroundColor(getResources().getColor(R.color.colorWhite));
    }

    public void setBackgroundColor(int colorRes) {
        emptyLayout.setBackgroundColor(colorRes);
    }

    /**
     * @param status 状态
     * @param type   错误类型
     */
    public void setErrorType(int status, int type) {
        setVisibility(View.VISIBLE);
        this.mCurrentStatus = status;
        switch (status) {
            case HIDE_LAYOUT:
                emptyLayout.setVisibility(View.GONE);
                setVisibility(GONE);
                break;
            case NO_DATA:
                setNoDataType(type);
                break;
            case NETWORK_ERROR:
                setNoDataType(type);
                break;
            case LOAD_ERROR:
                setNoDataType(type);
                break;
            case LOADING:
                Glide.with(context).load(R.mipmap.gif_loading).into(progressBar);
                progressBar.setVisibility(VISIBLE);
                emptyLayout.setVisibility(View.VISIBLE);
                ivEmpty.setVisibility(View.GONE);
                tv_dis.setVisibility(View.GONE);
                break;
        }
    }

    private void setNoDataType(int type) {
        progressBar.setVisibility(View.GONE);
        emptyLayout.setVisibility(View.VISIBLE);
        ivEmpty.setVisibility(View.VISIBLE);
        tv_dis.setVisibility(View.VISIBLE);
        switch (type) {
            case NO_COMMENT:
                ivEmpty.setImageResource(R.mipmap.no_comment_data);
                tv_dis.setText(R.string.no_comment);
                break;
            case NET_WORK_ERROR:
                ivEmpty.setImageResource(R.mipmap.networkerror);
                tv_dis.setText(R.string.s_noNetwork_text);
                break;
            case NET_ODATA:
                ivEmpty.setImageResource(R.mipmap.no_data);
                tv_dis.setText(R.string.no_follow_video_data_list);
                break;
            case NO_MESSAGE:
                ivEmpty.setImageResource(R.mipmap.nomessage);
                tv_dis.setText(R.string.nomessage);
                break;
        }

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.ll_empty) {
            if (mCurrentStatus == LOADING) {
                return;
            }
            if (mOnEmptyRefreshLisenter != null) {
                setErrorType(EmptyLayout.LOADING, -1);
                mOnEmptyRefreshLisenter.onEmptyRefresh();
            }
        }
    }

    public interface onEmptyRefreshLisenter {
        void onEmptyRefresh();
    }

    private onEmptyRefreshLisenter mOnEmptyRefreshLisenter;

    public void setOnEmptyRefreshLisenter(onEmptyRefreshLisenter mOnEmptyRefreshLisenter) {
        this.mOnEmptyRefreshLisenter = mOnEmptyRefreshLisenter;
    }
}
