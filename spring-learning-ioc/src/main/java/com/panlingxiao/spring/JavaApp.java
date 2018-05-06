package com.panlingxiao.spring;

import com.panlingxiao.spring.config.JavaConfig;
import com.panlingxiao.spring.service.FunctionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class JavaApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(JavaConfig.class);
        ctx.refresh();
        FunctionService functionService = ctx.getBean("functionService", FunctionService.class);
        String result = functionService.sayHello("Java Config");
        log.warn("result:{}", result);
        ctx.close();
    }
}
