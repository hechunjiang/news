package com.news.mobile.http;

import java.util.TreeMap;

/**
 * Created by sfy. on 2018/11/2 0002.
 */

public class ParmsUtils {
    public TreeMap<String, String> params;

    public ParmsUtils getPostBody(String key, String value) {
        if (this.params == null) {
            params = new TreeMap<>();
        }
        try {
            params.put(key, value);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return this;
    }
}
