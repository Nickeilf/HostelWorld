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

}
