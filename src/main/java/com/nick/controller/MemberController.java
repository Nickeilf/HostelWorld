package com.nick.controller;

import com.nick.bean.Member;
import com.nick.bean.User_dup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.nick.service.MemberService;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by nick on 2017/3/10.
 */

@Controller
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
    @RequestMapping("/personal")
    public ModelAndView personal(HttpSession session){
        ModelAndView mv = new ModelAndView();

        User_dup user_dup = (User_dup) session.getAttribute("user");
        if(user_dup==null){
            mv.setViewName("login");
            mv.addObject("message","请先登录");
        }else{
            mv.setViewName("personal");
            Member member = memberService.getMemberByLogin(user_dup.getLogin());
            mv.addObject("member",member);
            if(user_dup.getType().equals("user")){
                mv.addObject("message","请充值至1000元以上以激活成为会员");
            }else if(user_dup.getType().equals("hostel")||user_dup.getType().equals("member")){
                //查数据库找信息


            }else{
                mv.setViewName("manage-approve");
            }
        }



        return mv;
    }


}
