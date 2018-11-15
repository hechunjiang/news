package com.news.mobilephone.http;

import com.news.mobilephone.BuildConfig;

/**
 * Created by sfy. on 2018/11/2 0002.
 */

public class Api {

    public static final String BASE_URL = BuildConfig.BASE_URL;
    public static final String BASE_H5_URL = BuildConfig.BASE_WEB_URL;
    public static final String BASE_WEB_URL = BuildConfig.BASE_WEB_URL;
    public static final int API_CODE_GOLD_FAILD = 10002;


    //手机头部信息
    public static final String HEADER_OS = "os";
    public static final String HEADER_MEID = "meid";
    public static final String HEADER_VERSION = "version";
    public static final String HEADER_TICKET = "ticket";
    public static final String HEADER_RATIO = "ratio";
    public static final String HEADER_BRAND = "brand";
    public static final String HEADER_BLUETOOTH = "bh";//头文件蓝牙
    public static final String HEADER_OPTICAL_SENSOR = "sensor";//头文件光传感器
    public static final String HEADER_CPU = "cpu";//头文件cpu
    public static final String LANGUAGE = "language";//语言
    public static final String LAT = "lat";
    public static final String LNG = "lng";
    public static final String COUNTRY = "country";


    //SigJson
    public static final String MOBILE_BRAND = "mobile_brand";
    public static final String PAGE = "page";
    public static final String R_TYPE = "r_type";
    public static final String MAIL = "mail";
    public static final String TYPE = "type";
    public static final String PASS = "pass";
    public static final String VERIFY = "verify";
    public static final String LOGIN_SOURCE = "login_source";
    public static final String FACEBOOK = "fb_id";
    public static final String TIWTTER_ID = "twitter_id";
    public static final String LINKEDIN_ID = "lk_id";
    public static final String HEAD_IMG = "headimg";
    public static final String TASK = "task";
    public static final String FACEBOOK_TOKEN = "fb_access_token";
    public static final String GOOGLE_ID = "gg_id";
    public static final String NICK_NAME = "nickname";
    public static final String SEX = "sex";
    public static final String ACTIVITY_TYPE = "activity_type";
    public static final String CODE = "code";
    public static final String SHARE_CHANNEL = "share_channel";
    public static final String VID = "vid";
    public static final String DU_TYPE = "du_type";
    public static final String VIDEOID = " videoId";
    public static final String ID = "id";
    public static final String CONTENT = "content";
    public static final String HEADIMAGE = "headImg";
    public static final String BIRTHDAY = "birthday";
    public static final String MARKID = "markId";
    public static final String NICKNAME = "nickname";
    public static final String SIGNATURE = "signature";//tag列表
    public static final String key_code = "key_code";
    public static final String F_CODE = "f_code";
    public static final String DEBUG = "debug";
    public static final String NEW_ID = "news_id";

    public static final String NEWS_ID = "new_id";
    public static final String KEY_CODE = "key_code";
    public static final String SIZE = "size";
    public static final String ORDER = "order";


    //请求地址
    public static final String TEMPLE_LOGIN = "app/Reg/f_reg";//临时登录
    public static final String USERINFO = "app/User/index";//获取我的用户信息
    public static final String SMS_CODE_MAIL = "app/pub/mailSendCode";//获取验证码
    public static final String BINDEMAIL = "app/Task/bindMail";
    public static final String FIND_PASS_EMAIL = "app/reg/m_findpass";//重设密码
    public static final String LOGIN = "app/Login/index";//登录接口
    public static final String CHECK_LOGIN = "app/reg/check_login";//checklogin
    public static final String CHECK_THIRDLOGIN = "app/Login/thirdPartyLogin";
    public static final String APPRENTICEPAGEDATA = "app/Apprentice/apprenticePageData";//获取任务大厅信息
    public static final String BASIC_REWARD = BASE_H5_URL + "makeMoney/basicReward.html";
    public static final String PERMANENT_COMMISSION = BASE_H5_URL + "makeMoney/permanentCommission.html";
    public static final String SHARE = BASE_H5_URL + "makeMoney/share.html";
    public static final String APPRENTICE_DISCIPLE = BASE_H5_URL + "makeMoney/apprenticeDisciple.html?type=1";
    public static final String APPRENTICE_DISCIPLE_TYPE = BASE_H5_URL + "makeMoney/apprenticeDisciple.html?type=2";
    public static final String SHARE_VISIT = "app/Datapre/shareVisit";//分享计数
    public static final String TASK_THRID = "app/Login/thirdPartyTask"; // 三方登陆成功
    public static final String INVITE_SHARE_DATAS = "app/Activateshare/shareWithInvitationCode";//分享
    public static final String VIDEO_REPORT = "app/Report/video";//举报视频
    public static final String SHARE_INFO = "app/Activateshare/share";//获取分享信息
    public static final String READ_NEWS_GET_GOLD = "app/mission_new/handler";//金币
    public static final String MESSAGE_LIST = "app/Announce/getAnnounceList"; //公告
    public static final String PUSH_TOKEN = "app/user/setFirebase";//firebase 推送注册
    public static final String OTHER_USER_DATA = "app/user/workInfo";//用户资料
    public static final String UPLOAD_FILE = "app/pub/imageFormUpload";//上传头像
    public static final String USER_MSG = "app/user/setUserMsg";//上传个人信息
    public static final String TASK_LIST = "app/task/index"; //任务大厅
    public static final String TASK_LIST_NEW = "app/task/lists"; //任务列表
    public static final String TASK_GET_INFO = "app/pub/withdrawlist"; //收益列表
    public static final String GET_GOLDBOX_TIME = "app/Task/treasureStatus";//获取金币时间app/news/todayNews
    public static final String GET_NEWS_LIST = "app/news/todayNews";//获取新闻列表
    public static final String PARSE_NEWS = "app/news/like";//新闻点赞
    public static final String NEWS_SHARCONTENT = "app/Activateshare/newsShare";//新闻点赞
    public static final String TASK_FINISH = "app/mission_new/handler"; //任务结束，领取金币
    public static final String SHARED_VISITED = "app/Datapre/shareVisit";//分享计数
    public static final String SIGNIN_DAY = "app/mission_new/handler";//签到

    //意见反馈
    public static final String FEEDBACK_CLASSIFY = "app/Feedback/getFbTypeList";
    public static final String FEEDBACK_SEND = "app/Feedback/send";

    //h5请求地址
    public static final String MelExchange = BASE_H5_URL + "personal/incomeDetails.html?type=1";
    public static final String ENTER = BASE_H5_URL + "personal/enterCode.html";
    public static final String MelRankingList = BASE_H5_URL + "personal/billboard.html";//排行榜H5页面
    public static final String CONTACT = BASE_H5_URL + "personal/contactUs.html";

    //新闻详情
    public static final String NEWS_DETAIL = "app/news/getNewsDetail";
    public static final String NEWS_GOLD = "app/mission_new/handler";
    public static final String NEWS_ADD_GOOD = "app/news/like";
    public static final String NEWS_COMMONT_LIST = "app/Comment/getList";
    public static final String NEWS_COMMONT = "app/Comment/push";
    public static final String NEWS_VISIT = "app/Datapre/newsVisit";


}
