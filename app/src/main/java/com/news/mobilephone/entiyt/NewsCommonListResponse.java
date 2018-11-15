package com.news.mobilephone.entiyt;

import java.util.List;

/**
 * Created by sfy. on 2018/11/3 0003.
 */

public class NewsCommonListResponse {


    /**
     * code : 200
     * msg : success
     * data : [{"id":2,"article_id":2,"user_id":1,"avatar":null,"nickname":null,"content":"hello34523","like_count":0,"pub_datetime":1541755014,"status":1,"is_up":false,"is_sure":true},{"id":1,"article_id":2,"user_id":1,"avatar":null,"nickname":null,"content":"hello34523","like_count":1,"pub_datetime":1541754925,"status":1,"is_up":true,"is_sure":true}]
     */

    private String code;
    private String msg;
    private List<DataBean> data;

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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 2
         * article_id : 2
         * user_id : 1
         * avatar : null
         * nickname : null
         * content : hello34523
         * like_count : 0
         * pub_datetime : 1541755014
         * status : 1
         * is_up : false
         * is_sure : true
         */

        private int id;
        private int article_id;
        private int user_id;
        private String avatar;
        private String nickname;
        private String content;
        private int like_count;
        private String pub_datetime;
        private int status;
        private boolean is_up;
        private boolean is_sure;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getArticle_id() {
            return article_id;
        }

        public void setArticle_id(int article_id) {
            this.article_id = article_id;
        }

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public int getLike_count() {
            return like_count;
        }

        public void setLike_count(int like_count) {
            this.like_count = like_count;
        }

        public String getPub_datetime() {
            return pub_datetime;
        }

        public void setPub_datetime(String pub_datetime) {
            this.pub_datetime = pub_datetime;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public boolean isIs_up() {
            return is_up;
        }

        public void setIs_up(boolean is_up) {
            this.is_up = is_up;
        }

        public boolean isIs_sure() {
            return is_sure;
        }

        public void setIs_sure(boolean is_sure) {
            this.is_sure = is_sure;
        }
    }
}
