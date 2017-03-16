package com.nick.service.impl;

import com.nick.DAO.MainDao;
import com.nick.bean.Hostel;
import com.nick.bean.Plan;
import com.nick.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by nick on 2017/3/13.
 */
@Service
public class MainServiceImpl implements MainService {

    @Autowired
    private MainDao mainDao;

    @Override
    public List<Plan> getTop3() {
        return mainDao.getTopThree();
    }
}
