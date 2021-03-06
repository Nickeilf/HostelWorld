package com.nick.DAO;

import com.nick.bean.*;

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

    public void createRegister(Register register);

    public int getMaxRegister();

    public void updateRegister(int id);

    public void checkMoney(String hostel_id,int money);

    public List<Register> getRelatedRegister(String hostel_id);

    public List<Trade> getRelatedTrade(String hostel_id);

    public List<Register> getAllRegister();

    public List<Object[]> getPie();
}
