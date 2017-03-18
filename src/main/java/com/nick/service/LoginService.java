package com.nick.service;

import com.nick.bean.User;
import com.nick.bean.User_dup;

/**
 * Created by nick on 2017/3/16.
 */
public interface LoginService {
    public User_dup checkLogin(String login, String password);

    public User_dup createUser(String login,String password);

    public User_dup getUser(String login);
}
