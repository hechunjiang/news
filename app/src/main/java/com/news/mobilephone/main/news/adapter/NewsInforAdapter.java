package com.news.mobilephone.main.news.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.news.mobilephone.MyApplication;
import com.news.mobilephone.R;
import com.news.mobilephone.entiyt.NewsInfoResponse;
import com.news.mobilephone.utils.CommonUtils;
import com.news.mobilephone.utils.LogUtil;

import java.util.List;


public class NewsInforAdapter extends BaseMultiItemQuickAdapter<NewsInfoResponse.DataBeanX.DataBean, BaseViewHolder> {

    private Drawable like, unlike;
    private Context mContext;

    public NewsInforAdapter(List<NewsInfoResponse.DataBeanX.DataBean> data, Context context) {
        super(data);

        mContext = context;
        addItemType(NewsInfoResponse.NEWS_INFO_THREE_IMAGE_TYPE0, R.layout.item_news_type0);//三张
        addItemType(NewsInfoResponse.NEWS_INFO_ONE_BIG_IMAGE_TYPE1, R.layout.item_news_type1);//大图
        addItemType(NewsInfoResponse.NEWS_INFO_ONE_NORMAL_TYPE2, R.layout.item_news_type2);//小图

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
                        .setText(R.id.tv_time, CommonUtils.formatDate(item.getCreate_time(), mContext))
                        .setText(R.id.tv_like, CommonUtils.getLikeCount(Long.parseLong(item.getLike_count())))
                        .setText(R.id.tv_share, CommonUtils.getLikeCount(Long.parseLong(item.getShare_count())))
                        .addOnClickListener(R.id.tv_like)
                        .addOnClickListener(R.id.tv_share);
                TextView textView = helper.getView(R.id.tv_like);

                if (item.isIs_liked()) {
                    like.setBounds(0, 0, like.getIntrinsicWidth(), like.getIntrinsicHeight());
                    textView.setCompoundDrawables(like, null, null, null);
                } else {
                    unlike.setBounds(0, 0, unlike.getIntrinsicWidth(), unlike.getIntrinsicHeight());
                    textView.setCompoundDrawables(unlike, null, null, null);
                }
                if (item.getCover_img().size() > 2) {
                    ((SimpleDraweeView) helper.getView(R.id.iv_left)).setImageURI(item.getCover_img().get(0));
                    ((SimpleDraweeView) helper.getView(R.id.iv_middle)).setImageURI(item.getCover_img().get(1));
                    ((SimpleDraweeView) helper.getView(R.id.iv_right)).setImageURI(item.getCover_img().get(2));
                } else if (item.getCover_img().size() > 1) {
                    ((SimpleDraweeView) helper.getView(R.id.iv_left)).setImageURI(item.getCover_img().get(0));
                    ((SimpleDraweeView) helper.getView(R.id.iv_middle)).setImageURI(item.getCover_img().get(1));
                } else {
                    ((SimpleDraweeView) helper.getView(R.id.iv_left)).setImageURI(item.getCover_img().get(0));
                }

                break;
            case NewsInfoResponse.NEWS_INFO_ONE_BIG_IMAGE_TYPE1:

                helper.setText(R.id.tv_title, item.getTitle())
                        .setText(R.id.tv_time, CommonUtils.formatDate(item.getCreate_time(), mContext))
                        .setText(R.id.tv_like, CommonUtils.getLikeCount(Long.parseLong(item.getLike_count())))
                        .setText(R.id.tv_share, CommonUtils.getLikeCount(Long.parseLong(item.getShare_count())))
                        .addOnClickListener(R.id.tv_like)
                        .addOnClickListener(R.id.tv_share);
                TextView tv_like1 = helper.getView(R.id.tv_like);
                if (item.isIs_liked()) {
                    like.setBounds(0, 0, like.getIntrinsicWidth(), like.getIntrinsicHeight());
                    tv_like1.setCompoundDrawables(like, null, null, null);
                } else {
                    unlike.setBounds(0, 0, unlike.getIntrinsicWidth(), unlike.getIntrinsicHeight());
                    tv_like1.setCompoundDrawables(unlike, null, null, null);
                }
                if (item.getCover_img().size() > 0) {
                    ((SimpleDraweeView) helper.getView(R.id.iv_image)).setImageURI(Uri.parse(item.getCover_img().get(0)));
                } else {
                    ((SimpleDraweeView) helper.getView(R.id.iv_right)).setImageResource(R.drawable.def_image);
                }

                break;


            //目前只用了这一个type
            case NewsInfoResponse.NEWS_INFO_ONE_NORMAL_TYPE2:
                helper.setText(R.id.tv_title, item.getTitle())
                        .setText(R.id.tv_time, CommonUtils.formatDate(item.getCreate_time(), mContext))
                        .setText(R.id.tv_like, CommonUtils.getLikeCount(Long.parseLong(item.getLike_count())))
                        .setText(R.id.tv_share, CommonUtils.getLikeCount(Long.parseLong(item.getShare_count())))
                        .addOnClickListener(R.id.tv_like)
                        .addOnClickListener(R.id.tv_share);

                TextView tv_like = helper.getView(R.id.tv_like);
                if (item.isIs_liked()) {
                    like.setBounds(0, 0, like.getIntrinsicWidth(), like.getIntrinsicHeight());
                    tv_like.setCompoundDrawables(like, null, null, null);
                } else {
                    unlike.setBounds(0, 0, unlike.getIntrinsicWidth(), unlike.getIntrinsicHeight());
                    tv_like.setCompoundDrawables(unlike, null, null, null);
                }
                if (item.getCover_img().size() > 0) {
                    ((SimpleDraweeView) helper.getView(R.id.iv_right)).setImageURI(item.getCover_img().get(0));
                } else {
                    ((SimpleDraweeView) helper.getView(R.id.iv_right)).setImageResource(R.drawable.def_image);

                }
                break;
        }
    }

}
