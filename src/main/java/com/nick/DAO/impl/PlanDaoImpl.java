package com.nick.DAO.impl;

import com.nick.DAO.PlanDao;
import com.nick.bean.Plan;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.List;


/**
 * Created by nick on 2017/3/13.
 */
@Repository
public class PlanDaoImpl extends BaseDaoImpl implements PlanDao {
    @Override
    public Plan getPlan(int id) {
        String hql="from Plan where plan_id =?";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setInteger(0,id);
        return (Plan)query.uniqueResult();
    }

    @Override
    public List<Plan> getCurrentPlans(int page,Date checkin,Date checkout,int human) {
        String hql="from Plan p where fromdate <=? AND todate>=? AND people>=?";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);

        System.out.println(checkin.toString()+"  "+checkout.toString());
        query.setDate(0,checkin);
        query.setDate(1,checkout);
        query.setInteger(2,human);

        return query.list();
    }

    @Override
    public List<Plan> getCurrentPlans(int page, String location, Date checkin, Date checkout, int human) {
        String hql="select p from Plan p,Hostel h where p.fromdate <=? AND p.todate>=? AND p.people>=? AND p.hostel_id=h.hostel_id AND h.address like ?";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);

        System.out.println(checkin.toString()+"  "+checkout.toString());
        query.setDate(0,checkin);
        query.setDate(1,checkout);
        query.setInteger(2,human);
        query.setString(3,"%"+location+"%");

        return query.list();
    }

    @Override
    public List<Plan> getCurrentPlans(int page, int human) {
        String hql="from Plan p where people>=?";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);

        query.setInteger(0,human);

        return query.list();
    }

    @Override
    public List<Plan> getRelatedPlans(String hostelid) {
        String hql="from Plan p where hostel_id=?";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setString(0,hostelid);
        return query.list();
    }

}
