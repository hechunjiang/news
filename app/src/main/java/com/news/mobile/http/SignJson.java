package com.news.mobile.http;

import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.news.mobile.base.Constant;
import com.news.mobile.entiyt.request.FeedBackRequest;
import com.news.mobile.entiyt.request.GetCodeRequest;
import com.news.mobile.entiyt.request.GetboxtimeRequst;
import com.news.mobile.entiyt.request.NewsAddGoodRequest;
import com.news.mobile.entiyt.request.NewsDetailRequest;
import com.news.mobile.entiyt.request.NewsGoldRequest;
import com.news.mobile.entiyt.request.NewsListRequest;
import com.news.mobile.entiyt.request.PariseRequest;
import com.news.mobile.entiyt.request.PushTokenRequest;
import com.news.mobile.entiyt.request.ResetPassRequst;
import com.news.mobile.entiyt.request.ShareNewsRequest;
import com.news.mobile.entiyt.request.ShareVisitRequest;
import com.news.mobile.entiyt.request.TaskRequest;
import com.news.mobile.entiyt.request.TaskRequestAdVideo;
import com.news.mobile.entiyt.request.TempLoginRequest;
import com.news.mobile.entiyt.request.ThirdRequest;
import com.news.mobile.entiyt.request.ThridLoginRequest;
import com.news.mobile.entiyt.request.UserMsgRequest;
import com.news.mobile.entiyt.request.VideoReportRequest;

/**
 * Created by sfy. on 2018/11/2 0002.
 */

public class SignJson {

    /**
     * 临时登录
     *
     * @param request
     * @return
     */
    public static String signTempLogin(TempLoginRequest request) {
        ParmsUtils parmsUtils = new ParmsUtils();
        if (!TextUtils.isEmpty(request.getMobile_brand())) {
            parmsUtils.getPostBody(Api.MOBILE_BRAND, request.getMobile_brand());
        }
        Gson gson = new GsonBuilder().serializeNulls().create();
        String json = gson.toJson(parmsUtils.params);
        return json;
    }

    /**
     * 推送token
     *
     * @param request
     * @return
     */
    public static String signPushToken(PushTokenRequest request) {
        ParmsUtils parmsUtils = new ParmsUtils();
        parmsUtils.getPostBody("token", request.getToken() + "");
        parmsUtils.getPostBody("topic", request.getTopic() + "");
        Gson gson = new GsonBuilder().serializeNulls().create();
        String json = gson.toJson(parmsUtils.params);
        return json;
    }

    /**
     * 新闻列表
     *
     * @param request
     * @return
     */
    public static String NewsList(NewsListRequest request) {
        ParmsUtils parmsUtils = new ParmsUtils();
        if (!TextUtils.isEmpty(request.getPage())) {
            parmsUtils.getPostBody(Api.PAGE, request.getPage());
        }
        if (!TextUtils.isEmpty(request.getR_type())) {
            parmsUtils.getPostBody(Api.R_TYPE, request.getR_type());
        }
        Gson gson = new GsonBuilder().serializeNulls().create();
        String json = gson.toJson(parmsUtils.params);
        return json;

    }

    /**
     * 上传个人信息
     *
     * @param request
     * @return
     */

    public static String signUserMsg(UserMsgRequest request) {
        ParmsUtils parmsUtils = new ParmsUtils();

        if (!TextUtils.isEmpty(request.getBirthday())) {
            parmsUtils.getPostBody(Api.BIRTHDAY, request.getMarkId());
        }
        if (!TextUtils.isEmpty(request.getHeadImg())) {
            parmsUtils.getPostBody(Api.HEADIMAGE, request.getHeadImg());
        }
        if (!TextUtils.isEmpty(request.getMarkId())) {
            parmsUtils.getPostBody(Api.MARKID, request.getMarkId());
        }
        if (!TextUtils.isEmpty(request.getNickname())) {
            parmsUtils.getPostBody(Api.NICKNAME, request.getNickname());
        }
        if (!TextUtils.isEmpty(request.getSex())) {
            parmsUtils.getPostBody(Api.SEX, request.getSex());
        }
        if (!TextUtils.isEmpty(request.getSignature())) {
            parmsUtils.getPostBody(Api.SIGNATURE, request.getSignature());
        }

        Gson gson = new GsonBuilder().serializeNulls().create();
        String json = gson.toJson(parmsUtils.params);
        return json;
    }


