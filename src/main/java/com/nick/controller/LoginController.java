package com.nick.controller;

import com.nick.bean.User;
import com.nick.bean.User_dup;
import com.nick.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by nick on 2017/3/11.
 */
@Controller
public class LoginController {
    @Autowired
    private LoginService loginService;

    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(HttpSession session) {
        ModelAndView mv= new ModelAndView();

        User_dup user = (User_dup) session.getAttribute("user");
        if(user!=null){
            return new ModelAndView("redirect:/personal");
        }else {
            mv.setViewName("login");
        }
        return mv;
    }

    @ResponseBody
    @RequestMapping(value = "/checkLogin", method = RequestMethod.POST)
    public ModelAndView checkLogin(HttpServletRequest request, HttpServletResponse response,HttpSession session) {
        String login=request.getParameter("login");
        String password=request.getParameter("password");

        ModelAndView mv= new ModelAndView();

        User_dup user = loginService.checkLogin(login,password);


        if(user!=null){
            session.setAttribute("user",user);

            if(user.getType().equals("manager")){
                return new ModelAndView("redirect:/manage/approve");
            }
            return new ModelAndView("redirect:/personal");
        }else{
            mv.setViewName("login");
            mv.addObject("message","登录失败，请重新登录");
        }
        return mv;
    }

    @ResponseBody
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ModelAndView logout(HttpSession session) {
        ModelAndView mv= new ModelAndView();
        session.setAttribute("user",null);
        mv.setViewName("login");
        return mv;
    }


    @ResponseBody
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView register(HttpSession session,HttpServletRequest request, HttpServletResponse response) {

        ModelAndView mv= new ModelAndView();
        User_dup user = (User_dup) session.getAttribute("user");
        if(user!=null){
//            mv.setViewName("personal");
            return new ModelAndView("redirect:/personal");
        }else {
            mv.setViewName("register");
        }

        return mv;
    }

    @ResponseBody
    @RequestMapping(value = "/checkRegister", method = RequestMethod.POST)
    public ModelAndView checkRegister(HttpSession session,HttpServletRequest request, HttpServletResponse response) {
        String login =request.getParameter("login");
        String password=request.getParameter("password");

//        session.setAttribute("user",null);

        ModelAndView mv= new ModelAndView();

        User_dup user = loginService.createUser(login,password);

        if(user==null){
            mv.setViewName("register");
            mv.addObject("message","用户名重复请重新设置");
        }else{
            session.setAttribute("user",user);
            return new ModelAndView("redirect:/personal");
        }



        return mv;
    }
}
