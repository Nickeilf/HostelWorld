package com.nick.service;

import com.nick.bean.*;

import java.util.List;

/**
 * Created by nick on 2017/3/19.
 */
public interface ManageService {
    public Manager getManager();

    public List<Apply> getAllCheckingApply();

    public void user2hostelOwner(String login);

    public List<HostelCheck> getCheckList();

    public void checkHostel(String hostel_id,int amount);

    public List<Trade> getAllTrade();

    public List<Register> getAllRegister();

    public List<Orders> getAllOrders();

    public List<HostelPie> getPie();

    public List<Object[]> getTrade();

    public int[] getIncome();
}
