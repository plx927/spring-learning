package com.panlingxiao.spring.aop.dynamic;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by panlingxiao on 2016/7/7.
 */
@Slf4j
public class JdkDynamicProxy implements InvocationHandler {

    private Object target;


    public static <T> T getProxy(Object target) {
        JdkDynamicProxy jdkDynamicProxy = new JdkDynamicProxy();
        jdkDynamicProxy.target = target;
        return (T) Proxy.newProxyInstance(JdkDynamicProxy.class.getClassLoader(),
                target.getClass().getInterfaces(), jdkDynamicProxy);
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        try {
            log.info("jdk proxy,before real subject invoke");
            Object result = method.invoke(target, args);
            return result;
        } catch (Exception e) {
            log.error("target execute fail:", e);
            throw e;
        } finally {
            log.info("jdk proxy,after real subject invoke");
        }
    }

}
