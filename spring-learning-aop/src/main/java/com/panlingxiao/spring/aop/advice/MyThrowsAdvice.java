package com.panlingxiao.spring.aop.advice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;

/**
 * ThrowsAdvice是一个标记性接口
 * Created by panlingxiao on 2018/6/9.
 */
@Slf4j
public class MyThrowsAdvice implements ThrowsAdvice {

    public void afterThrowing(Method method, Object[] args, Object target, Throwable throwable) {
        log.error("ThrowsAdvice invoked,method:{}", method, throwable);
    }
}
