package com.search;

import com.search.entity.EventListItemEntity;

import java.util.List;

/**
 * Created by zhang shuailing on 2016/4/15.
 * email bitxiaozhang@163.com
 */
public class JsonParseModel {
    private int count;
    private String msg;
    private List<EventListItemEntity> eventList;
    private int code;

    public JsonParseModel() {
    }

    public JsonParseModel(int count, String msg, List<EventListItemEntity> eventList, int code) {
        this.count = count;
        this.msg = msg;
        this.eventList = eventList;
        this.code = code;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<EventListItemEntity> getEventList() {
        return eventList;
    }

    public void setEventList(List<EventListItemEntity> eventList) {
        this.eventList = eventList;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
