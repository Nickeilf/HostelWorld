package com.nick.service.impl;

import com.nick.DAO.ApplyDao;
import com.nick.DAO.TradeDao;
import com.nick.bean.Apply;
import com.nick.bean.Manager;
import com.nick.bean.Trade;
import com.nick.service.ManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by nick on 2017/3/19.
 */
@Service
public class ManageServiceImpl implements ManageService {
    @Autowired
    private ApplyDao applyDao;
    @Autowired
    private TradeDao tradeDao;

    @Override
    public Manager getManager() {
        return tradeDao.getManager();
    }

    @Override
    public List<Apply> getAllCheckingApply() {
        return applyDao.getAllCheckingApply();
    }
}
