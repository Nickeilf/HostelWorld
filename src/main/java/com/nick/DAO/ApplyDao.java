package com.nick.DAO;

import com.nick.bean.Apply;

import java.util.List;

/**
 * Created by nick on 2017/3/18.
 */
public interface ApplyDao {

    public int getMaxId();

    public void addApply(Apply apply);

    public boolean findApply(String login);

    public boolean findModify(String login);

    public List<Apply> getAllCheckingApply();

    public void approveApply(String id);
    public void denyApply(String id);

}
