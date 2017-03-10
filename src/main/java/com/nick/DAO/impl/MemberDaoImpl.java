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


}
