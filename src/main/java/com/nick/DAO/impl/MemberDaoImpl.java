package com.nick.DAO.impl;

import com.nick.DAO.MemberDao;
import com.nick.DAO.impl.*;
import com.nick.bean.Member;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by nick on 2017/3/10.
 */
@Repository
public class MemberDaoImpl extends BaseDaoImpl implements MemberDao {

    @Override
    public List<Member> getAllMembers() {
        String hql = "from Member";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        return query.list();
    }

    @Override
    public Member getMember(String id) {
        String hql = "from Member where member_id=?";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setString(0,id);
        return (Member)query.uniqueResult();
    }

    @Override
    public Member getMemberByLogin(String login) {
        String hql = "from Member where login=?";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setString(0,login);
        return (Member)query.uniqueResult();
    }

    @Override
    public void updateCredit(Member member, int amount,String cardOrCash) {
        String hql ="update Member m set m.balance=?,m.last_pay=?,m.point=?,m.level=?,m.state=?where m.id=?";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);

        if(cardOrCash.equals("card")) {
            query.setInteger(0, member.getBalance() - amount);
        }else{
            query.setInteger(0,member.getBalance());
        }
        java.util.Date a = new java.util.Date();
        query.setDate(1,new Date(a.getTime()));
        query.setInteger(2,member.getPoint()+amount);
        int level = member.getLevel();

        if(Math.log10(amount)>level){
            level= (int) (Math.log10(amount)+1);
        }

        query.setInteger(3,level);
        query.setString(4,"use");
        query.setString(5,member.getMember_id());


        query.executeUpdate();
    }

    @Override
    public void cancel(String login) {
        String hql ="update Member m set m.state=?where m.login=?";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setString(0,"cancel");
        query.setString(1,login);
        query.executeUpdate();

    }

    @Override
    public void updateInfo(String name, String phone, String email,String login) {
        String hql ="update Member m set m.name=? ,m.phone=?,m.email=? where m.login=?";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setString(0,name);
        query.setString(1,phone);
        query.setString(2,email);
        query.setString(3,login);
        query.executeUpdate();
    }

    @Override
    public void transfer(int num, String login) {
        int balanceAdd=num/20;
        String hql="update Member m set m.point=m.point-?,m.balance=m.balance+?where login=?";
        Query query=sessionFactory.getCurrentSession().createQuery(hql);

        query.setInteger(0,num);
        query.setInteger(1,balanceAdd);
        query.setString(2,login);
        query.executeUpdate();

    }

    @Override
    public void moneyBack(String login, int amount) {
        String hql="update Member m set m.balance=m.balance+? where login=?";
        Query query=sessionFactory.getCurrentSession().createQuery(hql);
        query.setInteger(0,amount);
        query.setString(1,login);
        query.executeUpdate();
    }

    //查找1年和2年的分别更新
    @Override
    public void updateSuspendAndCancelMember() {
        Timestamp createTime = new Timestamp(new java.util.Date().getTime());
        String update="update Member m set m.state='suspend' where DATEDIFF(DATE(?),DATE(m.last_pay))>=365";
        Query query=sessionFactory.getCurrentSession().createQuery(update);
        query.setTimestamp(0,createTime);
        query.executeUpdate();

        update="update Member m set m.state='cancel' where DATEDIFF(DATE(?),DATE(m.last_pay))>=730";
        query=sessionFactory.getCurrentSession().createQuery(update);
        query.setTimestamp(0,createTime);
        query.executeUpdate();
    }


}
