package com.panlingxiao.spring.aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class AnnotationAspect {


    /**
     * 注解的拦截只能针对实现类有效，如果将注解添加到接口上，目标方法执行的时候并不会生效
     */
    @Pointcut("@annotation(com.panlingxiao.spring.aop.annotation.LogAction)")
    public void isLogAction() {

    }

    @Before("isLogAction()")
    public void beforeAdvice() {
        log.info("log sth");
    }
}
