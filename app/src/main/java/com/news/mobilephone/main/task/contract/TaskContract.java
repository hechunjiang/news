package com.news.mobilephone.main.task.contract;

import com.news.mobilephone.base.BaseModel;
import com.news.mobilephone.base.BasePresenter;
import com.news.mobilephone.base.BaseView;
import com.news.mobilephone.entiyt.InfoResponse;
import com.news.mobilephone.entiyt.TaskFinishResponse;
import com.news.mobilephone.entiyt.TaskListNewResponse;
import com.news.mobilephone.entiyt.TaskListResponse;
import com.news.mobilephone.entiyt.request.GetboxtimeRequst;
import com.news.mobilephone.entiyt.request.InfoRequest;
import com.news.mobilephone.entiyt.request.TaskFinishRequest;
import com.news.mobilephone.entiyt.request.TaskListRequest;
import com.news.mobilephone.entiyt.request.TaskRequest;
import com.news.mobilephone.http.DataCallBack;
import com.news.mobilephone.http.DataResponseCallback;

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


        public abstract void taskFinish(TaskFinishRequest request, DataResponseCallback<TaskFinishResponse> callBack);
    }

    interface View extends BaseView {

        void setTask(TaskListResponse response);

        void setTask(TaskListNewResponse response);

        void getInfo(InfoResponse response);

        void showGoldTime(int time);

        void showGoldCome(int count, int type, String masgess);

        void taskFinish(TaskFinishResponse response);

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

        public abstract void taskFinish(TaskFinishRequest request);

    }
}
