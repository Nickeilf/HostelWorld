package com.nick.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by nick on 2017/3/13.
 */
@Controller
public class PayController {

    @ResponseBody
    @RequestMapping("/pay")
    public ModelAndView pay(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("pay");
        return mv;
    }

    @ResponseBody
    @RequestMapping(value = "/buy",method = RequestMethod.POST)
    public ModelAndView buy(HttpSession session, HttpServletRequest request){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("pay");
        return mv;
    }
}
