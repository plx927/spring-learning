package com.panlingxiao.spring.learning.aop.test;

import com.panlingxiao.spring.learning.aop.bean.RealSubject;
import com.panlingxiao.spring.learning.aop.bean.Subject;
import com.panlingxiao.spring.learning.aop.proxy.JdkDynamicProxy;
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
        JdkDynamicProxy invokcationHandler = new JdkDynamicProxy(subject);
        Subject proxy = (Subject) Proxy.newProxyInstance(this.getClass().getClassLoader(), subject.getClass().getInterfaces(), invokcationHandler);
        proxy.sayHello("world");

        //JDK内置用于判断一个Class是否是代理类
        System.out.println(Proxy.isProxyClass(proxy.getClass()));
        System.out.println(Proxy.isProxyClass(subject.getClass()));
    }
}
