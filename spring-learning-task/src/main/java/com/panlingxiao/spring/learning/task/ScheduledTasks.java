package com.panlingxiao.spring.learning.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by panlingxiao on 2016/10/20.
 */
@Component
public class ScheduledTasks {

    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    private static final SimpleDateFormat dateFormat2 = new SimpleDateFormat("hh:mm:ss");


    //每个5秒调用一次
    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        log.info("The time is now {}", dateFormat.format(new Date()));
    }

    /**
     * 每间隔10秒调用一次
     */
    @Scheduled(cron = "0/10 * * * * ?")
    public void cronJob(){
        log.info("CronJob print:the time is now {}",dateFormat2.format(new Date()));
    }



}
