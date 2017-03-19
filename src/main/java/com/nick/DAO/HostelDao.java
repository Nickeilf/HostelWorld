package com.nick.DAO;

import com.nick.bean.Hostel;

import java.util.List;

/**
 * Created by nick on 2017/3/13.
 */
public interface HostelDao {
    public Hostel getHostel(String id);

    public String getMaxId();

    public void createHostel(Hostel hostel);

    public Hostel getHostelByLogin(String hostel);

    public void updateInfo(String name,String address,String description,String login);
}
