package com.panlingxiao.spring.aop.aspect;

import com.panlingxiao.spring.aop.annotation.LogAction;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class LogAspect {

    /**
     * 定义注解的PointCut
     */
    @Pointcut("@annotation(com.panlingxiao.spring.aop.annotation.LogAction)")
    public void annotationPointCut() {
    }



    @After("annotationPointCut()")
    public void afterAdvice(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        LogAction logAction = methodSignature.getMethod().getAnnotation(LogAction.class);
        String name = logAction.name();
        log.info("注解式拦截:{}", name);
    }



}
