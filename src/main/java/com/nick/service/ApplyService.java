package com.nick.service;

import com.nick.bean.Apply;

/**
 * Created by nick on 2017/3/18.
 */
public interface ApplyService {

    public Apply createApply(String hostel,String address,String description,String memberId,String login,String account,String password);

    public boolean findApply(String login);
}
