package com.nick.controller;

import com.nick.bean.Apply;
import com.nick.bean.Hostel;
import com.nick.bean.Manager;
import com.nick.bean.User_dup;
import com.nick.service.ApplyService;
import com.nick.service.HostelService;
import com.nick.service.ManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by nick on 2017/3/13.
 */
@Controller
public class ManagerController {
    @Autowired
    private ManageService manageService;
    @Autowired
    private HostelService hostelService;
    @Autowired
    private ApplyService applyService;

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
    public ModelAndView check(HttpSession session) {
        ModelAndView mv= new ModelAndView();

        User_dup user_dup = (User_dup) session.getAttribute("user");
        if(user_dup==null||!user_dup.getType().equals("manager")){
            return  new ModelAndView("redirect:/personal");
        }else{
            Manager manager = manageService.getManager();

            mv.addObject("manager",manager);
            mv.setViewName("manage-check");
        }


        return mv;
    }

    @ResponseBody
    @RequestMapping(value = "/manage/info", method = RequestMethod.GET)
    public ModelAndView info() {
        ModelAndView mv= new ModelAndView();
        mv.setViewName("manage-info");
        return mv;
    }

    @ResponseBody
    @RequestMapping(value = "/manage/approveHostel", method = RequestMethod.POST)
    public ModelAndView approveHostel(HttpServletRequest request) {
        String hostel_name = request.getParameter("hostel_name");
        String address = request.getParameter("address");
        String description =request.getParameter("description");
        String member_id = request.getParameter("member_id");
        String login = request.getParameter("login");
        String apply_id=request.getParameter("apply_id");
        String type = request.getParameter("type");

        if(type.equals("apply")){
            //新建Hostel
            Hostel hostel = new Hostel(1000,hostelService.getMaxId(),hostel_name,address,description,member_id,login);
            hostelService.createHostel(hostel);
            //更改Apply状态
            applyService.approveApply(apply_id);
            //更改拥有者用户状态
            manageService.user2hostelOwner(login);
        }else{
            //修改hostel
            hostelService.updateInfo(hostel_name,address,description,login);
            //更改apply状态
            applyService.approveApply(apply_id);
        }


        return new ModelAndView("redirect:/manage/approve");
    }

    @ResponseBody
    @RequestMapping(value = "/manage/deny", method = RequestMethod.POST)
    public ModelAndView deny(HttpServletRequest request) {
        String apply_id=request.getParameter("apply_id");

        applyService.denyApply(apply_id);


        return new ModelAndView("redirect:/manage/approve");
    }

}
