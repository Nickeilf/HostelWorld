package com.nick.DAO.impl;

import com.nick.DAO.TradeDao;
import com.nick.bean.Manager;
import com.nick.bean.Trade;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

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
}
