package com.nick.DAO.impl;

import com.nick.DAO.TradeDao;
import com.nick.bean.Manager;
import com.nick.bean.Trade;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by nick on 2017/3/18.
 */
@Repository
public class TradeDaoImpl extends BaseDaoImpl implements TradeDao {

    @Override
    public void addTrade(Trade trade) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(trade);
        tx.commit();
        session.close();
    }

    @Override
    public int getMaxTrade() {
        String hql="select max(t.trade_id) from Trade t";
        Query query =sessionFactory.getCurrentSession().createQuery(hql);
        int max= (int) query.uniqueResult();
        return max+1;
    }

    @Override
    public void managerAccount(int amount) {
        String hql="update Manager set balance=balance+?where login='manager'";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setInteger(0,amount);
        query.executeUpdate();
    }

    @Override
    public Manager getManager() {
        String hql="from Manager";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        return (Manager) query.uniqueResult();
    }

    @Override
    public List<Trade> getRelatedTrade(String login) {
        String hql="from Trade t where t.from_login=? OR t.to_login=?";
        Query query =sessionFactory.getCurrentSession().createQuery(hql);
        query.setString(0,login);
        query.setString(1,login);
        return query.list();
    }

    @Override
    public List<Trade> getAllTrade() {
        String hql="from Trade";
        Query query =sessionFactory.getCurrentSession().createQuery(hql);
        return query.list();
    }

    @Override
    public List<Object[]> getTrade() {
        String hql="select to_login,amount,DATE(create_time) from Trade";
        Query query=sessionFactory.getCurrentSession().createQuery(hql);
        return query.list();
    }
}
