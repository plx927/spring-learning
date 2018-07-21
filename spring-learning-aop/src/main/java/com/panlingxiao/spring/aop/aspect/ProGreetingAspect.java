package com.panlingxiao.spring.aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * Created by panlingxiao on 2018/7/21.
 */
@Aspect
@Slf4j
public class ProGreetingAspect {

    @Before("execution(* greetTo(..)) && args(name)")
    public void beforeGreeting(String name) {
        log.info("How are you!Mr {}", name);
    }
}
