package com.news.mobile.main.task.contract;

import com.news.mobile.base.BaseModel;
import com.news.mobile.base.BasePresenter;
import com.news.mobile.base.BaseView;
import com.news.mobile.entiyt.InfoResponse;
import com.news.mobile.entiyt.TaskListNewResponse;
import com.news.mobile.entiyt.TaskListResponse;
import com.news.mobile.entiyt.request.GetboxtimeRequst;
import com.news.mobile.entiyt.request.InfoRequest;
import com.news.mobile.entiyt.request.TaskListRequest;
import com.news.mobile.entiyt.request.TaskRequest;
import com.news.mobile.http.DataCallBack;
import com.news.mobile.http.DataResponseCallback;

import java.util.Map;

/**
 * 作者：created by hcj
 * 邮箱：2654313873@qq.com
 * 日期：2018/11/6 10
 */
public interface TaskContract {
    abstract class Model extends BaseModel {

        public abstract void getTaskList(TaskListRequest request, DataResponseCallback<TaskListResponse> callBack);

        public abstract void getTaskListNew(TaskListRequest request, DataResponseCallback<TaskListNewResponse> callBack);

        public abstract void getInfo(InfoRequest request, DataResponseCallback<InfoResponse> callBack);

        public abstract void getGoldTime(GetboxtimeRequst requst, DataCallBack callBack);

        public abstract void getOpenTreasureBox(TaskRequest taskRequest, DataResponseCallback<Map<String, String>> callback);


    }

    interface View extends BaseView {

        void setTask(TaskListResponse response);

        void setTask(TaskListNewResponse response);

        void getInfo(InfoResponse response);

        void showGoldTime(int time);

        void showGoldCome(int count, int type, String masgess);

    }

    abstract class Presenter extends BasePresenter<View, Model> {
        //1.任务大厅
        public abstract void getTaskList(TaskListRequest request);

        //任务列表
        public abstract void getTaskListNew(TaskListRequest request);

        //获取滚动数据
        public abstract void getInfo(InfoRequest request);

        //获取时间
        public abstract void getGoldTime();//获取时间

        public abstract void getOpenTreasureBox(int id);//开宝箱


    }
}
