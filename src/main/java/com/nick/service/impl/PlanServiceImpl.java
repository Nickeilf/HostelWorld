package com.nick.service.impl;

import com.nick.DAO.PlanDao;
import com.nick.bean.Plan;
import com.nick.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.List;

/**
 * Created by nick on 2017/3/13.
 */
@Service
public class PlanServiceImpl implements PlanService{
    @Autowired
    private PlanDao planDao;

    @Override
    public Plan getPlan(int id) {
        return planDao.getPlan(id);
    }

    @Override
    public List<Plan> getCurrentPlans(String page1,String location1,Date checkin,Date checkout,String human1) {
        //page
        int page=1;
        if(page1!=null&&page1.equals("")){
            page=Integer.parseInt(page1);
        }
        //human默认为1
        int human=1;
        if(human1!=null&&human1.equals("")){
            human=Integer.parseInt(human1);
        }
        //checkin默认今天
        //checkout默认明天
        //location没有调用另一个方法

        if(location1!=null&&location1!=""){
            return planDao.getCurrentPlans(page,location1,checkin,checkout,human);
        }else{
            return planDao.getCurrentPlans(page,checkin,checkout,human);
        }
    }

    @Override
    public List<Plan> getCurrentPlans(String page1,String human1) {
        int page=1;
        if(page1!=null&&page1.equals("")){
            page=Integer.parseInt(page1);
        }
        //human默认为1
        int human=1;
        if(human1!=null&&human1.equals("")){
            human=Integer.parseInt(human1);
        }
        return planDao.getCurrentPlans(page,human);
    }

    @Override
    public List<Plan> getRelatedPlan(String hostelid) {
        return planDao.getRelatedPlans(hostelid);
    }

}
