package com.nick.service.impl;

import com.nick.DAO.MemberDao;
import com.nick.DAO.PayDao;
import com.nick.DAO.TradeDao;
import com.nick.bean.Member;
import com.nick.bean.Orders;
import com.nick.bean.Trade;
import com.nick.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.sql.Date;

/**
 * Created by nick on 2017/3/17.
 */
@Service
public class PayServiceImpl implements PayService {
    @Autowired
    private PayDao payDao;
    @Autowired
    private MemberDao memberDao;
    @Autowired
    private TradeDao tradeDao;

    @Override
    public void createOrder(String human, String price, int minus, Date fromdate, Date todate, String hostel_id, String plan_id, String cardOrCash,String userlogin,String hostel_name,String plan_name) {
        int max = payDao.getMaxId();
        max+=1;

        Timestamp createTime = new Timestamp(new java.util.Date().getTime());
        int amount =minus*Integer.parseInt(price);

        int human_count =Integer.parseInt(human);

        Member member=memberDao.getMemberByLogin(userlogin);
        int level=member.getLevel();
        amount = (int) (amount*(1-level*0.02));

        Orders orders = new Orders(max,createTime,"wait",amount,hostel_id,fromdate,todate,userlogin,cardOrCash,human_count,plan_id,hostel_name,plan_name);
        payDao.createOrder(orders);

        memberDao.updateCredit(member,amount,cardOrCash);

        Trade trade = new Trade(tradeDao.getMaxTrade(),userlogin,"manager","order",amount);
        tradeDao.addTrade(trade);
        tradeDao.managerAccount(amount);
    }

    @Override
    public boolean recharge(String account, String password, String amount,String login) {

        boolean success = payDao.checkPassword(account,password);

        if(!success){
            return success;
        }else{
            payDao.recharge(account,Integer.parseInt(amount),login);
        }
        return true;
    }


}
