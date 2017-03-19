package com.nick.DAO.impl;

import com.nick.DAO.ApplyDao;
import com.nick.bean.Apply;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by nick on 2017/3/18.
 */
@Repository
public class ApplyDaoImpl extends BaseDaoImpl implements ApplyDao{
    @Override
    public int getMaxId() {
        String hql="select max(a.apply_id) from Apply a";
        Query query =sessionFactory.getCurrentSession().createQuery(hql);
        int max= (int) query.uniqueResult();
        return max+1;
    }

    @Override
    public void addApply(Apply apply) {
        Session session = sessionFactory.openSession();

        //开启事务
        Transaction tx = session.beginTransaction();
        session.save(apply);
        //提交事务
        tx.commit();
        //关闭Session
        session.close();
    }

    @Override
    public boolean findApply(String login) {
        String hql="select count(*) from Apply where user=? AND type='apply' AND state='check'";
        Query query =sessionFactory.getCurrentSession().createQuery(hql);
        query.setString(0,login);

        long num= (long) query.uniqueResult();
        if(num==0)
            return false;
        else
            return true;
    }

    @Override
    public boolean findModify(String login) {
        String hql="select count(*) from Apply where user=? AND type='modify'AND state='check'";
        Query query =sessionFactory.getCurrentSession().createQuery(hql);
        query.setString(0,login);

        long num= (long) query.uniqueResult();
        if(num==0)
            return false;
        else
            return true;
    }

    @Override
    public List<Apply> getAllCheckingApply() {
        String hql="from Apply where state='check'";
        Query query =sessionFactory.getCurrentSession().createQuery(hql);
        return query.list();
    }

    @Override
    public void approveApply(String id) {
        String hql="update Apply a set a.state='approve'where apply_id=?";
        Query query =sessionFactory.getCurrentSession().createQuery(hql);
        query.setInteger(0,Integer.parseInt(id));
        query.executeUpdate();
    }

    @Override
    public void denyApply(String id) {
        String hql="update Apply a set a.state='deny'where apply_id=?";
        Query query =sessionFactory.getCurrentSession().createQuery(hql);
        query.setInteger(0,Integer.parseInt(id));
        query.executeUpdate();
    }

}
