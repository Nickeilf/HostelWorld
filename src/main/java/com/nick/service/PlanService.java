package com.nick.service;

import com.nick.bean.Plan;

import java.sql.Date;
import java.util.List;

/**
 * Created by nick on 2017/3/13.
 */
public interface PlanService {
    public Plan getPlan(int id);

    public List<Plan> getCurrentPlans(String page1, String location1, Date checkin, Date checkout, String human1);

    public List<Plan> getCurrentPlans(String page1,String human1);


    public List<Plan> getRelatedPlan(String hostelid);

    public void createPlan(Date fromdate,Date todate,String room,int price,int people,int bed_num,String hostel_id,String plan_description);
}
