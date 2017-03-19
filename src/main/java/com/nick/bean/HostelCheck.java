package com.nick.bean;

/**
 * Created by nick on 2017/3/19.
 */
public class HostelCheck {
    private String hostel_id;
    private int balance;
    private long check;
    private String hostel_name;

    public HostelCheck(String hostel_id, int balance, long check, String hostel_name) {
        this.hostel_id = hostel_id;
        this.balance = balance;
        this.check = check;
        this.hostel_name = hostel_name;
    }

    public String getHostel_name() {
        return hostel_name;
    }

    public void setHostel_name(String hostel_name) {
        this.hostel_name = hostel_name;
    }

    public String getHostel_id() {
        return hostel_id;
    }

    public void setHostel_id(String hostel_id) {
        this.hostel_id = hostel_id;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public long getCheck() {
        return check;
    }

    public void setCheck(long check) {
        this.check = check;
    }
}
