package com.nick.controller;

import com.nick.bean.User_dup;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * Created by nick on 2017/3/12.
 */
@Controller
public class ApplyController {
    @ResponseBody
    @RequestMapping(value = "/apply", method = RequestMethod.GET)
    public ModelAndView register(HttpSession session) {
        ModelAndView mv= new ModelAndView();

        User_dup user = (User_dup) session.getAttribute("user");
        if(user==null){
            mv.setViewName("login");
            mv.addObject("message","请先作为用户登录");
        }else{
            mv.setViewName("apply");
        }


        return mv;
    }

}
