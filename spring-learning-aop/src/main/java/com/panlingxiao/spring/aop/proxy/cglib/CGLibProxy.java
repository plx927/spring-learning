package com.panlingxiao.spring.aop.proxy.cglib;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

@Slf4j
public class CGLibProxy implements MethodInterceptor {

    private Object target;

    @SuppressWarnings("unchecked")
    public static <T> T getProxy(Object target) {
        Enhancer enhancer = new Enhancer();
        CGLibProxy demoMethodInterceptor = new CGLibProxy();
        demoMethodInterceptor.target = target;
        enhancer.setCallback(demoMethodInterceptor);
        enhancer.setSuperclass(target.getClass());
        // 动态字节码创建子类实例
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
