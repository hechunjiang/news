package com.news.mobilephone.view;

import android.content.Context;
import android.util.AttributeSet;

import com.news.mobilephone.R;
import com.scwang.smartrefresh.header.MaterialHeader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.footer.BallPulseFooter;

/**
 * Created by sfy. on 2018/11/3 0003.
 */

public class MyRefreshLayout extends SmartRefreshLayout {

    private MaterialHeader mMaterialHeader;
    private BallPulseFooter mBallPulseFooter;

    public MyRefreshLayout(Context context) {
        super(context);
        init(context);
    }

    public MyRefreshLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public MyRefreshLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        setEnableRefresh(true);
        setEnableLoadmore(true);
        mMaterialHeader = new MaterialHeader(context);
        mMaterialHeader.setColorSchemeColors(context.getResources().getColor(R.color.colorAccent));
        setRefreshHeader(mMaterialHeader);
        mBallPulseFooter = new BallPulseFooter(context);
        mBallPulseFooter.setIndicatorColor(context.getResources().getColor(R.color.colorAccent));
        mBallPulseFooter.setAnimatingColor(context.getResources().getColor(R.color.colorAccent));
        mBallPulseFooter.setNormalColor(context.getResources().getColor(R.color.colorAccent));
        setRefreshFooter(mBallPulseFooter);
    }
}
