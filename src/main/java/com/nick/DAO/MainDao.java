package com.nick.DAO;

import com.nick.bean.Hostel;
import com.nick.bean.Plan;

import java.util.List;

/**
 * Created by nick on 2017/3/13.
 */
public interface MainDao {
    public List<Plan> getTopThree();
}
