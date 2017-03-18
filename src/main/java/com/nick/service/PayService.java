package com.nick.service;

import java.sql.Date;

/**
 * Created by nick on 2017/3/17.
 */
public interface PayService {

    public void createOrder(String human, String price, int minus, Date fromdate, Date todate, String hostel_id, String plan_id, String cardOrCash, String userlogin);

    public boolean recharge(String account,String password,String amount,String login);
}
