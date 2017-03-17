package com.nick.DAO.impl;

import com.nick.DAO.MemberDao;
import com.nick.DAO.impl.*;
import com.nick.bean.Member;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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


}
