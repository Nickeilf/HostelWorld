package com.nick.controller;

import com.nick.bean.*;
import com.nick.service.ApplyService;
import com.nick.service.HostelService;
import com.nick.service.MemberService;
import com.nick.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nick on 2017/3/11.
 */
@Controller
public class HostelController {
    @Autowired
    private PlanService planService;
    @Autowired
    private HostelService hostelService;
    @Autowired
    private MemberService memberService;
    @Autowired
    private ApplyService applyService;

    //搜索页
    @ResponseBody
    @RequestMapping(value = "/hostel",method = RequestMethod.POST)
    public ModelAndView allhostel(HttpServletRequest request, HttpServletResponse response, @RequestParam("checkin")Date checkin,@RequestParam("checkout")Date checkout) {
        String page =request.getParameter("page");
        String location=request.getParameter("location");
        String human = request.getParameter("human");

        List<Plan> currentPlans = planService.getCurrentPlans(page,location,checkin,checkout,human);


        //返回
        ModelAndView mv= new ModelAndView();
        mv.setViewName("hostel");
        mv.addObject("plans",currentPlans);
        mv.addObject("human",human);
        mv.addObject("checkin",checkin);
        mv.addObject("checkout",checkout);
        mv.addObject("location",location);
        return mv;
    }

    @ResponseBody
    @RequestMapping(value = "/hostel",method = RequestMethod.GET)
    public ModelAndView getAllhostel(HttpServletRequest request, HttpServletResponse response) {
        String page =request.getParameter("page");
        String human = request.getParameter("human");

        List<Plan> currentPlans = planService.getCurrentPlans(page,human);

        int pageNum=1;
        if(page!=null){
            pageNum=Integer.parseInt(page);
        }

        //返回
        ModelAndView mv= new ModelAndView();
        mv.setViewName("hostel");
        mv.addObject("plans",currentPlans);
        mv.addObject("pageNum",pageNum);
        mv.addObject("human",human);
        return mv;
    }

    //修改信息
    @ResponseBody
    @RequestMapping(value = "/hostel/modify", method = RequestMethod.GET)
    public ModelAndView modify(HttpSession session) {
        ModelAndView mv= new ModelAndView();

        User_dup user_dup= (User_dup) session.getAttribute("user");
        if(user_dup==null||!user_dup.getType().equals("hostel")){
            return  new ModelAndView("redirect:/personal");
        }else{
            Hostel hostel=hostelService.getHostelBylogin(user_dup.getLogin());

            //寻找数据库现有的尚未审批的apply
            boolean apply = applyService.findModify(user_dup.getLogin());
            if(apply){
                mv.addObject("message","已提交等待经理审批");
                mv.addObject("applying","true");
            }

            mv.addObject("hostel",hostel);
        }
        mv.setViewName("hostel-modify");
        return mv;
    }

    //修改信息
    @ResponseBody
    @RequestMapping(value = "/hostel/modify", method = RequestMethod.POST)
    public ModelAndView modifyApply(HttpSession session,HttpServletRequest request) {
        String hostel_name =request.getParameter("hostel");
        String address=request.getParameter("address");
        String description=request.getParameter("description");

        ModelAndView mv= new ModelAndView();

        User_dup user_dup= (User_dup) session.getAttribute("user");
        if(user_dup==null||!user_dup.getType().equals("hostel")){
            return  new ModelAndView("redirect:/personal");
        }else{
            Hostel hostel=hostelService.getHostelBylogin(user_dup.getLogin());
            //添加Apply
            Member member = memberService.getMemberByLogin(user_dup.getLogin());

            applyService.createModifyApply(hostel_name,address,description,member.getMember_id(),user_dup.getLogin());

            //message
            mv.addObject("message","已提交请等待审批");
            mv.addObject("applying","true");
            mv.addObject("hostel",hostel);
        }
        mv.setViewName("hostel-modify");
        return mv;
    }

    //发布计划
    @ResponseBody
    @RequestMapping(value = "/hostel/plan", method = RequestMethod.GET)
    public ModelAndView plan(HttpSession session) {
        ModelAndView mv= new ModelAndView();

        User_dup user_dup= (User_dup) session.getAttribute("user");
        if(user_dup==null||!user_dup.getType().equals("hostel")){
            return  new ModelAndView("redirect:/personal");
        }else{
            Hostel hostel=hostelService.getHostelBylogin(user_dup.getLogin());

            List<Plan> plans = planService.getRelatedPlan(hostel.getHostel_id());

            mv.addObject("hostel",hostel);
            mv.addObject("plan",plans);
        }

        mv.setViewName("hostel-plan");
        return mv;
    }

