package com.news.mobile.main.news.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.news.mobile.R;

import java.util.List;

/**
 * @Author weiwei
 * create by 2018/11/8
 * Des: <功能简述>
 * 代码不优雅，写锤子代码
 */
public class NewsCommitAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    public NewsCommitAdapter(@Nullable List<String> data) {
        super(R.layout.item_news_commit, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        int adapterPosition = helper.getAdapterPosition();

        helper.setText(R.id.tv_content, item);
    }
}
