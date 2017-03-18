package com.nick.service;

import com.nick.bean.Apply;
import com.nick.bean.Manager;

import java.util.List;

/**
 * Created by nick on 2017/3/19.
 */
public interface ManageService {
    public Manager getManager();

    public List<Apply> getAllCheckingApply();

}
