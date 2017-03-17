package com.nick.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Date;

/**
 * Created by nick on 2017/3/9.
 */

@Entity
@Table(name = "member")
public class Member implements Serializable{
    @Id
    private String member_id;
    private int balance;
    private Date last_pay;
    private String state;
    private int point;//积分
    private int level;//等级(消费10^（n-1）,为n级，默认1级)
    private String login;
    private String name;
    private String phone;
    private String email;

    public Member() {
    }

    public String getEmail() {
        return email;
    }

    public Member(String member_id,String login){
        this.member_id = member_id;
        balance=0;
        state="invalid";
        point =0;
        level=1;
        this.login=login;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMember_id() {
        return member_id;
    }

    public void setMember_id(String member_id) {
        this.member_id = member_id;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public Date getLast_pay() {
        return last_pay;
    }

    public void setLast_pay(Date last_pay) {
        this.last_pay = last_pay;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
