package com.panlingxiao.spring;

import com.panlingxiao.spring.config.AppConfig;
import com.panlingxiao.spring.service.UseFunctionService;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        UseFunctionService useFunctionService = ctx.getBean("useFunctionService", UseFunctionService.class);

        String result = useFunctionService.sayHello("Spring");
        System.out.println(result);
        ctx.close();
    }
}
