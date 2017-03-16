package com.nick.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

/**
 * Created by nick on 2017/3/10.
 */
@Entity
@Table(name = "plan")
public class Plan {
    @Id
    private int plan_id;
    private Date fromdate;
    private Date todate;
    private String room;
    private int price;
    private int people;
    private int bed_num;
    private String state;//是否正在居住
    private String hostel_id;
    private String plan_description;


    public Plan(int plan_id, Date fromdate, Date to, String room, int price, int people, int bed_num, String state) {
        this.plan_id = plan_id;
        this.fromdate = fromdate;
        this.todate = to;
        this.room = room;
        this.price = price;
        this.people = people;
        this.bed_num=bed_num;
        this.state=state;
    }

    public Plan() {
    }

    public String getPlan_description() {
        return plan_description;
    }

    public void setPlan_description(String plan_description) {
        this.plan_description = plan_description;
    }

    public String getHostel_id() {
        return hostel_id;
    }

    public void setHostel_id(String hostel_id) {
        this.hostel_id = hostel_id;
    }


    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getBed_num() {
        return bed_num;
    }

    public void setBed_num(int bed_num) {
        this.bed_num = bed_num;
    }

    public int getPlan_id() {
        return plan_id;
    }

    public void setPlan_id(int plan_id) {
        this.plan_id = plan_id;
    }

    public Date getFromdate() {
        return fromdate;
    }

    public void setFromdate(Date from) {
        this.fromdate = from;
    }

    public Date getTodate() {
        return todate;
    }

    public void setTodate(Date to) {
        this.todate = to;
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
