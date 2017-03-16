package com.nick.controller;

import com.nick.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by nick on 2017/3/7.
 */

@Controller
public class MainController {
    @Autowired
    private MainService mainService;

    @ResponseBody
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView index() {
        ModelMap result = new ModelMap();
        result.put("top",mainService.getTop3());
        ModelAndView mv = new ModelAndView("index","result",result);
        return mv;
    }
}
