package com.panlingxiao.spring.aop.dynamic;

import com.panlingxiao.spring.aop.proxy.Subject;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by panlingxiao on 2016/7/7.
 */
@Slf4j
public class JdkDynamicProxy implements InvocationHandler {

    private Subject subject;

    public JdkDynamicProxy(Subject subject) {
        this.subject = subject;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        try {
            log.info("jdk proxy,before real subject invoke");
            Object result = method.invoke(subject, args);
            return result;
        } catch (Exception e) {
            log.error("target execute fail:", e);
            throw e;
        } finally {
            log.info("jdk proxy,after real subject invoke");
        }
    }

}
