package com.nick.bean;

/**
 * Created by nick on 2017/3/20.
 */
public class HostelPie {
    private long value;
    private String name;

    public HostelPie(long value, String name) {
        this.value = value;
        this.name = name;
    }

    public long getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
