package com.nick.controller;

import com.nick.bean.User_dup;
import com.nick.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.util.Calendar;

/**
 * Created by nick on 2017/3/13.
 */
@Controller
public class PayController {
    @Autowired
    private PayService payService;

    @ResponseBody
    @RequestMapping("/pay")
    public ModelAndView pay(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("pay");
        return mv;
    }

    @ResponseBody
    @RequestMapping(value = "/buy",method = RequestMethod.POST)
    public ModelAndView buy(HttpSession session, HttpServletRequest request, @RequestParam("fromdate")Date fromdate, @RequestParam("todate")Date todate){
        String human = request.getParameter("human");
        String iscard=request.getParameter("card");
        String hostel_id = request.getParameter("hostel_id");
        String plan_id = request.getParameter("plan_id");
        String price = request.getParameter("price");
        String hostel_name =request.getParameter("hostel_name");
        String plan_name =request.getParameter("plan_name");

        int minus = getMinus(fromdate,todate);


        ModelAndView mv = new ModelAndView();

        User_dup user = (User_dup) session.getAttribute("user");
        if(user==null||user.getType().equals("user")){

        }else if(user.getType().equals("member")){
            //下单
            payService.createOrder(human,price,minus,fromdate,todate,hostel_id,plan_id,iscard,user.getLogin(),hostel_name,plan_name);
        }

        return new ModelAndView("redirect:/personal");
    }

    @ResponseBody
    @RequestMapping(value = "/recharge",method = RequestMethod.POST)
    public ModelAndView recharge(HttpServletRequest request,HttpSession session){
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        String amount = request.getParameter("amount");

        ModelAndView mv = new ModelAndView();

        User_dup user = (User_dup) session.getAttribute("user");

        if(user ==null){
            mv.setViewName("login");
            mv.addObject("message","请先登录");
            return  mv;
        }else{
            boolean success=payService.recharge(account,password,amount,user.getLogin());
            if(success){
                return new ModelAndView("redirect:/personal");
            }else{
                mv.setViewName("pay");
                mv.addObject("message","银行卡密码错误");
            }
        }
        return mv;
    }

    private int getMinus(Date d1,Date d2){
        Calendar c = Calendar.getInstance();
        c.setTime(d1);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        long l1 = c.getTimeInMillis();
        c.setTime(d2);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        long l2 = c.getTimeInMillis();
        return (int) ((l2 - l1) / (1000 * 60 * 60 * 24));
    }


}
