package com.news.mobile.http;

import com.news.mobile.base.BaseRequest;
import com.news.mobile.entiyt.request.FeedBackRequest;
import com.news.mobile.entiyt.request.GetCodeRequest;
import com.news.mobile.entiyt.request.GetboxtimeRequst;
import com.news.mobile.entiyt.request.InfoRequest;
import com.news.mobile.entiyt.request.LoginRequest;
import com.news.mobile.entiyt.request.NewsAddGoodRequest;
import com.news.mobile.entiyt.request.NewsDetailRequest;
import com.news.mobile.entiyt.request.NewsGoldRequest;
import com.news.mobile.entiyt.request.NewsListRequest;
import com.news.mobile.entiyt.request.PariseRequest;
import com.news.mobile.entiyt.request.PlatformLogin;
import com.news.mobile.entiyt.request.PushTokenRequest;
import com.news.mobile.entiyt.request.ResetPassRequst;
import com.news.mobile.entiyt.request.ShareNewsRequest;
import com.news.mobile.entiyt.request.ShareVisitRequest;
import com.news.mobile.entiyt.request.SharedRequest;
import com.news.mobile.entiyt.request.TaskListRequest;
import com.news.mobile.entiyt.request.TaskRequest;
import com.news.mobile.entiyt.request.TaskRequestAdVideo;
import com.news.mobile.entiyt.request.TempLoginRequest;
import com.news.mobile.entiyt.request.ThirdRequest;
import com.news.mobile.entiyt.request.ThridLoginRequest;
import com.news.mobile.entiyt.request.UserMsgRequest;
import com.news.mobile.entiyt.request.VideoReportRequest;

import java.util.HashMap;

import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Streaming;
import retrofit2.http.Url;
import rx.Observable;

/**
 * Created by sfy. on 2018/11/2 0002.
 */

public interface HttpService {

    /**
     * 临时登录
     *
     * @param hashMap
     * @param request
     * @return
     */
    @POST(Api.TEMPLE_LOGIN)
    Observable<String> requestTempLogin(@HeaderMap HashMap<String, String> hashMap, @Body TempLoginRequest request);

    @POST(Api.PUSH_TOKEN)
    Observable<String> onPushToken(@HeaderMap HashMap<String, String> map, @Body PushTokenRequest request);

    /**
     * 上传图片
     *
     * @param file
     * @return
     */
    @Multipart
    @POST(Api.UPLOAD_FILE)
    Observable<String> uploadFile(@HeaderMap HashMap<String, String> map, @Part MultipartBody.Part file);

    //用户个人资料
    @POST(Api.OTHER_USER_DATA)
    Observable<String> getUserCommentList(@HeaderMap HashMap<String, String> map);


    @POST(Api.USER_MSG)
    Observable<String> setUserMsg(@HeaderMap HashMap<String, String> map, @Body UserMsgRequest request);

    @Streaming
    @GET
    Observable<ResponseBody> downloadApk(@Url String url);

    /**
     * 获取新闻列表
     *
     * @param headerMap
     * @param request
     * @return
     */
    @POST(Api.GET_NEWS_LIST)
    Observable<String> requestNewsList(@HeaderMap HashMap<String, String> headerMap, @Body NewsListRequest request);

    /**
     * 新闻点赞
     *
     * @param hashMap
     * @param request
     * @return
     */
    @POST(Api.PARSE_NEWS)
    Observable<String> requestParsenews(@HeaderMap HashMap<String, String> hashMap, @Body PariseRequest request);


    @POST(Api.NEWS_SHARCONTENT)
    Observable<String> requestSharedConttent(@HeaderMap HashMap<String, String> hashMap, @Body ShareNewsRequest request);


    /**
     * 获取用户信息
     *
     * @param headerMap
     * @param baseRequest
     * @return
     */
    @POST(Api.USERINFO)
    Observable<String> requestPersonMsg(@HeaderMap HashMap<String, String> headerMap, @Body BaseRequest baseRequest);

    /**
     * 获取验证码
     *
     * @param map
     * @param request
     * @return
     */
    @POST(Api.SMS_CODE_MAIL)
    Observable<String> getSmsCode(@HeaderMap HashMap<String, String> map, @Body GetCodeRequest request);

