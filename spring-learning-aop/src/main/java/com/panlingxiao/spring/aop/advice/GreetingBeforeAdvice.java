package com.panlingxiao.spring.aop.advice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Created by panlingxiao on 2018/6/9.
 */
@Slf4j
public class GreetingBeforeAdvice implements MethodBeforeAdvice {

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        log.info("How are you!Mr.{}!", args[0]);
    }
}
