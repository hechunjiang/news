package com.news.mobile.entiyt;

/**
 * Created by sfy. on 2018/11/3 0003.
 */

public class NewsCommonResponse {


    /**
     * code : 200
     * msg : comment success
     * data : {"comment_count":11}
     */

    private int code;
    private String msg;
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * comment_count : 11
         */

        private int comment_count;

        public int getComment_count() {
            return comment_count;
        }

        public void setComment_count(int comment_count) {
            this.comment_count = comment_count;
        }
    }
}