    /***
     * 重置密码
     * @param map
     * @param request
     * @return
     */
    @POST(Api.FIND_PASS_EMAIL)
    Observable<String> resetPss(@HeaderMap HashMap<String, String> map, @Body ResetPassRequst request);

    /**
     * 邮箱登录
     *
     * @param map
     * @param request
     * @return
     */
    @POST(Api.LOGIN)
    Observable<String> onLogin(@HeaderMap HashMap<String, String> map, @Body LoginRequest request);

    /**
     * 三方登录
     *
     * @param map
     * @param request
     * @return
     */
    @POST(Api.TASK_THRID)
    Observable<String> getGold(@HeaderMap HashMap<String, String> map, @Body ThridLoginRequest request);

    /**
     * 分享计数
     *
     * @param map
     * @param request
     * @return
     */

    @POST(Api.SHARE_VISIT)
    Observable<String> shareVisit(@HeaderMap HashMap<String, String> map, @Body ShareVisitRequest request);

    @POST(Api.READ_NEWS_GET_GOLD)
    Observable<String> getAdVideoByTask(@HeaderMap HashMap<String, String> map, @Body TaskRequestAdVideo request);

    @POST(Api.SHARE_INFO)
    Observable<String> getShareInfo(@HeaderMap HashMap<String, String> map);

    //分享
    @POST(Api.INVITE_SHARE_DATAS)
    Observable<String> videoShareUrl(@HeaderMap HashMap<String, String> map, @Body SharedRequest request);

    @POST(Api.CHECK_THIRDLOGIN)
    Observable<String> checkLogin(@HeaderMap HashMap<String, String> map, @Body ThirdRequest request);


    @POST(Api.APPRENTICEPAGEDATA)
    Observable<String> apprenticePageData(@HeaderMap HashMap<String, String> map, @Body BaseRequest request);

    /**
     * 七天签到
     *
     * @param map
     * @param request
     * @return
     */
    @POST(Api.TASK_LIST)
    Observable<String> getTaskList(@HeaderMap HashMap<String, String> map, @Body TaskListRequest request);

    /**
     * 任务列表
     *
     * @param map
     * @param request
     * @return
     */
    @POST(Api.TASK_LIST_NEW)
    Observable<String> getTaskListNew(@HeaderMap HashMap<String, String> map, @Body TaskListRequest request);


    /**
     * 收益列表
     *
     * @param map
     * @param request
     * @return
     */
    @POST(Api.TASK_GET_INFO)
    Observable<String> getTaskInfo(@HeaderMap HashMap<String, String> map, @Body InfoRequest request);


    //金币时间
    @POST(Api.GET_GOLDBOX_TIME)
    Observable<String> getGoldboxTime(@HeaderMap HashMap<String, String> map, @Body GetboxtimeRequst requst);

    //金币视频
    @POST(Api.READ_NEWS_GET_GOLD)
    Observable<String> getGoldByTask(@HeaderMap HashMap<String, String> map, @Body TaskRequest request);

    /**
     * 举报
     *
     * @param map
     * @param request
     * @return
     */
    @POST(Api.VIDEO_REPORT)
    Observable<String> videoReport(@HeaderMap HashMap<String, String> map, @Body VideoReportRequest request);

    @POST(Api.MESSAGE_LIST)
    Observable<String> onMessageList(@HeaderMap HashMap<String, String> map, @Body BaseRequest request);

    @POST(Api.FEEDBACK_CLASSIFY)
    Observable<String> feedbackClassify(@HeaderMap HashMap<String, String> map, @Body BaseRequest request);

    @POST(Api.FEEDBACK_SEND)
    Observable<String> feedbackSend(@HeaderMap HashMap<String, String> map, @Body FeedBackRequest request);

    @POST(Api.NEWS_DETAIL)
    Observable<String> getNewsDetail(@HeaderMap HashMap<String, String> map, @Body NewsDetailRequest request);

    @POST(Api.NEWS_GOLD)
    Observable<String> getNewsGold(@HeaderMap HashMap<String, String> map, @Body NewsGoldRequest request);

    @POST(Api.NEWS_ADD_GOOD)
    Observable<String> addGood(@HeaderMap HashMap<String, String> map, @Body NewsAddGoodRequest request);
}
