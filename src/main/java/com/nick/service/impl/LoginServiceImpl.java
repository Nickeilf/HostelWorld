package com.nick.service.impl;

import com.nick.DAO.LoginDao;
import com.nick.bean.User;
import com.nick.bean.User_dup;
import com.nick.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by nick on 2017/3/16.
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginDao loginDao;

    @Override
    public User_dup checkLogin(String login, String password) {
        return loginDao.checkLogin(login,password);
    }

    @Override
    public User_dup createUser(String login, String password) {
        boolean haveUser = loginDao.haveUser(login);
        if(!haveUser){
            return loginDao.createUser(login,password);
        }else{
            return null;
        }
    }
}
