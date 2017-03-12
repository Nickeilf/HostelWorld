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
}
