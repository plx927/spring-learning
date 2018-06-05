package com.panlingxiao.spring.aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
//@Aspect
@Slf4j
public class ArgsAspect {

    /**
     * 参数匹配,拦截所有第一个参数为String,第二个参数为Integer的方法
     */
    @Pointcut("args(java.lang.String,java.lang.Integer)")
    public void matchArg() {
    }

    @Before("matchArg()")
    public void beforeAdvice(JoinPoint joinPoint) {
        log.info("arg match,before advice");
    }
}
