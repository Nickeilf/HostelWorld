package com.nick.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
}
