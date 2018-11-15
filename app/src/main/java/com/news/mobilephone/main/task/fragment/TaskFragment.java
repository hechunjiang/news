package com.news.mobilephone.main.task.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.news.mobilephone.BuildConfig;
import com.news.mobilephone.MyApplication;
import com.news.mobilephone.R;
import com.news.mobilephone.base.BaseFragment;
import com.news.mobilephone.base.Constant;
import com.news.mobilephone.entiyt.InfoResponse;
import com.news.mobilephone.entiyt.TaskFinishResponse;
import com.news.mobilephone.entiyt.TaskListNewResponse;
import com.news.mobilephone.entiyt.TaskListResponse;
import com.news.mobilephone.entiyt.event.MessageEvent;
import com.news.mobilephone.entiyt.event.RefreshTaskEvent;
import com.news.mobilephone.entiyt.request.InfoRequest;
import com.news.mobilephone.entiyt.request.TaskFinishRequest;
import com.news.mobilephone.entiyt.request.TaskListRequest;
import com.news.mobilephone.entiyt.request.TaskRequest;
import com.news.mobilephone.http.Api;
import com.news.mobilephone.main.bind.BindEmailActivity;
import com.news.mobilephone.main.mine.activity.EarnActivity;
import com.news.mobilephone.main.mine.activity.FeedbackActivity;
import com.news.mobilephone.main.mine.activity.PersonActivity;
import com.news.mobilephone.main.mine.activity.SettingActivity;
import com.news.mobilephone.main.task.TaskTest;
import com.news.mobilephone.main.task.adapter.TaskAdapter;
import com.news.mobilephone.main.task.adapter.TimeLineAdapter;
import com.news.mobilephone.main.task.contract.TaskContract;
import com.news.mobilephone.main.task.model.TaskModel;
import com.news.mobilephone.main.task.presenter.TaskPresenter;
import com.news.mobilephone.main.web.activity.WebActivity;
import com.news.mobilephone.utils.Common;
import com.news.mobilephone.utils.LogUtil;
import com.news.mobilephone.utils.ToastUtils;
import com.news.mobilephone.utils.UserSpCache;
import com.news.mobilephone.view.CustomLoginDialog;
import com.news.mobilephone.view.EmptyLayout;
import com.news.mobilephone.view.MyRefreshLayout;
import com.news.mobilephone.view.OpenTheTreasureBoxDialog;
import com.news.mobilephone.view.VerticalTextview;
import com.news.mobilephone.view.dialog.UploadProgressDialog;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class TaskFragment extends BaseFragment<TaskPresenter, TaskModel> implements TaskContract.View {

    private RecyclerView rv_task, rv_time_line;
    private MyRefreshLayout refresh;
    private EmptyLayout mEmptyLayout;
    private TaskAdapter adapter;
    private TimeLineAdapter timeLineAdapter;
    private LinearLayout ll_open, id_un;
    private TextView tv_time;
    private VerticalTextview vtv;
    private ArrayList<String> titleList;
    private CustomLoginDialog loginDialog;
    private UploadProgressDialog mDialog;
    private OpenTheTreasureBoxDialog mOpenTheTreasureBoxDialog;


    @Override
    protected int getLayoutResource() {
        EventBus.getDefault().register(this);
        return R.layout.fragment_task;
    }


    @Override
    protected void initView(View v) {
        rv_task = v.findViewById(R.id.rv_task);
        refresh = v.findViewById(R.id.refresh);
        mEmptyLayout = v.findViewById(R.id.mEmptyLayout);
        refresh.setEnableLoadmore(false);

        adapter = new TaskAdapter(new ArrayList<TaskTest>());
        rv_task.setLayoutManager(new LinearLayoutManager(getContext()));
        rv_task.setAdapter(adapter);

        loginDialog = new CustomLoginDialog(getContext(), getActivity());
        mDialog = UploadProgressDialog.initGrayDialog(getActivity());
        mDialog.setCancelable(false);
        mDialog.setMessage("");

    }

    @Override
    public void onResume() {
        super.onResume();
        if (vtv != null && (titleList != null && titleList.size() > 0)) {
            vtv.startAutoScroll();
        }
        mPresenter.getTaskListNew(new TaskListRequest());
    }

    @Override
    public void onPause() {
        super.onPause();
        if (vtv != null && (titleList != null && titleList.size() > 0)) {
            vtv.stopAutoScroll();
        }
    }

    @Override
    public void initObject() {
        setMVP();
        mEmptyLayout.setErrorType(EmptyLayout.LOADING, -1);
        mPresenter.getTaskList(new TaskListRequest());

    }

    @Override
    protected void loadData() {

    }


    @Override
    public void initEvents() {
        refresh.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                mPresenter.getTaskListNew(new TaskListRequest());
            }
        });

        mEmptyLayout.setOnEmptyRefreshLisenter(new EmptyLayout.onEmptyRefreshLisenter() {
            @Override
            public void onEmptyRefresh() {
                mPresenter.getTaskListNew(new TaskListRequest());
            }
        });

        adapter.setOnTaskClickListener(new TaskAdapter.OnTaskClickListener() {
            @Override
            public void onClick(TaskTest item) {
                if (item.t.getIs_award() == 1) {  //可以领取金币
                    mDialog.show();
                    TaskFinishRequest request = new TaskFinishRequest();
                    request.setId(item.t.getId() + "");
                    request.setDebug(BuildConfig.DEBUG ? "ok" : null);
                    mPresenter.taskFinish(request);
                } else if (item.t.getIs_award() == 0) { //金币不可领取才执行任务跳转

                    String button_url = item.t.getButton_url();
                    LogUtil.showLog("button_url=====" + button_url);
                    //button_url = "app:bindEmail";
                    if (button_url.startsWith("app:")) {
                        goTask(button_url);
                    } else if (button_url.startsWith("h5:")) {
                        String[] split = button_url.split(":");
                        WebActivity.toThis(mContext, Api.BASE_H5_URL + split[1]);
                    } else if (button_url.startsWith("http")) {
                        Intent intent = new Intent();
                        intent.setData(Uri.parse(button_url));
                        intent.setAction(Intent.ACTION_VIEW);
                        mContext.startActivity(intent);
                    }

                }
            }
        });
    }

    @Override
    public void OnClickEvents(View v) {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void setTask(TaskListResponse response) {
        adapter.addHeaderView(getHeader(response.getData().getSign(), response.getData().getChest()));
        mPresenter.getInfo(new InfoRequest());
        mPresenter.getTaskListNew(new TaskListRequest());

    }

    private View getHeader(TaskListResponse.DataBeanX.SignBean signBean, TaskListResponse.DataBeanX.ChestBean chestBean) {
        int signDay = 0;
        View view = getLayoutInflater().inflate(R.layout.item_task_header, (ViewGroup) rv_task.getParent(), false);

        List<TaskListResponse.DataBeanX.SignBean.Day7Bean> day7 = signBean.getDay7();
        if (day7 != null) {
            for (int i = 0; i < day7.size(); i++) {
                if (day7.get(i).getStatus() == 1) {  //0.不可签到 1.签到成功 2.可签到
                    signDay = i;
                }
            }
        }

        rv_time_line = view.findViewById(R.id.tv_time_line);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 7);
        rv_time_line.setLayoutManager(gridLayoutManager);
        timeLineAdapter = new TimeLineAdapter(signBean.getDay7());
        rv_time_line.setAdapter(timeLineAdapter);
        timeLineAdapter.setDay(signDay);

        ll_open = view.findViewById(R.id.ll_open);
        id_un = view.findViewById(R.id.id_un);
        tv_time = view.findViewById(R.id.tv_time);

        vtv = view.findViewById(R.id.vtv);

        if (chestBean.getIs() == 0) {  //如果没有开过包厢
            ll_open.setVisibility(View.VISIBLE);

            id_un.setVisibility(View.GONE);
            ll_open.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mPresenter.getOpenTreasureBox(TaskRequest.TASK_ID_OPEN_BOX);
                    mDialog.show();
                }
            });
        } else {  //已经开过宝箱进入倒计时
            //倒计时
            mPresenter.getGoldTime();
        }

        return view;

    }

    @Override
    public void setTask(TaskListNewResponse response) {
        adapter.setNewData(wapperData(response.getData()));
        refresh.finishRefresh();
        mEmptyLayout.setErrorType(EmptyLayout.HIDE_LAYOUT, -1);
        mEmptyLayout.setVisibility(View.GONE);

    }

    /**
     * 数据封装
     *
     * @param dataBean
     * @return
     */
    private List<TaskTest> wapperData(List<TaskListNewResponse.DataBean> dataBean) {
        List<TaskTest> list = new ArrayList<>();

        for (TaskListNewResponse.DataBean d : dataBean) {
            TaskTest taskTest = new TaskTest(true, d.getName());

            list.add(taskTest);
            List<TaskListNewResponse.DataBean.ListBean> list1 = d.getList();
            if (list1 != null) {
                for (TaskListNewResponse.DataBean.ListBean listBean : list1) {
                    TaskTest taskTest1 = new TaskTest(listBean);

                    list.add(taskTest1);
                }
            }

        }
        return list;
    }

    @Override
    public void getInfo(InfoResponse response) {
        initScroll(vtv, response);
        if (response.getData() != null && response.getData().size() > 0) {
            vtv.setVisibility(View.VISIBLE);
            initScroll(vtv, response);
        } else {
            vtv.setVisibility(View.GONE);
        }
    }

    @Override
    public void showGoldTime(int time) {
        ll_open.setVisibility(View.GONE);
        id_un.setVisibility(View.VISIBLE);
        setTimeDown(tv_time, time);
    }

    @Override
    public void showGoldCome(int count, int type, String masgess) {
        mDialog.cancel();
        if (mOpenTheTreasureBoxDialog == null) {
            mOpenTheTreasureBoxDialog = new OpenTheTreasureBoxDialog(getActivity());
        }
        if (!mOpenTheTreasureBoxDialog.isShowing()) {
            mOpenTheTreasureBoxDialog.setCanceledOnTouchOutside(false);//点击空白处不消失
            mOpenTheTreasureBoxDialog.showDialog(count);
            mPresenter.getGoldTime();
        }
    }

    @Override
    public void taskFinish(TaskFinishResponse response) {
        mDialog.dismiss();
        refresh.autoRefresh();
        //todo:加金币弹窗
        ToastUtils.showGoldCoinToast(mContext, response.getMsg(), "+" + response.getData().getGold());
    }


    @SuppressLint("StringFormatInvalid")
    private void initScroll(VerticalTextview mTextview, InfoResponse response) {

        if (mTextview == null) return;
        titleList = new ArrayList<>();

        List<InfoResponse.DataBean> data = response.getData();
        if (data == null || data.size() == 0) {
            return;
        }

        for (InfoResponse.DataBean d : data) {
            titleList.add(getString(R.string.task_info, d.getNickname(), d.getTotal_balance()));
        }

        mTextview.setTextList(titleList);

        mTextview.setText(14, 0, Color.WHITE);//设置属性
        mTextview.setTextStillTime(3000);//设置停留时长间隔
        mTextview.setAnimTime(300);//设置进入和退出的时间间隔
        mTextview.startAutoScroll();

        mTextview.setOnItemClickListener(new VerticalTextview.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {

            }
        });

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    private void setTimeDown(final TextView tv_time, int time) {

        if (time < 0) time = 0;
        final int downTime = time;
        Observable.interval(0, 1, TimeUnit.SECONDS)
                .map(new Func1<Long, String>() {
                    @Override
                    public String call(Long aLong) {
                        return formatTimeStrWithUs((downTime - aLong.intValue()));
                    }
                })
                .take(time + 1)
                .observeOn(AndroidSchedulers.mainThread())
                .onBackpressureDrop()
                .subscribeOn(Schedulers.io())
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        if (s.equals("")) {
                            ll_open.setVisibility(View.VISIBLE);
                            id_un.setVisibility(View.GONE);
                            ll_open.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    mPresenter.getOpenTreasureBox(TaskRequest.TASK_ID_OPEN_BOX);
                                }
                            });
                        } else {
                            tv_time.setText(s);
                        }
                    }
                });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        loginDialog.registerCallBack(requestCode, resultCode, data, true);

    }

    @Override
    public void showErrorTip(int code, String msg) {
        mDialog.dismiss();
        refresh.finishRefresh();
        if(code == 100002){
            mEmptyLayout.setErrorType(EmptyLayout.NO_DATA, EmptyLayout.NET_WORK_ERROR);
        }else {
            mEmptyLayout.setErrorType(EmptyLayout.HIDE_LAYOUT, -1);
            mEmptyLayout.setVisibility(View.GONE);
            ToastUtils.showShort(mContext, msg);
        }
    }

    @Subscribe
    public void refreshTask(String msg) {
        if (msg.equals(Common.REFRESH_USERINFO)) {
            LogUtil.showLog("登陆成功,刷新任务大厅");
            mPresenter.getTaskListNew(new TaskListRequest());
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onRefreshTaskEvent(MessageEvent refreshTaskEvent) {
        if(refreshTaskEvent.getMessage().equals(Common.REFRESH_TASK_LIST)) {
            mPresenter.getTaskListNew(new TaskListRequest());
        }
    }

    public boolean isLogin() {
        UserSpCache mUserSpCache = UserSpCache.getInstance(MyApplication.getAppContext());
        if (!mUserSpCache.getBoolean(Constant.KEY_IS_USER_LOGIN)) {
            //startActivity(LoginActivity.class);
            loginDialog.show();
            return false;
        } else {
            return true;
        }
    }

    private String formatTimeStrWithUs(int secTotal) {
        String result = null;
        if (secTotal > 0) {
            int hour = secTotal / 3600;
            int min = (secTotal % 3600) / 60;
            int sec = (secTotal % 3600) % 60;
            result = to2Str(hour) + ":" + to2Str(min) + ":" + to2Str(sec);
        } else {
            result = "";
        }

        return result;
    }

    private String to2Str(int i) {
        if (i > 9) {
            return i + "";
        } else {
            return "0" + i;
        }
    }

    private void goTask(String taskUrl) {

        if (TextUtils.isEmpty(taskUrl)) {
            return;
        }

        taskUrl = taskUrl.trim();

        String[] split = taskUrl.split(":");

        if (split.length < 2 || TextUtils.isEmpty(split[1])) {
            return;
        }

        if ("indexNews".equals(split[1])) { //首页新闻
            EventBus.getDefault().post(new MessageEvent(Common.SELECT_MAIN));
        } else if ("login".equals(split[1])) { //登陆
            if(isLogin()){}
        } else if ("register".equals(split[1])) { //注册

        } else if ("bindIns".equals(split[1])) { //绑定ins页面

        } else if ("bindLinkedin".equals(split[1])) { //绑定linkedin页面

        } else if ("bindEmail".equals(split[1])) { //绑定邮箱页面
            startActivity(BindEmailActivity.class);
        } else if ("bindFacebook".equals(split[1])) { //绑定facebook操作   （直接调接口）

            loginDialog.faceBookLogin(true);

        } else if ("bindTwitter".equals(split[1])) { // 绑定Twitter操作   （直接调接口）

            loginDialog.twitterLogin(true);
        } else if ("bindGmail".equals(split[1])) { //绑定goodle

            loginDialog.googleLogin(true);
        } else if ("update".equals(split[1])) { //修改信息界面
            if (isLogin()) {
                startActivity(PersonActivity.class);
            }
        } else if ("opinion".equals(split[1])) { //意见反馈
            startActivity(FeedbackActivity.class);
        } else if ("frends".equals(split[1])) { // 收徒界面
            startActivity(EarnActivity.class);
        } else if ("setting".equals(split[1])) { // 退出登陆界面
            startActivity(SettingActivity.class);
        }
    }
}
