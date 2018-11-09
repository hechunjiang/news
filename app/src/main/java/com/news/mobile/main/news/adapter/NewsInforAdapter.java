package com.news.mobile.main.news.adapter;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.news.mobile.MyApplication;
import com.news.mobile.R;
import com.news.mobile.entiyt.NewsInfoResponse;
import com.news.mobile.utils.CommonUtils;
import com.news.mobile.utils.LogUtil;

import java.util.List;

/**
 * Created by sfy. on 2018/11/3 0003.
 */

public class NewsInforAdapter extends BaseMultiItemQuickAdapter<NewsInfoResponse.DataBeanX.DataBean, BaseViewHolder> {
    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */

    private Drawable like, unlike;

    public NewsInforAdapter(List<NewsInfoResponse.DataBeanX.DataBean> data) {
        super(data);
        addItemType(NewsInfoResponse.NEWS_INFO_THREE_IMAGE_TYPE0, R.layout.item_news_type0);
        addItemType(NewsInfoResponse.NEWS_INFO_ONE_BIG_IMAGE_TYPE1, R.layout.item_news_type1);
        addItemType(NewsInfoResponse.NEWS_INFO_ONE_NORMAL_TYPE2, R.layout.item_news_type2);

    }


    @Override
    protected void convert(BaseViewHolder helper, NewsInfoResponse.DataBeanX.DataBean item) {

        unlike = ContextCompat.getDrawable(MyApplication.getAppContext(), R.mipmap.zan);
        like = ContextCompat.getDrawable(MyApplication.getAppContext(), R.mipmap.zaned);
        unlike.setBounds(0, 0, unlike.getMinimumWidth(), unlike.getMinimumHeight());
        like.setBounds(0, 0, like.getMinimumWidth(), like.getMinimumHeight());
        switch (helper.getItemViewType()) {
            case NewsInfoResponse.NEWS_INFO_THREE_IMAGE_TYPE0:
                helper.setText(R.id.tv_title, item.getTitle())
                        .setText(R.id.tv_like, CommonUtils.getLikeCount(1234567))
                        .setText(R.id.tv_share, CommonUtils.getLikeCount(34567))
                        .addOnClickListener(R.id.tv_like)
                        .addOnClickListener(R.id.tv_share);
                ((TextView) helper.getView(R.id.tv_like)).setCompoundDrawables(item.isIs_liked() ? like : unlike, null, null, null);
                ((SimpleDraweeView) helper.getView(R.id.iv_left)).setImageURI(item.getCover_img().get(0));
                ((SimpleDraweeView) helper.getView(R.id.iv_middle)).setImageURI(item.getCover_img().get(1));
                ((SimpleDraweeView) helper.getView(R.id.iv_right)).setImageURI(item.getCover_img().get(2));

                break;
            case NewsInfoResponse.NEWS_INFO_ONE_BIG_IMAGE_TYPE1:
                ((SimpleDraweeView) helper.getView(R.id.iv_image)).setImageURI(Uri.parse(item.getCover_img().get(0)));
                helper.setText(R.id.tv_title, item.getTitle());
                break;


            //目前只用了这一个type
            case NewsInfoResponse.NEWS_INFO_ONE_NORMAL_TYPE2:
                helper.setText(R.id.tv_title, item.getTitle())
                        .setText(R.id.tv_time, CommonUtils.formatDate(item.getCreate_time()))
                        .setText(R.id.tv_like, CommonUtils.getLikeCount(Long.parseLong(item.getLike_count())))
                        .addOnClickListener(R.id.tv_like)
                        .addOnClickListener(R.id.tv_share)
                        .setText(R.id.tv_share, CommonUtils.getLikeCount(Long.parseLong(item.getShare_count())));
                ((TextView) helper.getView(R.id.tv_like)).setCompoundDrawables(item.isIs_liked() ? like : unlike, null, null, null);
                ((SimpleDraweeView) helper.getView(R.id.iv_right)).setImageURI(item.getCover_img().get(0));
                LogUtil.showLog("image", item.getCover_img() + "");
                break;
        }
    }

}
