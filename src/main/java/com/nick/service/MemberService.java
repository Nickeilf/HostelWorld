package com.nick.service;

import com.nick.bean.Member;
import com.nick.bean.Trade;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by nick on 2017/3/10.
 */

public interface MemberService {

    public List<Member> getAllMembers();

    public Member getMember(String id);

    public Member getMemberByLogin(String login);

    public void cancel(String login);

    public void updateInfo(String name,String phone,String email,String login);

    public void transfer(int points,String login);

    public void moneyBack(String login,String amount);

    public List<Trade> getRelatedTrade(String login);
}