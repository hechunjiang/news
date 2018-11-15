package com.news.mobilephone.entiyt;

import android.os.Parcel;
import android.os.Parcelable;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.util.List;

/**
 * Created by sfy. on 2018/11/3 0003.
 */

public class NewsInfoResponse {

    public static final int NEWS_INFO_THREE_IMAGE_TYPE0 = 0;
    public static final int NEWS_INFO_ONE_BIG_IMAGE_TYPE1 = 1;
    public static final int NEWS_INFO_ONE_NORMAL_TYPE2 = 2;

    private String code;
    private String msg;
    private DataBeanX data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBeanX getData() {
        return data;
    }

    public void setData(DataBeanX data) {
        this.data = data;
    }

    public static class DataBeanX {


        private boolean is_has_more;
        private List<DataBean> data;

        public boolean isIs_has_more() {
            return is_has_more;
        }

        public void setIs_has_more(boolean is_has_more) {
            this.is_has_more = is_has_more;
        }

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public static class DataBean implements MultiItemEntity, Parcelable {


            private String id;
            private String title;
            private String href;
            private String source;
            private String keywords;
            private String desc;
            private String user_id;
            private int cover_show_type;
            private String author_avatar;
            private String author_name;
            private String uni;
            private String language;
            private String du_type;
            private String create_time;
            private String update_time;
            private String channel;
            private String type_id;
            private String visit_count;
            private String like_count;
            private String comment_count;
            private String can_comment;
            private String unlike_enable;
            private String unlike_count;
            private String share_count;
            private String listorder;
            private String status;
            private String is_gold;
            private String is_redpack;
            private String is_ad;
            private String open_browser;
            private AdOtherMsgBean ad_otherMsg;
            private String ad_type;
            private String display_type;
            private String news_stop_second;
            private boolean is_liked;
            private List<String> cover_img;

            @Override
            public String toString() {
                return "DataBean{" +
                        "id='" + id + '\'' +
                        ", title='" + title + '\'' +
                        ", href='" + href + '\'' +
                        ", source='" + source + '\'' +
                        ", keywords='" + keywords + '\'' +
                        ", desc='" + desc + '\'' +
                        ", user_id='" + user_id + '\'' +
                        ", cover_show_type=" + cover_show_type +
                        ", author_avatar='" + author_avatar + '\'' +
                        ", author_name='" + author_name + '\'' +
                        ", uni='" + uni + '\'' +
                        ", language='" + language + '\'' +
                        ", du_type='" + du_type + '\'' +
                        ", create_time='" + create_time + '\'' +
                        ", update_time='" + update_time + '\'' +
                        ", channel='" + channel + '\'' +
                        ", type_id='" + type_id + '\'' +
                        ", visit_count='" + visit_count + '\'' +
                        ", like_count='" + like_count + '\'' +
                        ", comment_count='" + comment_count + '\'' +
                        ", can_comment='" + can_comment + '\'' +
                        ", unlike_enable='" + unlike_enable + '\'' +
                        ", unlike_count='" + unlike_count + '\'' +
                        ", share_count='" + share_count + '\'' +
                        ", listorder='" + listorder + '\'' +
                        ", status='" + status + '\'' +
                        ", is_gold='" + is_gold + '\'' +
                        ", is_redpack='" + is_redpack + '\'' +
                        ", is_ad='" + is_ad + '\'' +
                        ", open_browser='" + open_browser + '\'' +
                        ", ad_otherMsg=" + ad_otherMsg +
                        ", ad_type='" + ad_type + '\'' +
                        ", display_type='" + display_type + '\'' +
                        ", news_stop_second='" + news_stop_second + '\'' +
                        ", is_liked=" + is_liked +
                        ", cover_img=" + cover_img +
                        '}';
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getHref() {
                return href;
            }

            public void setHref(String href) {
                this.href = href;
            }

            public String getSource() {
                return source;
            }

            public void setSource(String source) {
                this.source = source;
            }

            public String getKeywords() {
                return keywords;
            }

            public void setKeywords(String keywords) {
                this.keywords = keywords;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getUser_id() {
                return user_id;
            }

            public void setUser_id(String user_id) {
                this.user_id = user_id;
            }

            public int getCover_show_type() {
                return cover_show_type;
            }

            public void setCover_show_type(int cover_show_type) {
                this.cover_show_type = cover_show_type;
            }

            public String getAuthor_avatar() {
                return author_avatar;
            }

            public void setAuthor_avatar(String author_avatar) {
                this.author_avatar = author_avatar;
            }

            public String getAuthor_name() {
                return author_name;
            }

            public void setAuthor_name(String author_name) {
                this.author_name = author_name;
            }

            public String getUni() {
                return uni;
            }

            public void setUni(String uni) {
                this.uni = uni;
            }

            public String getLanguage() {
                return language;
            }

            public void setLanguage(String language) {
                this.language = language;
            }

            public String getDu_type() {
                return du_type;
            }

            public void setDu_type(String du_type) {
                this.du_type = du_type;
            }

            public String getCreate_time() {
                return create_time;
            }

            public void setCreate_time(String create_time) {
                this.create_time = create_time;
            }

            public String getUpdate_time() {
                return update_time;
            }

            public void setUpdate_time(String update_time) {
                this.update_time = update_time;
            }

            public String getChannel() {
                return channel;
            }

            public void setChannel(String channel) {
                this.channel = channel;
            }

            public String getType_id() {
                return type_id;
            }

            public void setType_id(String type_id) {
                this.type_id = type_id;
            }

            public String getVisit_count() {
                return visit_count;
            }

            public void setVisit_count(String visit_count) {
                this.visit_count = visit_count;
            }

            public String getLike_count() {
                return like_count;
            }

            public void setLike_count(String like_count) {
                this.like_count = like_count;
            }

            public String getComment_count() {
                return comment_count;
            }

            public void setComment_count(String comment_count) {
                this.comment_count = comment_count;
            }

            public String getCan_comment() {
                return can_comment;
            }

            public void setCan_comment(String can_comment) {
                this.can_comment = can_comment;
            }

            public String getUnlike_enable() {
                return unlike_enable;
            }

            public void setUnlike_enable(String unlike_enable) {
                this.unlike_enable = unlike_enable;
            }

            public String getUnlike_count() {
                return unlike_count;
            }

            public void setUnlike_count(String unlike_count) {
                this.unlike_count = unlike_count;
            }

            public String getShare_count() {
                return share_count;
            }

            public void setShare_count(String share_count) {
                this.share_count = share_count;
            }

            public String getListorder() {
                return listorder;
            }

            public void setListorder(String listorder) {
                this.listorder = listorder;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getIs_gold() {
                return is_gold;
            }

            public void setIs_gold(String is_gold) {
                this.is_gold = is_gold;
            }

            public String getIs_redpack() {
                return is_redpack;
            }

            public void setIs_redpack(String is_redpack) {
                this.is_redpack = is_redpack;
            }

            public String getIs_ad() {
                return is_ad;
            }

            public void setIs_ad(String is_ad) {
                this.is_ad = is_ad;
            }

            public String getOpen_browser() {
                return open_browser;
            }

            public void setOpen_browser(String open_browser) {
                this.open_browser = open_browser;
            }

            public AdOtherMsgBean getAd_otherMsg() {
                return ad_otherMsg;
            }

            public void setAd_otherMsg(AdOtherMsgBean ad_otherMsg) {
                this.ad_otherMsg = ad_otherMsg;
            }

            public String getAd_type() {
                return ad_type;
            }

            public void setAd_type(String ad_type) {
                this.ad_type = ad_type;
            }

            public String getDisplay_type() {
                return display_type;
            }

            public void setDisplay_type(String display_type) {
                this.display_type = display_type;
            }

            public String getNews_stop_second() {
                return news_stop_second;
            }

            public void setNews_stop_second(String news_stop_second) {
                this.news_stop_second = news_stop_second;
            }

            public boolean isIs_liked() {
                return is_liked;
            }

            public void setIs_liked(boolean is_liked) {
                this.is_liked = is_liked;
            }

            public List<String> getCover_img() {
                return cover_img;
            }

            public void setCover_img(List<String> cover_img) {
                this.cover_img = cover_img;
            }

            @Override
            public int getItemType() {
                return cover_show_type;
            }

            public static class AdOtherMsgBean {
                private List<?> imp;
                private List<?> clk;

                public List<?> getImp() {
                    return imp;
                }

                public void setImp(List<?> imp) {
                    this.imp = imp;
                }

                public List<?> getClk() {
                    return clk;
                }

                public void setClk(List<?> clk) {
                    this.clk = clk;
                }
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(this.id);
                dest.writeString(this.title);
                dest.writeString(this.href);
                dest.writeString(this.source);
                dest.writeString(this.keywords);
                dest.writeString(this.desc);
                dest.writeString(this.user_id);
                dest.writeInt(this.cover_show_type);
                dest.writeString(this.author_avatar);
                dest.writeString(this.author_name);
                dest.writeString(this.uni);
                dest.writeString(this.language);
                dest.writeString(this.du_type);
                dest.writeString(this.create_time);
                dest.writeString(this.update_time);
                dest.writeString(this.channel);
                dest.writeString(this.type_id);
                dest.writeString(this.visit_count);
                dest.writeString(this.like_count);
                dest.writeString(this.comment_count);
                dest.writeString(this.can_comment);
                dest.writeString(this.unlike_enable);
                dest.writeString(this.unlike_count);
                dest.writeString(this.share_count);
                dest.writeString(this.listorder);
                dest.writeString(this.status);
                dest.writeString(this.is_gold);
                dest.writeString(this.is_redpack);
                dest.writeString(this.is_ad);
                dest.writeString(this.open_browser);
                dest.writeString(this.ad_type);
                dest.writeString(this.display_type);
                dest.writeString(this.news_stop_second);
                dest.writeByte(this.is_liked ? (byte) 1 : (byte) 0);
                dest.writeStringList(this.cover_img);
            }

            public DataBean() {
            }

            protected DataBean(Parcel in) {
                this.id = in.readString();
                this.title = in.readString();
                this.href = in.readString();
                this.source = in.readString();
                this.keywords = in.readString();
                this.desc = in.readString();
                this.user_id = in.readString();
                this.cover_show_type = in.readInt();
                this.author_avatar = in.readString();
                this.author_name = in.readString();
                this.uni = in.readString();
                this.language = in.readString();
                this.du_type = in.readString();
                this.create_time = in.readString();
                this.update_time = in.readString();
                this.channel = in.readString();
                this.type_id = in.readString();
                this.visit_count = in.readString();
                this.like_count = in.readString();
                this.comment_count = in.readString();
                this.can_comment = in.readString();
                this.unlike_enable = in.readString();
                this.unlike_count = in.readString();
                this.share_count = in.readString();
                this.listorder = in.readString();
                this.status = in.readString();
                this.is_gold = in.readString();
                this.is_redpack = in.readString();
                this.is_ad = in.readString();
                this.open_browser = in.readString();
                this.ad_type = in.readString();
                this.display_type = in.readString();
                this.news_stop_second = in.readString();
                this.is_liked = in.readByte() != 0;
                this.cover_img = in.createStringArrayList();
            }

            public static final Creator<DataBean> CREATOR = new Creator<DataBean>() {
                @Override
                public DataBean createFromParcel(Parcel source) {
                    return new DataBean(source);
                }

                @Override
                public DataBean[] newArray(int size) {
                    return new DataBean[size];
                }
            };
        }
    }
}
