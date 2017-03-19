package com.nick.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by nick on 2017/3/9.
 */
@Entity
@Table(name="hostel")
public class Hostel implements Serializable{
    private int balance;
    @Id
    private String hostel_id;
    private String hostel_name;
    private String address;
    private String description;
    private String member_id;
    private String login;

    public Hostel(int balance, String hostel_id, String hostel_name, String address, String description, String member_id, String login) {
        this.balance = balance;
        this.hostel_id = hostel_id;
        this.hostel_name = hostel_name;
        this.address = address;
        this.description = description;
        this.member_id = member_id;
        this.login = login;
    }

    public Hostel() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMember_id() {
        return member_id;
    }

    public void setMember_id(String member_id) {
        this.member_id = member_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getHostel_id() {
        return hostel_id;
    }

    public void setHostel_id(String hostel_id) {
        this.hostel_id = hostel_id;
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
