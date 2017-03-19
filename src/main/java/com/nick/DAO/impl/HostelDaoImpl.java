package com.nick.DAO.impl;

import com.nick.DAO.HostelDao;
import com.nick.bean.Hostel;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.text.DecimalFormat;
import java.util.List;

/**
 * Created by nick on 2017/3/13.
 */
@Repository
public class HostelDaoImpl extends BaseDaoImpl implements HostelDao {

    @Override
    public Hostel getHostel(String id) {
        String hql="from Hostel where hostel_id =?";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setString(0,id);
        List<Hostel> list = query.list();

        return (Hostel)query.uniqueResult();
    }

    @Override
    public String getMaxId() {
        String hql="select max(h.hostel_id) from Hostel h";
        Query query =sessionFactory.getCurrentSession().createQuery(hql);
        String maxId= (String) query.uniqueResult();

        System.out.println(maxId);

        maxId=maxId.substring(1);
        int num=Integer.parseInt(maxId);

        System.out.println(num);

        num+=1;
        DecimalFormat df=new DecimalFormat("000000");
        String str2=df.format(num);

        String hostelId="m"+str2;
        return hostelId;
    }

    @Override
    public void createHostel(Hostel hostel) {
        Session session =sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(hostel);
        //提交事务
        tx.commit();
        //关闭Session
        session.close();
    }

    @Override
    public Hostel getHostelByLogin(String hostel) {
        String hql="from Hostel where login =?";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setString(0,hostel);
        return (Hostel) query.uniqueResult();
    }

    @Override
    public void updateInfo(String name, String address, String description, String login) {
        String hql="update Hostel h set h.hostel_name=?,h.address=?,h.description=?where login =?";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setString(0,name);
        query.setString(1,address);
        query.setString(2,description);
        query.setString(3,login);
        query.executeUpdate();
    }

}
