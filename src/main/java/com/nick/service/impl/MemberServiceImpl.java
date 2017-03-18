package com.nick.service.impl;

import com.nick.DAO.MemberDao;
import com.nick.DAO.impl.MemberDaoImpl;
import com.nick.bean.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nick.service.MemberService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by nick on 2017/3/10.
 */
@Service("memberService")
@Transactional
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberDao memberDao;
    public MemberDao getMemberDao() {
        return memberDao;
    }

    public void setMemberDao(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    @Override
    public List<Member> getAllMembers() {
        return memberDao.getAllMembers();
    }

    @Override
    public Member getMember(String id) {
        return memberDao.getMember(id);
    }

    @Override
    public Member getMemberByLogin(String login) {
        return memberDao.getMemberByLogin(login);
    }

    @Override
    public void cancel(String login) {
        memberDao.cancel(login);
    }

    @Override
    public void updateInfo(String name, String phone, String email,String login) {
        memberDao.updateInfo(name,phone,email,login);
    }

    @Override
    public void transfer(int points, String login) {
        memberDao.transfer(points,login);
    }

}
