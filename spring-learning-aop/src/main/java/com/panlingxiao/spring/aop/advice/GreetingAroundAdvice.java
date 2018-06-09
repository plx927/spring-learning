package com.panlingxiao.spring.aop.advice;

import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * Created by panlingxiao on 2018/6/9.
 */
@Slf4j
public class GreetingAroundAdvice implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        Object[] arguments = invocation.getArguments();
        log.info("Hello,{}!", arguments[0]);
        Object result = invocation.proceed();
        log.info("Bye,{}!", arguments[0]);
        return result;
    }
}
