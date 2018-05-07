package com.panlingxiao.spring.profile;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ProfileApp {

    private static final String ENV = "dev";

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        // 必须先设置环境，然后才能刷新容器
        ctx.getEnvironment().setActiveProfiles(ENV);
        ctx.register(ProfileConfig.class);
        ctx.refresh();
        ctx.getBean(ENV, DemoBean.class);
    }
}
