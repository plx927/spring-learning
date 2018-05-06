package com.panlingxiao.spring.aop.aspect;

import com.panlingxiao.spring.aop.annotation.LogAction;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

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

    /**
     * 拦截特定方法,拦截DemoMethodService中add方法，并且参数的第一个类型必须为String
     */
    @Before("execution(* com.panlingxiao.spring.aop.service.DemoMethodService.add(String,..))")
    public void beforeAdvice(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        log.info("方法式拦截：method:{}", method);
    }


}
