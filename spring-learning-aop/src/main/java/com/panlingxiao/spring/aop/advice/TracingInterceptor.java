package com.panlingxiao.spring.aop.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.util.Arrays;

/**
 * Created by panlingxiao on 2018/6/25.
 */
public class TracingInterceptor implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("method " + invocation.getMethod() + " is called on " +
                invocation.getThis() + " with args " + Arrays.toString(invocation.getArguments()));
        Object ret = invocation.proceed();
        System.out.println("method " + invocation.getMethod() + " returns " + ret);
        return ret;
    }
}
