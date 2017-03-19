package com.nick.service.impl;

import com.nick.DAO.ApplyDao;
import com.nick.DAO.PayDao;
import com.nick.DAO.TradeDao;
import com.nick.bean.Apply;
import com.nick.bean.Trade;
import com.nick.service.ApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

/**
 * Created by nick on 2017/3/18.
 */
@Service
public class ApplyServiceImpl implements ApplyService{
    @Autowired
    private ApplyDao applyDao;
    @Autowired
    private PayDao payDao;
    @Autowired
    private TradeDao tradeDao;

    @Override
    public Apply createApply(String hostel, String address, String description, String memberId, String login, String account, String password) {
        boolean correct=payDao.checkPassword(account,password);
        if(correct){
            int max = applyDao.getMaxId();
            Timestamp createTime = new Timestamp(new java.util.Date().getTime());

            Apply apply = new Apply(max,createTime,hostel,address,description,memberId,login,"apply");

            applyDao.addApply(apply);


            Trade trade = new Trade(tradeDao.getMaxTrade(),login,"manager","applyForNewHostel",1000,createTime);
            tradeDao.addTrade(trade);
            tradeDao.managerAccount(1000);

            return apply;
        }else{
            return null;
        }


    }

    @Override
    public boolean findApply(String login) {
        return applyDao.findApply(login);
    }

    @Override
    public boolean findModify(String login) {
        return applyDao.findModify(login);
    }

    @Override
    public void denyApply(String id) {
        applyDao.denyApply(id);
    }

    @Override
    public void approveApply(String id) {
        applyDao.approveApply(id);
    }

    @Override
    public void createModifyApply(String hostel, String address, String description, String memberId, String login) {
        int max =applyDao.getMaxId();
        Timestamp createTime = new Timestamp(new java.util.Date().getTime());
        Apply apply = new Apply(max,createTime,hostel,address,description,memberId,login,"modify");
        applyDao.addApply(apply);
    }
}
