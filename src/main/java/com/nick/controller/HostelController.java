package com.nick.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by nick on 2017/3/11.
 */
@Controller
public class HostelController {


    @ResponseBody
    @RequestMapping(value = "/hostel", method = RequestMethod.GET)
    public ModelAndView register() {
        ModelAndView mv= new ModelAndView();
        mv.setViewName("hostel");
        return mv;
    }

    @ResponseBody
    @RequestMapping(value = "/hostel/modify", method = RequestMethod.GET)
    public ModelAndView modify() {
        ModelAndView mv= new ModelAndView();
        mv.setViewName("hostel-modify");
        return mv;
    }

    @ResponseBody
    @RequestMapping(value = "/hostel/plan", method = RequestMethod.GET)
    public ModelAndView plan() {
        ModelAndView mv= new ModelAndView();
        mv.setViewName("hostel-plan");
        return mv;
    }

    @ResponseBody
    @RequestMapping(value = "/hostel/register", method = RequestMethod.GET)
    public ModelAndView register_man() {
        ModelAndView mv= new ModelAndView();
        mv.setViewName("hostel-register");
        return mv;
    }

    @ResponseBody
    @RequestMapping(value = "/hostel/info", method = RequestMethod.GET)
    public ModelAndView info() {
        ModelAndView mv= new ModelAndView();
        mv.setViewName("hostel-info");
        return mv;
    }


    @ResponseBody
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public ModelAndView test() {
        ModelAndView mv= new ModelAndView();
        mv.setViewName("singlehostel");
        return mv;
    }
}
