package com.nick.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by nick on 2017/3/13.
 */
@Controller
public class ManagerController {
    @ResponseBody
    @RequestMapping(value = "/manage/approve", method = RequestMethod.GET)
    public ModelAndView approve() {
        ModelAndView mv= new ModelAndView();
        mv.setViewName("manage-approve");
        return mv;
    }

    @ResponseBody
    @RequestMapping(value = "/manage/check", method = RequestMethod.GET)
    public ModelAndView check() {
        ModelAndView mv= new ModelAndView();
        mv.setViewName("manage-check");
        return mv;
    }

    @ResponseBody
    @RequestMapping(value = "/manage/info", method = RequestMethod.GET)
    public ModelAndView info() {
        ModelAndView mv= new ModelAndView();
        mv.setViewName("manage-info");
        return mv;
    }


}
