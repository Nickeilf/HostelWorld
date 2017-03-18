package com.nick.DAO.impl;

import com.nick.DAO.OrderDao;
import com.nick.bean.Orders;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by nick on 2017/3/18.
 */
@Repository
public class OrderDaoImpl extends BaseDaoImpl implements OrderDao{
    @Override
    public List<Orders> getWaitOrder(String login) {
        String hql="from Orders where user_login=? AND state='wait'";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setString(0,login);
        return query.list();
    }

    @Override
    public List<Orders> getFinishOrder(String login) {
        String hql="from Orders where user_login=? AND state='finish'";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setString(0,login);
        return query.list();
    }

    @Override
    public List<Orders> getCancelOrder(String login) {
        String hql="from Orders where user_login=? AND state='cancel'";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setString(0,login);
        return query.list();
    }

    @Override
    public void cancelOrder(int id) {
        String hql="update Orders o set o.state='cancel' where o.order_id=?";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setInteger(0,id);
        query.executeUpdate();



    }
}
