package com.news.mobilephone.main.news.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.news.mobilephone.R;
import com.news.mobilephone.entiyt.NewsCommonListResponse;
import com.news.mobilephone.utils.GlideUtils;

import java.util.List;

/**
 * @Author weiwei
 * create by 2018/11/8
 * Des: <功能简述>
 * 代码不优雅，写锤子代码
 */
public class NewsCommitAdapter extends BaseQuickAdapter<NewsCommonListResponse.DataBean, BaseViewHolder> {

    public NewsCommitAdapter(@Nullable List<NewsCommonListResponse.DataBean> data) {
        super(R.layout.item_news_commit, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, NewsCommonListResponse.DataBean item) {
        helper.setText(R.id.tv_content, item.getContent())
                .setText(R.id.tv_name,item.getNickname())
                .setText(R.id.tv_time,item.getPub_datetime());

        ImageView iv_head = helper.getView(R.id.iv_head);

        GlideUtils.loadCircleImage(mContext,item.getAvatar(),iv_head);

    }

    @Override
    public long getItemId(int position) {
        return position;
    }
}
