package com.nick.DAO;

import com.nick.bean.Orders;

/**
 * Created by nick on 2017/3/17.
 */
public interface PayDao {
    public int getMaxId();

    public void createOrder(Orders orders);

    public boolean checkPassword(String account,String password);

    public void recharge(String account,int amount,String login);
}