    /**
     * 短信验证码
     *
     * @param request
     * @return
     */
    public static String signGetSmsCode(GetCodeRequest request) {
        ParmsUtils parmsUtils = new ParmsUtils();
        if (!TextUtils.isEmpty(request.getMail())) {
            parmsUtils.getPostBody(Api.MAIL, request.getMail());
        }
        if (!TextUtils.isEmpty(request.getType())) {
            parmsUtils.getPostBody(Api.TYPE, request.getType());
        }
        Gson gson = new GsonBuilder().serializeNulls().create();
        String json = gson.toJson(parmsUtils.params);
        return json;
    }

    /**
     * 找回密码
     *
     * @param request
     * @return
     */
    public static String signFindPass(ResetPassRequst request) {
        ParmsUtils parmsUtils = new ParmsUtils();
        if (!TextUtils.isEmpty(request.getPhone())) {
            parmsUtils.getPostBody(Api.MAIL, request.getPhone());
        }
        if (!TextUtils.isEmpty(request.getPass())) {
            parmsUtils.getPostBody(Api.PASS, request.getPass());
        }
        if (!TextUtils.isEmpty(request.getCode())) {
            parmsUtils.getPostBody(Api.VERIFY, request.getCode());
        }
        Gson gson = new GsonBuilder().serializeNulls().create();
        String json = gson.toJson(parmsUtils.params);
        return json;
    }

    /**
     * 登录
     *
     * @param phone
     * @param pass
     * @return
     */
    public static String singOnLogin(String phone, String pass) {
        ParmsUtils parmsUtils = new ParmsUtils();
        if (!TextUtils.isEmpty(phone)) {
            parmsUtils.getPostBody(Api.MAIL, phone);
        }
        if (!TextUtils.isEmpty(pass)) {
            parmsUtils.getPostBody(Api.PASS, pass);
        }
        Gson gson = new GsonBuilder().serializeNulls().create();
        String json = gson.toJson(parmsUtils.params);

        return json;
    }

    /**
     * 三方登陆成功
     *
     * @param request
     * @return
     */
    public static String signThridLogin(ThridLoginRequest request) {
        ParmsUtils parmsUtils = new ParmsUtils();
        parmsUtils.getPostBody(Api.LOGIN_SOURCE, request.getLogin_source() + "");

        parmsUtils.getPostBody(Api.TASK_THRID, request.getUser_id());

        Gson gson = new GsonBuilder().serializeNulls().create();
        String json = gson.toJson(parmsUtils.params);
        return json;
    }

