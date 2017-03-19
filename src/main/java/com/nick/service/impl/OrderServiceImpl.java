package com.nick.service.impl;

import com.nick.DAO.OrderDao;
import com.nick.bean.Orders;
import com.nick.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by nick on 2017/3/18.
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Override
    public List<Orders> getWaitOrder(String login) {
        return orderDao.getWaitOrder(login);
    }

    @Override
    public List<Orders> getFinishOrder(String login) {
        return orderDao.getFinishOrder(login);
    }

    @Override
    public List<Orders> getCancelOrder(String login) {
        return orderDao.getCancelOrder(login);
    }


    @Override
    public void cancelOrder(String id) {

        int order_id =Integer.parseInt(id);

        orderDao.cancelOrder(order_id);
    }
}
