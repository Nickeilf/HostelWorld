package com.nick.DAO;

import com.nick.bean.Orders;

import java.util.List;

/**
 * Created by nick on 2017/3/18.
 */
public interface OrderDao {

    public List<Orders> getWaitOrder(String login);
    public List<Orders> getFinishOrder(String login);
    public List<Orders> getCancelOrder(String login);

    public void cancelOrder(int id);
}
