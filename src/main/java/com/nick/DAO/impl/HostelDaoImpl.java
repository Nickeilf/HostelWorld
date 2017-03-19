package com.nick.DAO.impl;

import com.nick.DAO.HostelDao;
import com.nick.bean.Hostel;
import com.nick.bean.Register;
import com.nick.bean.Trade;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
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

        String hostelId="h"+str2;
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

    @Override
    public void createRegister(Register register) {
        Session session =sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(register);
        //提交事务
        tx.commit();
        //关闭Session
        session.close();
    }

    @Override
    public int getMaxRegister() {
        String hql="select max(r.register_id) from Register r";
        Query query =sessionFactory.getCurrentSession().createQuery(hql);
        int max= (int) query.uniqueResult();
        return max+1;
    }

    @Override
    public void updateRegister(int id) {
        String hql="update Register r set outdate=? where id=?";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);

        Timestamp createTime = new Timestamp(new java.util.Date().getTime());

        query.setTimestamp(0,createTime);
        query.setInteger(1,id);
        query.executeUpdate();

    }

    @Override
    public void checkMoney(String hostel_id, int money) {
        String hql ="update Hostel set balance=balance+? where hostel_id=?";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setInteger(0,money);
        query.setString(1,hostel_id);
        query.executeUpdate();

        hql ="update Manager set balance=balance-? where login='manager'";
        query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setInteger(0,money);
        query.executeUpdate();
    }

    @Override
    public List<Register> getRelatedRegister(String hostel_id) {
        String hql="from Register where hostel_id=?";
        Query query=sessionFactory.getCurrentSession().createQuery(hql);
        query.setString(0,hostel_id);
        return query.list();
    }

    @Override
    public List<Trade> getRelatedTrade(String hostel_id) {
        String hql="from Trade where to_login=?";
        Query query=sessionFactory.getCurrentSession().createQuery(hql);
        query.setString(0,hostel_id);
        return query.list();
    }

    @Override
    public List<Register> getAllRegister() {
        String hql="from Register ";
        Query query=sessionFactory.getCurrentSession().createQuery(hql);
        return query.list();
    }

    @Override
    public List<Object[]> getPie() {
        String hql="select r.hostel_id,sum(r.humans) from Register r group by r.hostel_id";
        Query query=sessionFactory.getCurrentSession().createQuery(hql);
        return query.list();
    }

}
