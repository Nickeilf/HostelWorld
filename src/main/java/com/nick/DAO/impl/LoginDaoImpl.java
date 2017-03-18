package com.nick.DAO.impl;

import com.nick.DAO.LoginDao;
import com.nick.bean.Member;
import com.nick.bean.User;
import com.nick.bean.User_dup;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.text.DecimalFormat;


/**
 * Created by nick on 2017/3/16.
 */
@Repository
public class LoginDaoImpl extends BaseDaoImpl implements LoginDao {
    @Override
    public User_dup checkLogin(String login, String password) {
        String hql="select ud from User u,User_dup ud where u.login=? AND u.passwd=? AND u.login=ud.login";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setString(0,login);
        query.setString(1,password);

        return (User_dup)query.uniqueResult();
    }

    @Override
    public boolean haveUser(String login) {
        String hql="select count(*) from User where login=?";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setString(0,login);

        long num= (long) query.uniqueResult();
        if(num==0)
            return false;
        else
            return true;
    }

    @Override
    public User_dup createUser(String login, String password) {
        User newUser= new User(login,password,"user");
        User_dup newUserDump = new User_dup(login,"user");

        String hql="select max(m.member_id) from Member m";
        Query query =sessionFactory.getCurrentSession().createQuery(hql);
        String maxId= (String) query.uniqueResult();

        System.out.println(maxId);

        maxId=maxId.substring(1);
        int num=Integer.parseInt(maxId);

        System.out.println(num);

        num+=1;
        DecimalFormat df=new DecimalFormat("000000");
        String str2=df.format(num);

        String member_id="m"+str2;

        Member member = new Member(member_id,login);
        //打开Session
        Session session = sessionFactory.openSession();

        //开启事务
        Transaction tx = session.beginTransaction();
        session.save(newUser);
        session.save(newUserDump);
        session.save(member);
        //提交事务
        tx.commit();
        //关闭Session
        session.close();
        return newUserDump;
    }

    @Override
    public User_dup getUser(String login) {
        String hql="from User_dup where login=?";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setString(0,login);
        return (User_dup) query.uniqueResult();
    }

}
