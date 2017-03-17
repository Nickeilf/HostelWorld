package com.nick.controller;

import com.nick.bean.Hostel;
import com.nick.bean.Member;
import com.nick.bean.Plan;
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
    public ModelAndView modify() {
        ModelAndView mv= new ModelAndView();
        mv.setViewName("hostel-modify");
        return mv;
    }

    //发布计划
    @ResponseBody
    @RequestMapping(value = "/hostel/plan", method = RequestMethod.GET)
    public ModelAndView plan() {
        ModelAndView mv= new ModelAndView();
        mv.setViewName("hostel-plan");
        return mv;
    }

    //房客登记
    @ResponseBody
    @RequestMapping(value = "/hostel/register", method = RequestMethod.GET)
    public ModelAndView register_man() {
        ModelAndView mv= new ModelAndView();
        mv.setViewName("hostel-register");
        return mv;
    }

    //信息统计
    @ResponseBody
    @RequestMapping(value = "/hostel/info", method = RequestMethod.GET)
    public ModelAndView info() {
        ModelAndView mv= new ModelAndView();
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
}
