package com.news.mobilephone.entiyt;

import java.io.Serializable;

/**
 * 作者：created by hcj
 * 邮箱：2654313873@qq.com
 * 日期：2018/11/6 14
 */
public class TaskOpenBoxResponse implements Serializable {

    /**
     * code : 200
     * msg : successed
     * data : {"gold_tribute":40,"update_time":"2018-09-25 00:08:25","is":1,"time_difference":14400}
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

    public static class DataBean implements Serializable {
        /**
         * gold_tribute : 40
         * update_time : 2018-09-25 00:08:25
         * is : 1
         * time_difference : 14400
         */

        private int gold_tribute;
        private String update_time;
        private int is;
        private int time_difference;

        public int getGold_tribute() {
            return gold_tribute;
        }

        public void setGold_tribute(int gold_tribute) {
            this.gold_tribute = gold_tribute;
        }

        public String getUpdate_time() {
            return update_time;
        }

        public void setUpdate_time(String update_time) {
            this.update_time = update_time;
        }

        public int getIs() {
            return is;
        }

        public void setIs(int is) {
            this.is = is;
        }

        public int getTime_difference() {
            return time_difference;
        }

        public void setTime_difference(int time_difference) {
            this.time_difference = time_difference;
        }
    }
}
