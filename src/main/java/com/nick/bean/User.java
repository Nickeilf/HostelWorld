package com.nick.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by nick on 2017/3/16.
 */
@Entity
@Table(name = "user")
public class User {
    @Id
    private String login;
    private String passwd;
    private String type;

    public User(String login, String type) {
        this.login = login;
        this.type = type;
    }

    public User() {
    }

    public User(String login, String passwd, String type) {
        this.login = login;
        this.passwd = passwd;
        this.type = type;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
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
