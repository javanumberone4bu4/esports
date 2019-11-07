package com.rimi.esports.common;

/**
 * 消息
 *
 * @author shangzf
 * @date 2019/10/12 16:13
 */
public class Message {

    private String name;
    private String data;
    private long times;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public long getTimes() {
        return times;
    }

    public void setTimes(long times) {
        this.times = times;
    }
}
