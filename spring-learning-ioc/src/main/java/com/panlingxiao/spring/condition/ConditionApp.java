package com.panlingxiao.spring.condition;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class ConditionApp {

    public static void main(String[] args) {
        System.setProperty("os.name", "Linux");
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(ConditionConfig.class);
        ctx.refresh();
        ListService listService = ctx.getBean(ListService.class);
        log.info("listService:{},env:{}", listService, ctx.getEnvironment().getProperty("os.name"));

    }
}
