package com.news.mobilephone.entiyt;

/**
 * 作者：created by hcj
 * 邮箱：2654313873@qq.com
 * 日期：2018/11/12 09
 */
public class NewsSharedContent {


    /**
     * code : 200
     * msg :
     * data : {"url":"http://api-v2.hesheng138.com//index/xnews/index.html?uuid=de8264a51d9c817ba4353a4610c94054&to_platfrom=old","title":"10 Meme kocak merindukan Luis Milla usai timnas Indonesia kalah","cover_img":"http://beritaqu-static.oss-ap-southeast-1.aliyuncs.com//image/20181110/09/090d656ccb1c644a01f9795577d9cca241ab8245.jpg"}
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
         * url : http://api-v2.hesheng138.com//index/xnews/index.html?uuid=de8264a51d9c817ba4353a4610c94054&to_platfrom=old
         * title : 10 Meme kocak merindukan Luis Milla usai timnas Indonesia kalah
         * cover_img : http://beritaqu-static.oss-ap-southeast-1.aliyuncs.com//image/20181110/09/090d656ccb1c644a01f9795577d9cca241ab8245.jpg
         */

        private String url;
        private String title;
        private String cover_img;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getCover_img() {
            return cover_img;
        }

        public void setCover_img(String cover_img) {
            this.cover_img = cover_img;
        }
    }
}
