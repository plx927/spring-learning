package com.panlingxiao.spring.event;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class EventApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(EventConfig.class);
        ctx.refresh();
        DemoPublisher demoPublisher = ctx.getBean("demoPublisher", DemoPublisher.class);
        demoPublisher.publish("hello world!");

    }
}
