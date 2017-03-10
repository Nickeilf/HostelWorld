package com.nick.bean;

import java.util.Date;

/**
 * Created by nick on 2017/3/10.
 */
public class Plan {
    private int plan_id;
    private Date from;
    private Date to;
    private String room;
    private int price;
    private int people;

    public Plan(int plan_id, Date from, Date to, String room, int price, int people) {
        this.plan_id = plan_id;
        this.from = from;
        this.to = to;
        this.room = room;
        this.price = price;
        this.people = people;
    }

    public int getPlan_id() {
        return plan_id;
    }

    public void setPlan_id(int plan_id) {
        this.plan_id = plan_id;
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

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPeople() {
        return people;
    }

    public void setPeople(int people) {
        this.people = people;
    }
}
