package com.news.mobilephone.main.task.presenter;

import com.google.gson.Gson;
import com.news.mobilephone.R;
import com.news.mobilephone.base.BaseResponse;
import com.news.mobilephone.entiyt.GetGoldTimeResponse;
import com.news.mobilephone.entiyt.InfoResponse;
import com.news.mobilephone.entiyt.TaskFinishResponse;
import com.news.mobilephone.entiyt.TaskListNewResponse;
import com.news.mobilephone.entiyt.TaskListResponse;
import com.news.mobilephone.entiyt.request.GetboxtimeRequst;
import com.news.mobilephone.entiyt.request.InfoRequest;
import com.news.mobilephone.entiyt.request.TaskFinishRequest;
import com.news.mobilephone.entiyt.request.TaskListRequest;
import com.news.mobilephone.entiyt.request.TaskRequest;
import com.news.mobilephone.http.Api;
import com.news.mobilephone.http.DataCallBack;
import com.news.mobilephone.http.DataResponseCallback;
import com.news.mobilephone.main.task.contract.TaskContract;
import com.news.mobilephone.utils.ToastUtils;

import java.util.Map;

/**
 * 作者：created by hcj
 * 邮箱：2654313873@qq.com
 * 日期：2018/11/6 10
 */
public class TaskPresenter extends TaskContract.Presenter {
    @Override
    public void getTaskList(TaskListRequest request) {
        mModel.getTaskList(request, new DataResponseCallback<TaskListResponse>() {
            @Override
            public void onSucceed(TaskListResponse taskListResponse) {
                mView.setTask(taskListResponse);
            }

            @Override
            public void onFail(BaseResponse response) {
                mView.showErrorTip(response.getCode(), response.getMsg());
            }

            @Override
            public void onComplete() {

            }
        });

    }

    @Override
    public void getTaskListNew(TaskListRequest request) {
        mModel.getTaskListNew(request, new DataResponseCallback<TaskListNewResponse>() {
            @Override
            public void onSucceed(TaskListNewResponse taskListResponse) {
                mView.setTask(taskListResponse);
            }

            @Override
            public void onFail(BaseResponse response) {
                mView.showErrorTip(100002, response.getMsg());
            }

            @Override
            public void onComplete() {

            }
        });
    }

    @Override
    public void getInfo(InfoRequest request) {
        mModel.getInfo(request, new DataResponseCallback<InfoResponse>() {
            @Override
            public void onSucceed(InfoResponse taskListResponse) {
                mView.getInfo(taskListResponse);
            }

            @Override
            public void onFail(BaseResponse response) {
                // mView.showErrorTip(response.getCode(), response.getMsg());
            }

            @Override
            public void onComplete() {

            }
        });
    }

    @Override
    public void getGoldTime() {
        GetboxtimeRequst requst = new GetboxtimeRequst();

        requst.setKey_code("treasure");

        mModel.getGoldTime(requst, new DataCallBack() {
            @Override
            public void onComplete() {

            }

            @Override
            public void onSucceed(String json) {
                GetGoldTimeResponse response = new Gson().fromJson(json, GetGoldTimeResponse.class);
                if (response.getData().getTime_difference() != 0) {
                    mView.showGoldTime(response.getData().getTime_difference());
                }
            }

            @Override
            public void onFail(BaseResponse baseResponse) {

            }
        });
    }

    @Override
    public void getOpenTreasureBox(final int id) {
        TaskRequest taskRequest = new TaskRequest();
        taskRequest.setId(id + "");
        mModel.getOpenTreasureBox(taskRequest, new DataResponseCallback<Map<String, String>>() {
            @Override
            public void onSucceed(Map<String, String> map) {
                mView.showGoldCome(Integer.parseInt(map.get("Count")), id, map.get("message"));
            }

            @Override
            public void onFail(BaseResponse response) {
                if (response.getCode() == Api.API_CODE_GOLD_FAILD) {
                    mView.showGoldCome(0, id, "");
                    //Toast提示用户无法获取更多金币
                    ToastUtils.showLong(mContext, response.getMsg());
                } else if (response.getCode() == -1000001) {
                    ToastUtils.showLong(mContext, mContext.getString(R.string.network_unavailable_try_again_later));
                }
            }

            @Override
            public void onComplete() {

            }
        });
    }

    @Override
    public void taskFinish(TaskFinishRequest request) {
        mModel.taskFinish(request, new DataResponseCallback<TaskFinishResponse>() {
            @Override
            public void onSucceed(TaskFinishResponse taskListResponse) {
                mView.taskFinish(taskListResponse);
            }

            @Override
            public void onFail(BaseResponse response) {
                mView.showErrorTip(response.getCode(), response.getMsg());
            }

            @Override
            public void onComplete() {

            }
        });
    }
}
