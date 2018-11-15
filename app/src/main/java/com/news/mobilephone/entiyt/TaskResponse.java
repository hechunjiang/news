package com.news.mobilephone.entiyt;

import com.google.gson.annotations.SerializedName;
import com.news.mobilephone.base.BaseResponse;

/**
 * 作者：created by hcj
 * 邮箱：2654313873@qq.com
 * 日期：2018/11/5 13
 */
public class TaskResponse extends BaseResponse {
    private Data data;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public static class Data {
        @SerializedName("gold_flag")
        private int count;
        @SerializedName("count")
        private int mCount;

        public int getmCount() {
            return mCount;
        }

        public void setmCount(int mCount) {
            this.mCount = mCount;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }
    }

}
