package com.nick.DAO.impl;

import com.nick.DAO.PayDao;
import com.nick.bean.BankAccount;
import com.nick.bean.Member;
import com.nick.bean.Orders;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

/**
 * Created by nick on 2017/3/17.
 */
@Repository
public class PayDaoImpl extends BaseDaoImpl implements PayDao {
    @Override
    public int getMaxId() {
        String hql="select max(o.order_id) from Orders o";
        Query query =sessionFactory.getCurrentSession().createQuery(hql);
        int max= (int) query.uniqueResult();
        return max;
    }

    @Override
    public void createOrder(Orders orders) {
        Session session = sessionFactory.openSession();

        //开启事务
        Transaction tx = session.beginTransaction();
        session.save(orders);
        //提交事务
        tx.commit();
        //关闭Session
        session.close();
    }

    @Override
    public boolean checkPassword(String account, String password) {
        String hql = "from BankAccount where account=? AND passwd=?";
        Query query =sessionFactory.getCurrentSession().createQuery(hql);
        query.setString(0,account);
        query.setString(1,password);
        BankAccount bankAccount = (BankAccount) query.uniqueResult();

        if(bankAccount!=null){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public void recharge(String account, int amount,String login) {
        String hql ="from Member where login=?";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setString(0,login);
        Member member = (Member) query.uniqueResult();
        member.setBalance(member.getBalance()+amount);

        if(member.getBalance()>=1000&&member.getState().equals("invalid")){
            member.setState("use");
        }

        //账户--
        hql="update BankAccount set balance=balance-? where account=?";
        query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setInteger(0,amount);
        query.setString(1,account);
        query.executeUpdate();

        //member++
        hql="update Member set balance=?,state=?where login=?";
        query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setInteger(0,member.getBalance());
        query.setString(1,member.getState());
        query.setString(2,login);
        query.executeUpdate();
    }
}
