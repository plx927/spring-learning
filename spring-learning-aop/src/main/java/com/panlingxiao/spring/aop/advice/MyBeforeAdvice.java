package com.panlingxiao.spring.aop.advice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

@Slf4j
public class MyBeforeAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        log.info("before method invoke,method:{}", method);
    }
}