    //房客登记
    @ResponseBody
    @RequestMapping(value = "/hostel/register", method = RequestMethod.GET)
    public ModelAndView register_man(HttpSession session) {
        ModelAndView mv= new ModelAndView();

        User_dup user_dup= (User_dup) session.getAttribute("user");
        if(user_dup==null||!user_dup.getType().equals("hostel")){
            return  new ModelAndView("redirect:/personal");
        }else{
            Hostel hostel=hostelService.getHostelBylogin(user_dup.getLogin());

            mv.addObject("hostel",hostel);
        }


        mv.setViewName("hostel-register");
        return mv;
    }

    //房客入住等级
    @ResponseBody
    @RequestMapping(value = "/hostel/registerin", method = RequestMethod.POST)
    public ModelAndView register_in(HttpServletRequest request) {
        String hostel_id = request.getParameter("hostel_id");
        String names=request.getParameter("names");
        String humans=request.getParameter("humans");
        String order_id=request.getParameter("order_id");
        String type = request.getParameter("type");//现金OrCard
        String isMember=request.getParameter("card");

        if(isMember.equals("on")){
            isMember="yes";
        }else{
            isMember="no";
        }
        if(type.equals("1")){
            type="card";
        }else{
            type="cash";
        }


        System.out.println(humans);

        //新建register
        hostelService.createRegister(hostel_id,names,humans,order_id,type,isMember);
        return new ModelAndView("redirect:/hostel/register");
    }

    //房客登记
    @ResponseBody
    @RequestMapping(value = "/hostel/checkout", method = RequestMethod.POST)
    public ModelAndView checkout(HttpSession session,HttpServletRequest request) {
        String register_id = request.getParameter("registerid");

        User_dup user_dup= (User_dup) session.getAttribute("user");
        if(user_dup==null||!user_dup.getType().equals("hostel")){
            return  new ModelAndView("redirect:/personal");
        }else{
            hostelService.updateRegister(register_id);
        }
        return new ModelAndView("redirect:/hostel/register");
    }

    //信息统计
    @ResponseBody
    @RequestMapping(value = "/hostel/info", method = RequestMethod.GET)
    public ModelAndView info(HttpSession session) {
        ModelAndView mv= new ModelAndView();

        User_dup user_dup= (User_dup) session.getAttribute("user");
        if(user_dup==null||!user_dup.getType().equals("hostel")){
            return  new ModelAndView("redirect:/personal");
        }else{
            Hostel hostel=hostelService.getHostelBylogin(user_dup.getLogin());

            List<Orders> orderses = hostelService.getRelatedOrders(hostel.getHostel_id());
            List<Register> registers=hostelService.getRelatedRegister(hostel.getHostel_id());
            List<Trade> trades = hostelService.getRelatedTrade(hostel.getHostel_id());

            mv.addObject("trade",trades);
            mv.addObject("registers",registers);
            mv.addObject("orders",orderses);
            mv.addObject("hostel",hostel);
        }

        mv.setViewName("hostel-info");
        return mv;
    }


    //查看详情
    @ResponseBody
    @RequestMapping(value = "/singleHostel", method = RequestMethod.GET)
    public ModelAndView test(HttpServletRequest request, HttpServletResponse response) {
        int plan_id = Integer.parseInt(request.getParameter("id"));
        Plan plan = planService.getPlan(plan_id);
        Hostel hostel = hostelService.getHostel(plan.getHostel_id());
        Member member = memberService.getMember(hostel.getMember_id());

        List<Plan> related = planService.getRelatedPlan(hostel.getHostel_id());


        ModelAndView mv= new ModelAndView();
        mv.setViewName("singlehostel");
        mv.addObject("plan",plan);
        mv.addObject("related",related);
        mv.addObject("hostel",hostel);
        mv.addObject("member",member);
        return mv;
    }

    @ResponseBody
    @RequestMapping(value = "/hostel/newplan", method = RequestMethod.POST)
    public ModelAndView createPlan(HttpServletRequest request,HttpSession session,@RequestParam("fromdate")Date fromdate,@RequestParam("todate")Date todate){
        String room = request.getParameter("room");
        String price = request.getParameter("price");
        String humans =request.getParameter("humans");
        String beds = request.getParameter("beds");
        String description = request.getParameter("description");

        User_dup user_dup= (User_dup) session.getAttribute("user");
        if(user_dup==null||!user_dup.getType().equals("hostel")){
            return  new ModelAndView("redirect:/personal");
        }else{
            Hostel hostel=hostelService.getHostelBylogin(user_dup.getLogin());

            int plan_price = Integer.parseInt(price);
            int human = Integer.parseInt(humans);
            int bed = Integer.parseInt(beds);

            planService.createPlan(fromdate,todate,room,plan_price,human,bed,hostel.getHostel_id(),description);

        }


        return new ModelAndView("redirect:/hostel/plan");
    }


}
