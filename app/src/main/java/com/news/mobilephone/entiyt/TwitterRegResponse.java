package com.news.mobilephone.entiyt;

import java.io.Serializable;

/**
 * 作者：created by hcj
 * 邮箱：2654313873@qq.com
 * 日期：2018/11/4 16
 */
public class TwitterRegResponse implements Serializable {
    /**
     * |mail|string|否| 邮箱地址 |
     * |verify|string|否| 验证码 |
     * |mobile_brand|string|否| 手机品牌 |
     * |pass|string|否| 密码 |
     * |nickname|string|否| 昵称 |
     * |headimg|string|否| 头像地址 |
     * |twitter_id|string|否| twiterid |
     * |sex|integer|否| 1男 2女 |
     * |f_invit_code|string|是| 邀请码 |
     */

    private String nickName;
    private String headImg;
    private String twitter_id;
    private String sex;

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public String getTwitter_id() {
        return twitter_id;
    }

    public void setTwitter_id(String twitter_id) {
        this.twitter_id = twitter_id;
    }
}
