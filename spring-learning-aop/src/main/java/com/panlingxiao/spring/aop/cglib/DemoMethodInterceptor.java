package com.panlingxiao.spring.aop.cglib;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

@Slf4j
public class DemoMethodInterceptor implements MethodInterceptor {

    private Object target;

    public DemoMethodInterceptor(Object target) {
        this.target = target;
    }

    @Override
    public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        try {
            log.info("before real subject invoke");
            Object result = method.invoke(target, args);
            return result;
        } catch (Exception e) {
            log.error("target execute fail:", e);
            throw e;
        } finally {
            log.info("after real subject invoke");
        }
    }

}
