package com.panlingxiao.spring.aop.test.proxy.jdk;

import com.panlingxiao.spring.aop.proxy.jdk.JdkDynamicProxy;
import com.panlingxiao.spring.aop.proxy.RealSubject;
import com.panlingxiao.spring.aop.proxy.Subject;

import java.lang.reflect.Proxy;

/**
 * Created by panlingxiao on 2016/7/7.
 * JDK动态代理
 */
public class JdkDynamicProxyTest {


    public static void main(String[] args) {
        // 开启将生成的字节码写入到本地磁盘
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        Subject proxy = JdkDynamicProxy.getProxy(new RealSubject());
        proxy.sayHello("world");
        System.out.println(proxy.getClass().getName());
        // JDK内置用于判断一个Class是否是代理类
        System.out.println(Proxy.isProxyClass(proxy.getClass()));
    }
}
