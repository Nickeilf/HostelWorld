package com.nick.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by nick on 2017/3/18.
 */
@Entity
@Table(name = "trade")
public class Trade {
    @Id
    private int trade_id;
    private String from_login;
    private String to_login;
    private String reason;
    private int amount;

    public Trade(int trade_id, String from_login, String to_login, String reason, int amount) {
        this.trade_id = trade_id;
        this.from_login = from_login;
        this.to_login = to_login;
        this.reason = reason;
        this.amount = amount;
    }

    public Trade() {
    }

    public int getTrade_id() {
        return trade_id;
    }

    public void setTrade_id(int trade_id) {
        this.trade_id = trade_id;
    }

    public String getFrom_login() {
        return from_login;
    }

    public void setFrom_login(String from_login) {
        this.from_login = from_login;
    }

    public String getTo_login() {
        return to_login;
    }

    public void setTo_login(String to_login) {
        this.to_login = to_login;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
