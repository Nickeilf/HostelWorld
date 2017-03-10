package com.nick.controller;

import com.nick.bean.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.nick.service.MemberService;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by nick on 2017/3/10.
 */

@Controller
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private MemberService memberService;

    public MemberService getMemberService() {
        return memberService;
    }
    public void setMemberService(MemberService memberService) {
        this.memberService = memberService;
    }

    @ResponseBody
    @RequestMapping("/a")
    public String getAllMembers(){

        return memberService.getAllMembers().toString();
    }


}
