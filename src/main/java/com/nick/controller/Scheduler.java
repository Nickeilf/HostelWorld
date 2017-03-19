package com.nick.controller;

import com.nick.DAO.MemberDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by nick on 2017/3/20.
 */
@Component
public class Scheduler {
    @Autowired
    private MemberDao memberDao;

        @Scheduled(cron="0 0 2 * * ?")
        void doSomethingWith(){
            //查找1年和2年的分别更新
            memberDao.updateSuspendAndCancelMember();
        }
}
