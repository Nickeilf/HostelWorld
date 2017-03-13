package com.nick.bean;

/**
 * Created by nick on 2017/3/9.
 */
public class Hostel {
    private int balance;
    private String hostel_id;
    private String hostel_name;
    private String address;
    private String description;
    private String member_id;

    public Hostel(int balance, String hostel_id, String hostel_name, String address,String description,String member_id) {
        this.balance = balance;
        this.hostel_id = hostel_id;
        this.hostel_name = hostel_name;
        this.address = address;
        this.description=description;
        this.member_id=member_id;
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
