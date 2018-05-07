package com.panlingxiao.spring.schedule;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ScheduleApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(ScheduleConfig.class);
        ctx.refresh();
    }
}
