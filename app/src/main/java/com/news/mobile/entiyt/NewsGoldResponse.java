package com.news.mobile.entiyt;

/**
 * 作者：created by hcj
 * 邮箱：2654313873@qq.com
 * 日期：2018/11/5 17
 */
public class NewsGoldResponse {


    /**
     * code : 200
     * msg : success
     * data : {"gold_flag":10,"count":98}
     */

    private String code;
    private String msg;
    private DataBean data;

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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * gold_flag : 10
         * count : 98
         */

        private int gold_flag;
        private int count;

        public int getGold_flag() {
            return gold_flag;
        }

        public void setGold_flag(int gold_flag) {
            this.gold_flag = gold_flag;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }
    }
}
