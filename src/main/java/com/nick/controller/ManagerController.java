package com.nick.controller;

import com.nick.bean.Apply;
import com.nick.bean.Manager;
import com.nick.bean.User_dup;
import com.nick.service.ManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by nick on 2017/3/13.
 */
@Controller
public class ManagerController {
    @Autowired
    private ManageService manageService;

    @ResponseBody
    @RequestMapping(value = "/manage/approve", method = RequestMethod.GET)
    public ModelAndView approve(HttpSession session) {
        ModelAndView mv= new ModelAndView();

        User_dup user_dup = (User_dup) session.getAttribute("user");
        if(user_dup==null||!user_dup.getType().equals("manager")){
            return  new ModelAndView("redirect:/personal");
        }else{
            Manager manager = manageService.getManager();
            List<Apply> applies = manageService.getAllCheckingApply();
            mv.setViewName("manage-approve");
            mv.addObject("apply",applies);
            mv.addObject("manager",manager);
        }

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
