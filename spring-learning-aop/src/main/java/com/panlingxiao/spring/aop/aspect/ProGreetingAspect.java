package com.panlingxiao.spring.aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInvocation;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.aop.interceptor.ExposeInvocationInterceptor;

import java.util.List;

/**
 * Created by panlingxiao on 2018/7/21.
 */
@Aspect
@Slf4j
public class ProGreetingAspect {

    @Before("execution(* greetTo(..)) && args(name)")
    public void beforeGreeting(String name) {
        log.info("How are you!Mr {}", name);
        /**
         *  Spring在根据切面构建Advisor的时候，会默认添加一个ExposeInvocationInterceptor到拦截器链中
         *  {@link org.springframework.aop.aspectj.AspectJProxyUtils#makeAdvisorChainAspectJCapableIfNecessary(List)}
         */
        MethodInvocation methodInvocation = ExposeInvocationInterceptor.currentInvocation();
        System.out.println(methodInvocation);
    }
}
