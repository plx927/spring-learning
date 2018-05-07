package com.panlingxiao.spring.composite;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@MyConfiguration(values = "com.panlingxiao.spring.composite")
public class CompositeApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(CompositeApp.class);
        ctx.refresh();
        ConfigService configService = ctx.getBean("configService", ConfigService.class);
        configService.say();

    }
}
