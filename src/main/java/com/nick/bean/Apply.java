package com.nick.bean;

import java.sql.Timestamp;

/**
 * Created by nick on 2017/3/9.
 */
public class Apply {
    private int  apply_id;
    private Timestamp apply_time;
    private String state;
    private String hostel_name;
    private String address;

    public Apply(int apply_id, Timestamp apply_time, String state, String hostel_name, String address) {
        this.apply_id = apply_id;
        this.apply_time = apply_time;
        this.state = state;
        this.hostel_name = hostel_name;
        this.address = address;
    }

    public int getApply_id() {
        return apply_id;
    }

    public void setApply_id(int apply_id) {
        this.apply_id = apply_id;
    }

    public Timestamp getApply_time() {
        return apply_time;
    }

    public void setApply_time(Timestamp apply_time) {
        this.apply_time = apply_time;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getHostel_name() {
        return hostel_name;
    }

    public void setHostel_name(String hostel_name) {
        this.hostel_name = hostel_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
