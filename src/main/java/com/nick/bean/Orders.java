package com.nick.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.sql.Date;

/**
 * Created by nick on 2017/3/9.
 */
@Entity
@Table(name = "orders")
public class Orders {
    @Id
    private int order_id;
    private Timestamp order_time;
    private String state;
    private int amount;//总价
    private String hostel_id;
    private Date fromdate;
    private Date todate;
    private String user_login;
    private String type;//支付方式
    private int number;//人数
    private String plan_id;

    public Orders(int order_id, Timestamp order_time, String state, int amount, String hostel_id, Date fromdate, Date todate, String user_login, String type, int number, String plan_id) {
        this.order_id = order_id;
        this.order_time = order_time;
        this.state = state;
        this.amount = amount;
        this.hostel_id = hostel_id;
        this.fromdate = fromdate;
        this.todate = todate;
        this.user_login = user_login;
        this.type = type;
        this.number = number;
        this.plan_id = plan_id;
    }

    public Orders() {
    }

    public String getPlan_id() {
        return plan_id;
    }

    public void setPlan_id(String plan_id) {
        this.plan_id = plan_id;
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

    public Date getFromdate() {
        return fromdate;
    }

    public void setFromdate(Date fromdate) {
        this.fromdate = fromdate;
    }

    public Date getTodate() {
        return todate;
    }

    public void setTodate(Date todate) {
        this.todate = todate;
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
