package com.nick.service;

import com.nick.bean.Hostel;
import com.nick.bean.Orders;
import com.nick.bean.Register;
import com.nick.bean.Trade;

import java.util.List;

/**
 * Created by nick on 2017/3/13.
 */
public interface HostelService {
    public Hostel getHostel(String id);

    public String getMaxId();

    public void createHostel(Hostel hostel);

    public Hostel getHostelBylogin(String login);

    public void updateInfo(String name,String address,String description,String login);

    public void createRegister(String hostel_id,String names,String humans,String order_id,String type,String isMember);

    public void updateRegister(String id);

    public List<Orders> getRelatedOrders(String hostel_id);

    public List<Register> getRelatedRegister(String hostel_id);

    public List<Trade> getRelatedTrade(String hostel_id);


}
