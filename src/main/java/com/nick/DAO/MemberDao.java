package com.nick.DAO;

import com.nick.bean.Member;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by nick on 2017/3/10.
 */

public interface MemberDao {
    public List<Member> getAllMembers();

    public Member getMember(String id);

    public Member getMemberByLogin(String login);

    public void updateCredit(Member member,int amount,String cardOrCash);

    public void cancel(String login);

    public void updateInfo(String name,String phone,String email,String login);

    public void transfer(int num,String login);

    public void moneyBack(String login, int amount);

    public void updateSuspendAndCancelMember();

}
