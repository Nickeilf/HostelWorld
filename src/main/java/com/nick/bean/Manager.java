package com.nick.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by nick on 2017/3/18.
 */
@Entity
@Table(name = "manager")
public class Manager {
    @Id
    private String login;
    private int balance;
    private String name;

    public Manager() {
    }

    public Manager(String login, int balance, String name) {
        this.login = login;
        this.balance = balance;
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
