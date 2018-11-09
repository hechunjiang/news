package com.news.mobile.main.task;

import com.chad.library.adapter.base.entity.SectionEntity;
import com.news.mobile.entiyt.TaskListNewResponse;

/**
 * 作者：created by hcj
 * 邮箱：2654313873@qq.com
 * 日期：2018/11/6 10
 */
public class TaskTest extends SectionEntity<TaskListNewResponse.DataBean.ListBean> {

    public TaskTest(boolean isHeader, String header) {
        super(isHeader, header);
    }

    public TaskTest(TaskListNewResponse.DataBean.ListBean s) {
        super(s);
    }
}