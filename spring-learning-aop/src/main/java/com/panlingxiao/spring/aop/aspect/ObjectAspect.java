package com.panlingxiao.spring.aop.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ObjectAspect {

    /**
     * 针对实现了Logable接口的所有类中的方法
     */
    @Pointcut("target(com.panlingxiao.spring.aop.log.Logable)")
    public void targetMatch() {
    }

    /**
     * 切点针对实现了Logable接口的所有类的方法
     */
    @Pointcut("target(com.panlingxiao.spring.aop.log.Logable)")
    public void thisMatch() {

    }

    /**
     * Spring独有的支持，可以支持根据Bean的Id或者名字设置切入点
     */
    @Pointcut("bean(categoryService)")
    public void beanMatch() {
    }


    @Before("targetMatch()")
    public void beforeAdvice() {
        System.out.println("#before log#");
    }

    @After("beanMatch()")
    public void afterAdvice() {
        System.out.println("#after log#");
    }


}
