package com.panlingxiao.spring.aop.advice;

import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;

/**
 * Created by panlingxiao on 2018/6/25.
 */
public class SingerThrowsAdvice implements ThrowsAdvice {

    public void afterThrowing(Method method, Object[] args, Object target, Throwable throwable) {
        System.out.println("cause exception:method " + method + ",exception:" + throwable);
    }
}
