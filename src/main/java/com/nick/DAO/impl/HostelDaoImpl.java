package com.nick.DAO.impl;

import com.nick.DAO.HostelDao;
import com.nick.bean.Hostel;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

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

}
