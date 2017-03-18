package com.nick.controller;

import com.nick.bean.Member;
import com.nick.bean.Orders;
import com.nick.bean.Plan;
import com.nick.bean.User_dup;
import com.nick.service.OrderService;
import com.nick.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.nick.service.MemberService;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by nick on 2017/3/10.
 */

@Controller
public class MemberController {

    @Autowired
    private MemberService memberService;

    @Autowired
    private PlanService planService;

    @Autowired
    private OrderService orderService;

    public MemberService getMemberService() {
        return memberService;
    }
    public void setMemberService(MemberService memberService) {
        this.memberService = memberService;
    }

    @ResponseBody
    @RequestMapping("/personal")
    public ModelAndView personal(HttpSession session){
        ModelAndView mv = new ModelAndView();

        User_dup user_dup = (User_dup) session.getAttribute("user");
        if(user_dup==null){
            mv.setViewName("login");
            mv.addObject("message","请先登录");
        }else{
            mv.setViewName("personal");
            Member member = memberService.getMemberByLogin(user_dup.getLogin());
            mv.addObject("member",member);
            if(user_dup.getType().equals("user")){
                mv.addObject("message","请充值至1000元以上以激活成为会员");
            }else if(user_dup.getType().equals("hostel")||user_dup.getType().equals("member")){
                //查数据库找会员信息
                List<Orders> wait = orderService.getWaitOrder(user_dup.getLogin());
                List<Orders> finish = orderService.getFinishOrder(user_dup.getLogin());
                List<Orders> cancel = orderService.getCancelOrder(user_dup.getLogin());


                mv.addObject("wait",wait);
                mv.addObject("finish",finish);
                mv.addObject("cancel",cancel);
            }else{
                //经理
                mv.setViewName("manage-approve");
            }
        }
        return mv;
    }

    @ResponseBody
    @RequestMapping(value = "cancel")
    public ModelAndView cancel(HttpSession session){
        User_dup user_dup = (User_dup) session.getAttribute("user");

        memberService.cancel(user_dup.getLogin());

        return new ModelAndView("redirect:/personal");
    }

    @ResponseBody
    @RequestMapping(value = "changeinfo",method = RequestMethod.POST)
    public ModelAndView changeInfo(HttpSession session, HttpServletRequest request){
        String name = request.getParameter("nickname");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");

        User_dup user_dup = (User_dup) session.getAttribute("user");

        memberService.updateInfo(name,phone,email,user_dup.getLogin());


        return  new ModelAndView("redirect:personal");
    }

    @ResponseBody
    @RequestMapping(value = "trans",method = RequestMethod.POST)
    public ModelAndView trans(HttpSession session, HttpServletRequest request){
        String number = request.getParameter("point2balance");

        User_dup user_dup= (User_dup) session.getAttribute("user");

        int tran = Integer.parseInt(number);

        memberService.transfer(tran,user_dup.getLogin());


        return  new ModelAndView("redirect:personal");
    }

    @ResponseBody
    @RequestMapping(value = "/cancelorder",method = RequestMethod.POST)
    public ModelAndView cancel(HttpSession session, HttpServletRequest request){
        String order_id=request.getParameter("order_id");
        String login=request.getParameter("login");
        String amount=request.getParameter("amount");
        String type=request.getParameter("card");

        orderService.cancelOrder(order_id);
        if(type.equals("card")){
            memberService.moneyBack(login,amount);
        }


        return  new ModelAndView("redirect:personal");
    }




}
