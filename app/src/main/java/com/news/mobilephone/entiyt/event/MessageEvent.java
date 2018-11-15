package com.news.mobilephone.entiyt.event;

/**
 * @Author weiwei
 * create by 2018/11/13
 * Des: <功能简述>
 * 代码不优雅，写锤子代码
 */
public class MessageEvent {
    private String message;
    private Object data;
    public  MessageEvent(String message){
        this.message=message;
    }

    public MessageEvent(String message, Object data) {
        this.message = message;
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
