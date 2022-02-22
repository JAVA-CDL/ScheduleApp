package com.luke.hot_list.schedule;

import com.luke.hot_list.service.JueJinService;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author Administrator
 */
@Component
@EnableScheduling
public class JueJinSchedule {

    @Resource
    JueJinService jueJinService;

    @Scheduled(cron = "0 5 8 * * ?")
    public void jueJinCheckIn() {
        jueJinService.checkIn();
    }
}
