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
    private String description;
    private String member_id;
    private String type;//是申请还是修改信息



    public Apply(int apply_id, Timestamp apply_time, String state, String hostel_name, String address, String description, String member_id, String type) {
        this.apply_id = apply_id;
        this.apply_time = apply_time;
        this.state = state;
        this.hostel_name = hostel_name;
        this.address = address;
        this.description = description;
        this.member_id = member_id;
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMember_id() {
        return member_id;
    }

    public void setMember_id(String member_id) {
        this.member_id = member_id;
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
