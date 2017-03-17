package com.nick.DAO;

import com.nick.bean.User;
import com.nick.bean.User_dup;

/**
 * Created by nick on 2017/3/16.
 */
public interface LoginDao {
    public User_dup checkLogin(String login, String password);

    public boolean haveUser(String login);

    public User_dup createUser(String login,String password);
}
