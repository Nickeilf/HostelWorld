package com.nick.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * Created by nick on 2017/3/19.
 */
@Entity
@Table(name = "register")
public class Register {
    @Id
    private int register_id;
    private String names;
    private int humans;
    private int plan_id;
    private String ismember;
    private String type;//cash or card
    private Timestamp indate;
    private Timestamp outdate;
    private String hostel_id;
    private int order_id;


    public Register(int register_id, String names, int humans, String ismember, String type, Timestamp indate, String hostel_id) {
        this.register_id = register_id;
        this.names = names;
        this.humans = humans;
        this.ismember = ismember;
        this.type = type;
        this.indate = indate;
        this.hostel_id = hostel_id;
    }

    public Register() {
    }

    public int getRegister_id() {
        return register_id;
    }

    public void setRegister_id(int register_id) {
        this.register_id = register_id;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public int getHumans() {
        return humans;
    }

    public void setHumans(int humans) {
        this.humans = humans;
    }

    public int getPlan_id() {
        return plan_id;
    }

    public void setPlan_id(int plan_id) {
        this.plan_id = plan_id;
    }

    public String getIsmember() {
        return ismember;
    }

    public void setIsmember(String ismember) {
        this.ismember = ismember;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Timestamp getIndate() {
        return indate;
    }

    public void setIndate(Timestamp indate) {
        this.indate = indate;
    }

    public Timestamp getOutdate() {
        return outdate;
    }

    public void setOutdate(Timestamp outdate) {
        this.outdate = outdate;
    }

    public String getHostel_id() {
        return hostel_id;
    }

    public void setHostel_id(String hostel_id) {
        this.hostel_id = hostel_id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }
}
