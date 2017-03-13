package com.nick.bean;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by nick on 2017/3/9.
 */
public class Order {
    private int order_id;
    private Timestamp order_time;
    private String state;
    private int amount;//总价
    private String hostel_id;
    private Date from;
    private Date to;
    private String user_login;
    private String type;//房型
    private int number;//人数

    public Order(int order_id, Timestamp order_time, String state, int amount, String hostel_id, Date from, Date to, String user_login, String type, int number) {
        this.order_id = order_id;
        this.order_time = order_time;
        this.state = state;
        this.amount = amount;
        this.hostel_id = hostel_id;
        this.from = from;
        this.to = to;
        this.user_login = user_login;
        this.type = type;
        this.number = number;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public Timestamp getOrder_time() {
        return order_time;
    }

    public void setOrder_time(Timestamp order_time) {
        this.order_time = order_time;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getHostel_id() {
        return hostel_id;
    }

    public void setHostel_id(String hostel_id) {
        this.hostel_id = hostel_id;
    }

    public Date getFrom() {
        return from;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    public Date getTo() {
        return to;
    }

    public void setTo(Date to) {
        this.to = to;
    }

    public String getUser_login() {
        return user_login;
    }

    public void setUser_login(String user_login) {
        this.user_login = user_login;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