    public static String checkIsLogin(ThirdRequest request) {
        ParmsUtils parmsUtils = new ParmsUtils();
        if (!TextUtils.isEmpty(request.getMobile_brand())) {
            parmsUtils.getPostBody(Api.MOBILE_BRAND, request.getMobile_brand());
        }
        if (!TextUtils.isEmpty(request.getHeadimg())) {
            parmsUtils.getPostBody(Api.HEAD_IMG, request.getHeadimg());
        }
        if (!TextUtils.isEmpty(request.getNickname())) {
            parmsUtils.getPostBody(Api.NICK_NAME, request.getNickname());
        }
        if (!TextUtils.isEmpty(request.getSex())) {
            parmsUtils.getPostBody(Api.SEX, request.getSex());
        }
        if (!TextUtils.isEmpty(request.getLogin_source())) {
            parmsUtils.getPostBody(Api.LOGIN_SOURCE, request.getLogin_source());
        }
        if (!TextUtils.isEmpty(request.getTask())) {
            parmsUtils.getPostBody(Api.TASK, request.getTask());
        }

        if (request.getLogin_source().equals(Constant.FACEBOOK)) {

            if (!TextUtils.isEmpty(request.getFb_id())) {
                parmsUtils.getPostBody(Api.FACEBOOK, request.getFb_id());
            }
            if (!TextUtils.isEmpty(request.getFb_access_token())) {
                parmsUtils.getPostBody(Api.FACEBOOK_TOKEN, request.getFb_access_token());
            }

        } else if (request.getLogin_source().equals(Constant.TWITTER)) {

            if (!TextUtils.isEmpty(request.getTwitter_id())) {
                parmsUtils.getPostBody(Api.TIWTTER_ID, request.getTwitter_id());
            }


        } else if (request.getLogin_source().equals(Constant.LINKEDIN)) {
            if (!TextUtils.isEmpty(request.getLk_id())) {
                parmsUtils.getPostBody(Api.LINKEDIN_ID, request.getLk_id());
            }

        } else if (request.getLogin_source().equals(Constant.GOOGLELOGIN)) {
            if (!TextUtils.isEmpty(request.getGm_id())) {
                parmsUtils.getPostBody(Api.GOOGLE_ID, request.getGm_id());
            }
        }
        Gson gson = new GsonBuilder().serializeNulls().create();
        String json = gson.toJson(parmsUtils.params);
        return json;
    }

    /**
     * 举报
     *
     * @param request
     * @return
     */
    public static String signVideoReport(VideoReportRequest request) {
        ParmsUtils parmsUtils = new ParmsUtils();
        if (!TextUtils.isEmpty(request.getVideoId())) {
            parmsUtils.getPostBody(Api.VIDEOID, request.getVideoId());
        }
        Gson gson = new GsonBuilder().serializeNulls().create();
        String json = gson.toJson(parmsUtils.params);
        return json;
    }

    /**
     * 推送消息
     *
     * @param request
     * @return
     */
    public static String signFeedBack(FeedBackRequest request) {
        ParmsUtils parmsUtils = new ParmsUtils();
        parmsUtils.getPostBody(Api.TYPE, request.getType() + "");
        parmsUtils.getPostBody(Api.CONTENT, request.getContent() + "");
        Gson gson = new GsonBuilder().serializeNulls().create();
        String json = gson.toJson(parmsUtils.params);
        return json;
    }

    /**
     * 金币任务
     *
     * @param request
     * @return
     */
    public static String signTaskGoldAdVideo(TaskRequestAdVideo request) {
        ParmsUtils parmsUtils = new ParmsUtils();
        parmsUtils.getPostBody(Api.ID, request.getId() + "");

        Gson gson = new GsonBuilder().serializeNulls().create();
        String json = gson.toJson(parmsUtils.params);
        return json;
    }


    /**
     * @param request
     * @return
     */
    public static String signGoldTime(GetboxtimeRequst request) {
        ParmsUtils parmsUtils = new ParmsUtils();
        if (!TextUtils.isEmpty(request.getKey_code())) {
            parmsUtils.getPostBody(Api.key_code, request.getKey_code() + "");
        }

        Gson gson = new GsonBuilder().serializeNulls().create();
        String json = gson.toJson(parmsUtils.params);
        return json;
    }

    /**
     * 金币任务
     *
     * @param request
     * @return
     */
    public static String signTaskGold(TaskRequest request) {
        ParmsUtils parmsUtils = new ParmsUtils();
        if (!TextUtils.isEmpty(request.getId())) {
            parmsUtils.getPostBody(Api.ID, request.getId() + "");
        }
        if (!TextUtils.isEmpty(request.getF_code())) {
            parmsUtils.getPostBody(Api.F_CODE, request.getF_code());
        }
        Gson gson = new GsonBuilder().serializeNulls().create();
        String json = gson.toJson(parmsUtils.params);
        return json;
    }


