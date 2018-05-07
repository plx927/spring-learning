package com.panlingxiao.spring.aware;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AwareApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(AwareConfig.class);
        ctx.refresh();
        ctx.close();
    }
}
