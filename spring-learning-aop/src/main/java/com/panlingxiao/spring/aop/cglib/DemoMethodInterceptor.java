package com.panlingxiao.spring.aop.cglib;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

@Slf4j
public class DemoMethodInterceptor implements MethodInterceptor {

    private Object target;

    public static <T> T getProxy(Object target) {
        Enhancer enhancer = new Enhancer();
        DemoMethodInterceptor demoMethodInterceptor = new DemoMethodInterceptor();
        demoMethodInterceptor.target = target;
        enhancer.setCallback(demoMethodInterceptor);
        enhancer.setSuperclass(target.getClass());
        return (T) enhancer.create();
    }

    @Override
    public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        try {
            log.info("before real subject invoke");
            Object result = method.invoke(target, args);
            //methodProxy.invokeSuper(proxy,args);

            return result;
        } catch (Exception e) {
            log.error("target execute fail:", e);
            throw e;
        } finally {
            log.info("after real subject invoke");
        }
    }

}