    /**
     * 分享计数签名
     *
     * @param request
     * @return
     */
    public static String signShareVisit(ShareVisitRequest request) {
        ParmsUtils parmsUtils = new ParmsUtils();
        if (!TextUtils.isEmpty(request.getActivityType())) {
            parmsUtils.getPostBody(Api.ACTIVITY_TYPE, request.getActivityType());
        }
        if (!TextUtils.isEmpty(request.getCode())) {
            parmsUtils.getPostBody(Api.CODE, request.getCode());
        }
        if (!TextUtils.isEmpty(request.getShareChannel())) {
            parmsUtils.getPostBody(Api.SHARE_CHANNEL, request.getShareChannel());
        }
        if (!TextUtils.isEmpty(request.getVideoId())) {
            parmsUtils.getPostBody(Api.VID, request.getVideoId());
        }
        if (!TextUtils.isEmpty(request.getDuType())) {
            parmsUtils.getPostBody(Api.DU_TYPE, request.getDuType());
        }
        Gson gson = new GsonBuilder().serializeNulls().create();
        String json = gson.toJson(parmsUtils.params);
        return json;
    }

    /**
     * 新闻详情
     *
     * @param request
     * @return
     */
    public static String signNewsDetail(NewsDetailRequest request) {
        ParmsUtils parmsUtils = new ParmsUtils();
        parmsUtils.getPostBody(Api.ID, request.getId() + "");

        if (!TextUtils.isEmpty(request.getDebug())) {
            parmsUtils.getPostBody(Api.DEBUG, request.getDebug());
        }
        Gson gson = new GsonBuilder().serializeNulls().create();
        String json = gson.toJson(parmsUtils.params);
        return json;
    }

    /**
     * 加金币
     *
     * @param request
     * @return
     */
    public static String signNewsGold(NewsGoldRequest request) {
        ParmsUtils parmsUtils = new ParmsUtils();
        parmsUtils.getPostBody(Api.ID, request.getId() + "");

        if (!TextUtils.isEmpty(request.getDebug())) {
            parmsUtils.getPostBody(Api.DEBUG, request.getDebug());
        }
        Gson gson = new GsonBuilder().serializeNulls().create();
        String json = gson.toJson(parmsUtils.params);
        return json;
    }

    /**
     * 新闻点赞
     *
     * @param request
     * @return
     */
    public static String signAddGood(NewsAddGoodRequest request) {
        ParmsUtils parmsUtils = new ParmsUtils();
        parmsUtils.getPostBody(Api.NEW_ID, request.getNew_id() + "");
        parmsUtils.getPostBody(Api.DU_TYPE, request.getDu_type());

        Gson gson = new GsonBuilder().serializeNulls().create();
        String json = gson.toJson(parmsUtils.params);
        return json;
    }

    public static String signParseNews(PariseRequest request) {
        ParmsUtils parmsUtils = new ParmsUtils();

        if (!TextUtils.isEmpty(request.getDu_type())) {
            parmsUtils.getPostBody(Api.DU_TYPE, request.getDu_type());
        }
        if (!TextUtils.isEmpty(request.getNews_id())) {
            parmsUtils.getPostBody(Api.NEWS_ID, request.getDu_type());
        }

        Gson gson = new GsonBuilder().serializeNulls().create();
        String json = gson.toJson(parmsUtils.params);
        return json;
    }

    public static String signShareNewsConntent(ShareNewsRequest request) {
        ParmsUtils parmsUtils = new ParmsUtils();
        if (!TextUtils.isEmpty(request.getNews_id())) {
            parmsUtils.getPostBody(Api.NEWS_ID, request.getNews_id());
        }
        if (!TextUtils.isEmpty(request.getKey_code())) {
            parmsUtils.getPostBody(Api.key_code, request.getKey_code());
        }
        Gson gson = new GsonBuilder().serializeNulls().create();
        String json = gson.toJson(parmsUtils.params);
        return json;
    }
}
