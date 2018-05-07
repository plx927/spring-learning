package com.panlingxiao.spring.schedule;


import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Slf4j
public class ScheduleService {

    @Scheduled(fixedRate = 1000)
    public void fixReportTime() {
        log.info("Now:{}", new Date());
    }
}
