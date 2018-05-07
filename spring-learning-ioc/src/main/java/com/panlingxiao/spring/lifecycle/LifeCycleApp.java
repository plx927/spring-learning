package com.panlingxiao.spring.lifecycle;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class LifeCycleApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(LifeCycleConfig.class);
        ctx.refresh();
        ctx.close();
    }
}
