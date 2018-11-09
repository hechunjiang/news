package com.news.mobile.main.task.model;

import com.google.gson.Gson;
import com.news.mobile.base.BaseResponse;
import com.news.mobile.entiyt.InfoResponse;
import com.news.mobile.entiyt.TaskListNewResponse;
import com.news.mobile.entiyt.TaskListResponse;
import com.news.mobile.entiyt.TaskOpenBoxResponse;
import com.news.mobile.entiyt.TaskSingInResponse;
import com.news.mobile.entiyt.request.GetboxtimeRequst;
import com.news.mobile.entiyt.request.InfoRequest;
import com.news.mobile.entiyt.request.TaskListRequest;
import com.news.mobile.entiyt.request.TaskRequest;
import com.news.mobile.http.DataCallBack;
import com.news.mobile.http.DataResponseCallback;
import com.news.mobile.main.task.contract.TaskContract;

import java.util.HashMap;
import java.util.Map;

/**
 * 作者：created by hcj
 * 邮箱：2654313873@qq.com
 * 日期：2018/11/6 10
 */
public class TaskModel extends TaskContract.Model {

    @Override
    public void getTaskList(TaskListRequest request, final DataResponseCallback<TaskListResponse> callBack) {
        getRetrofit().getTaskList(request, new DataCallBack() {
            @Override
            public void onComplete() {
                callBack.onComplete();
            }

            @Override
            public void onSucceed(String json) {
                TaskListResponse newsResponse = new Gson().fromJson(json, TaskListResponse.class);
                callBack.onSucceed(newsResponse);
            }

            @Override
            public void onFail(BaseResponse baseResponse) {
                callBack.onFail(baseResponse);
            }
        });
    }

    @Override
    public void getTaskListNew(TaskListRequest request, final DataResponseCallback<TaskListNewResponse> callBack) {
        getRetrofit().getTaskListNew(request, new DataCallBack() {
            @Override
            public void onComplete() {
                callBack.onComplete();
            }

            @Override
            public void onSucceed(String json) {
                TaskListNewResponse newsResponse = new Gson().fromJson(json, TaskListNewResponse.class);
                callBack.onSucceed(newsResponse);
            }

            @Override
            public void onFail(BaseResponse baseResponse) {
                callBack.onFail(baseResponse);
            }
        });
    }

    @Override
    public void getInfo(InfoRequest request, final DataResponseCallback<InfoResponse> callBack) {
        getRetrofit().getTaskInfo(request, new DataCallBack() {
            @Override
            public void onComplete() {
                callBack.onComplete();
            }

            @Override
            public void onSucceed(String json) {
                InfoResponse newsResponse = new Gson().fromJson(json, InfoResponse.class);
                callBack.onSucceed(newsResponse);
            }

            @Override
            public void onFail(BaseResponse baseResponse) {
                callBack.onFail(baseResponse);
            }
        });
    }

    @Override
    public void getGoldTime(GetboxtimeRequst requst, final DataCallBack callBack) {
        getRetrofit().getGoldBoxTime(requst, new DataCallBack() {
            @Override
            public void onComplete() {
                callBack.onComplete();
            }

            @Override
            public void onSucceed(String json) {
                callBack.onSucceed(json);
            }

            @Override
            public void onFail(BaseResponse baseResponse) {
                callBack.onFail(baseResponse);
            }
        });
    }

    @Override
    public void getOpenTreasureBox(final TaskRequest request, final DataResponseCallback<Map<String, String>> cacheBack) {
        getRetrofit().getGoldByTask(request, new DataCallBack() {
            @Override
            public void onComplete() {
                cacheBack.onComplete();
            }

            @Override
            public void onSucceed(String json) {
                Map<String, String> map = new HashMap<>();
                if (request.getId().equals(TaskRequest.TASK_ID_OPEN_BOX + "")) {
                    TaskOpenBoxResponse taskResponse = new Gson().fromJson(json, TaskOpenBoxResponse.class);
                    map.put("Count", taskResponse.getData().getGold_tribute() + "");
                    map.put("message", taskResponse.getMsg());
                } else {
                    TaskSingInResponse taskSingInResponse = new Gson().fromJson(json, TaskSingInResponse.class);
                    map.put("Count", taskSingInResponse.getData().getGold_flag() + "");
                    map.put("message", taskSingInResponse.getMsg());
                }
                cacheBack.onSucceed(map);
            }

            @Override
            public void onFail(BaseResponse baseResponse) {
                cacheBack.onFail(baseResponse);
            }

        });
    }

}
