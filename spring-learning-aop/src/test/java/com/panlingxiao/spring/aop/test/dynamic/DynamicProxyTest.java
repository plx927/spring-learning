package com.panlingxiao.spring.aop.test.dynamic;

import com.panlingxiao.spring.aop.dynamic.JdkDynamicProxy;
import com.panlingxiao.spring.aop.proxy.RealSubject;
import com.panlingxiao.spring.aop.proxy.Subject;
import org.junit.Test;

import java.lang.reflect.Proxy;

/**
 * Created by panlingxiao on 2016/7/7.
 * JDK动态代理
 */
public class DynamicProxyTest {


    @Test
    public void testProxy() {
        RealSubject subject = new RealSubject();
        JdkDynamicProxy invocationHandler = new JdkDynamicProxy(subject);
        Subject proxy = (Subject) Proxy.newProxyInstance(this.getClass().getClassLoader(), subject.getClass().getInterfaces(), invocationHandler);
        proxy.sayHello("world");

        // JDK内置用于判断一个Class是否是代理类
        System.out.println(Proxy.isProxyClass(proxy.getClass()));
        System.out.println(Proxy.isProxyClass(subject.getClass()));
    }
}
