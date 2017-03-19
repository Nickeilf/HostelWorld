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
    public List<Orders> getRelatedOrders(String hostel_id) {
        String hql="from Orders where hostel_id=?";
        Query query=sessionFactory.getCurrentSession().createQuery(hql);
        query.setString(0,hostel_id);
        return query.list();
    }

    @Override
    public void cancelOrder(int id) {
        String hql="update Orders o set o.state='cancel' where o.order_id=?";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setInteger(0,id);
        query.executeUpdate();



    }

    @Override
    public Orders getOrder(int order_id) {
        String hql = "update Orders set state='finish' where order_id=?";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setInteger(0,order_id);
        query.executeUpdate();

        hql="from Orders where order_id=?";
        query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setInteger(0,order_id);

        return (Orders) query.uniqueResult();
    }

    @Override
    public List<Object[]> getCheckList() {
        String hql = "select o.hostel_id,h.balance,sum(o.amount),h.hostel_name from Orders o,Hostel h where o.type='card'AND o.state='finish'AND o.check_state='uncheck' AND o.hostel_id=h.hostel_id group by o.hostel_id";
        Query query =sessionFactory.getCurrentSession().createQuery(hql);
        return query.list();
    }

    @Override
    public void orderChecked(String hostel_id) {
        String hql = "update Orders set check_state='check' where hostel_id=?";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setString(0,hostel_id);
        query.executeUpdate();
    }

    @Override
    public List<Orders> getAllOrders() {
        String hql = "from Orders ";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        return query.list();
    }

    @Override
    public void updateFinish(int order_id) {
        String hql="update Orders set state='finish'where order_id=?";
        Query query=sessionFactory.getCurrentSession().createQuery(hql);
        query.setInteger(0,order_id);
        query.executeUpdate();
    }
}
