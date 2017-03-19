package com.nick.service.impl;

import com.nick.DAO.HostelDao;
import com.nick.DAO.OrderDao;
import com.nick.bean.Hostel;
import com.nick.bean.Orders;
import com.nick.bean.Register;
import com.nick.bean.Trade;
import com.nick.service.HostelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by nick on 2017/3/13.
 */
@Service
public class HostelServiceImpl implements HostelService {
    @Autowired
    private HostelDao hostelDao;
    @Autowired
    private OrderDao orderDao;


    @Override
    public Hostel getHostel(String id) {
        return hostelDao.getHostel(id);
    }

    @Override
    public String getMaxId() {
        return hostelDao.getMaxId();
    }

    @Override
    public void createHostel(Hostel hostel) {
        hostelDao.createHostel(hostel);
    }

    @Override
    public Hostel getHostelBylogin(String login) {
        return hostelDao.getHostelByLogin(login);
    }

    @Override
    public void updateInfo(String name, String address, String description, String login) {
        hostelDao.updateInfo(name,address,description,login);
    }

    @Override
    public void createRegister(String hostel_id, String names, String humans, String order_id, String type, String isMember) {
        int id = hostelDao.getMaxRegister();
        int human =Integer.parseInt(humans);
        Timestamp createTime = new Timestamp(new java.util.Date().getTime());

        if(order_id==null||order_id.equals("")){
            Register register = new Register(id,names,human,isMember,type,createTime,hostel_id);
            hostelDao.createRegister(register);
        }else{
            int order=Integer.parseInt(order_id);
            Orders orders=orderDao.getOrder(order);
            Register register = new Register(id,names,human,isMember,type,createTime,hostel_id);
            register.setPlan_id(Integer.parseInt(orders.getPlan_id()));
            register.setOrder_id(orders.getOrder_id());
            hostelDao.createRegister(register);
            orderDao.updateFinish(order);
        }

    }

    @Override
    public void updateRegister(String id) {
        hostelDao.updateRegister(Integer.parseInt(id));
    }

    @Override
    public List<Orders> getRelatedOrders(String hostel_id) {
        return orderDao.getRelatedOrders(hostel_id);
    }

    @Override
    public List<Register> getRelatedRegister(String hostel_id) {
        return hostelDao.getRelatedRegister(hostel_id);
    }

    @Override
    public List<Trade> getRelatedTrade(String hostel_id) {
        return hostelDao.getRelatedTrade(hostel_id);
    }
}
