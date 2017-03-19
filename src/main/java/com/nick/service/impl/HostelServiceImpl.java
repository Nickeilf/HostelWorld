package com.nick.service.impl;

import com.nick.DAO.HostelDao;
import com.nick.bean.Hostel;
import com.nick.service.HostelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by nick on 2017/3/13.
 */
@Service
public class HostelServiceImpl implements HostelService {
    @Autowired
    private HostelDao hostelDao;


    @Override
    public Hostel getHostel(String id) {
        return hostelDao.getHostel(id);
    }

    @Override
    public String getMaxId() {
        return hostelDao.getMaxId();
    }

    @Override
    public void createHostel(Hostel hostel) {
        hostelDao.createHostel(hostel);
    }

    @Override
    public Hostel getHostelBylogin(String login) {
        return hostelDao.getHostelByLogin(login);
    }

    @Override
    public void updateInfo(String name, String address, String description, String login) {
        hostelDao.updateInfo(name,address,description,login);
    }
}
