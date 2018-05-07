package com.panlingxiao.spring.schedule;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@ComponentScan(basePackages = "com.panlingxiao.spring.schedule")
@Configuration
@EnableScheduling
public class ScheduleConfig {

}
