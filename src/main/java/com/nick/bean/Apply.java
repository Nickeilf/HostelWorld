package com.nick.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * Created by nick on 2017/3/9.
 */
@Entity
@Table(name = "apply")
public class Apply {
    @Id
    private int  apply_id;
    private Timestamp apply_time;
    private String state;
    private String hostel_name;
    private String address;
    private String description;
    private String member_id;
    private String user;
    private String type;//是申请还是修改信息


    public Apply(int apply_id, Timestamp apply_time, String hostel_name, String address, String description, String member_id, String user, String type) {
        this.apply_id = apply_id;
        this.apply_time = apply_time;
        this.state = "check";
        this.hostel_name = hostel_name;
        this.address = address;
        this.description = description;
        this.member_id = member_id;
        this.user = user;
        this.type = type;
    }

    public Apply() {
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
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
