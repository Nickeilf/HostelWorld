package com.nick.DAO.impl;

import com.nick.DAO.MainDao;
import com.nick.bean.Hostel;
import com.nick.bean.Plan;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by nick on 2017/3/13.
 */
@Repository
public class MainDaoImpl extends BaseDaoImpl implements MainDao {
    @Override
    public List<Plan> getTopThree() {
        String hql="from Plan where state='unuse'";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setMaxResults(3);
        return query.list();
    }
}
