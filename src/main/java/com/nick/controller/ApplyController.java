package com.nick.controller;

import com.nick.bean.Apply;
import com.nick.bean.Member;
import com.nick.bean.User_dup;
import com.nick.service.ApplyService;
import com.nick.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by nick on 2017/3/12.
 */
@Controller
public class ApplyController {
    @Autowired
    private ApplyService applyService;
    @Autowired
    private MemberService memberService;

    @ResponseBody
    @RequestMapping(value = "/apply", method = RequestMethod.GET)
    public ModelAndView apply(HttpSession session) {
        ModelAndView mv= new ModelAndView();

        User_dup user = (User_dup)session.getAttribute("user");

        if(user==null){
            return new ModelAndView("redirect:/personal");
        }else{
            if(user.getType().equals("member")){
                mv.setViewName("apply");
                boolean applying = applyService.findApply(user.getLogin());
                if(applying){
                    mv.addObject("applying","true");
                    mv.addObject("message","申请中请等待经理审批");
                }
            }else {
                return new ModelAndView("redirect:/personal");
            }
        }


        return mv;
    }

    @ResponseBody
    @RequestMapping(value = "/apply", method = RequestMethod.POST)
    public ModelAndView registerHostel(HttpServletRequest request,HttpSession session) {
        String hostel = request.getParameter("hostel");
        String address = request.getParameter("address");
        String description = request.getParameter("description");
        String account = request.getParameter("account");
        String password = request.getParameter("password");

        ModelAndView mv= new ModelAndView();

        User_dup user = (User_dup) session.getAttribute("user");
        if(user==null||!user.getType().equals("member")){
            return new ModelAndView("redirect:/personal");
        }else{
            Member member = memberService.getMemberByLogin(user.getLogin());

            applyService.createApply(hostel,address,description,member.getMember_id(),user.getLogin(),account,password);


            mv.setViewName("apply");
            mv.addObject("message","申请中请等待经理审批");
            mv.addObject("applying","true");
        }


        return mv;
    }

}
