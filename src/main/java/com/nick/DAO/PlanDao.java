package com.nick.DAO;

import com.nick.bean.Plan;

import java.sql.Date;
import java.util.List;

/**
 * Created by nick on 2017/3/13.
 */
public interface PlanDao {
    public Plan getPlan(int id);

    public List<Plan> getCurrentPlans(int page, Date checkin, Date checkout, int human);
    public List<Plan> getCurrentPlans(int page,String location,Date checkin,Date checkout,int human);
    public List<Plan> getCurrentPlans(int page,int human);
}
