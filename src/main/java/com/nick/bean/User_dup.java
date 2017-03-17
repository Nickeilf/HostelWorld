package com.nick.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by nick on 2017/3/16.
 */
@Entity
@Table(name = "user_dup")
public class User_dup {
    @Id
    private String login;
    private String type;

    public User_dup() {
    }

    public User_dup(String login, String type) {
        this.login = login;
        this.type = type;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
