package com.nick.service;

import com.nick.bean.Member;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by nick on 2017/3/10.
 */

public interface MemberService {

    public List<Member> getAllMembers();
}