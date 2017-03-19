package com.nick.service.impl;

import com.nick.DAO.*;
import com.nick.bean.*;
import com.nick.service.ManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
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
    @Autowired
    private LoginDao loginDao;
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private HostelDao hostelDao;

    @Override
    public Manager getManager() {
        return tradeDao.getManager();
    }

    @Override
    public List<Apply> getAllCheckingApply() {
        return applyDao.getAllCheckingApply();
    }

    @Override
    public void user2hostelOwner(String login) {
        loginDao.member2hostel(login);
    }

    @Override
    public List<HostelCheck> getCheckList() {
        List<HostelCheck> hostelCheck = new ArrayList<>();

        List<Object[]> checks = orderDao.getCheckList();
        System.out.println(checks.size()+"------------------------------");
        for (Object[] ch: checks) {
            String hostel_id = (String) ch[0];
            int balance = (int) ch[1];
            long amount =(long)ch[2];
            String name = (String) ch[3];

            HostelCheck check = new HostelCheck(hostel_id,balance,amount,name);
            hostelCheck.add(check);
        }

        return hostelCheck;
    }

    @Override
    public void checkHostel(String hostel_id, int amount) {
        //hostel加钱+manager减钱
        hostelDao.checkMoney(hostel_id,amount);
        //order变为check
        orderDao.orderChecked(hostel_id);
        //增加Trade
        Timestamp createTime = new Timestamp(new java.util.Date().getTime());
        Trade trade = new Trade(tradeDao.getMaxTrade(),"manager",hostel_id,"check",amount,createTime);
        tradeDao.addTrade(trade);
    }

    @Override
    public List<Trade> getAllTrade() {
        return tradeDao.getAllTrade();
    }

    @Override
    public List<Register> getAllRegister() {
        return hostelDao.getAllRegister();
    }

    @Override
    public List<Orders> getAllOrders() {
        return orderDao.getAllOrders();
    }

    @Override
    public List<HostelPie> getPie() {
        List<HostelPie> pies = new ArrayList<>();

        List<Object[]> objects=hostelDao.getPie();
        for (Object[] ob: objects) {
            HostelPie pie = new HostelPie((long)ob[1],(String)ob[0]);
            pies.add(pie);
        }
        return pies;
    }

    @Override
    public List<Object[]> getTrade() {
        return tradeDao.getTrade();
    }

    @Override
    public int[] getIncome() {
        int income[]={100364,105872,111380,110987,125556};
        return income;
    }
}
