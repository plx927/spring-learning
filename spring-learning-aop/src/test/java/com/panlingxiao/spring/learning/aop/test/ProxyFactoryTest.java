package com.panlingxiao.spring.learning.aop.test;

import com.panlingxiao.spring.learning.aop.bean.RealSubject;
import com.panlingxiao.spring.learning.aop.bean.Subject;
import org.junit.Test;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;

import java.lang.reflect.Method;

/**
 * Created by panlingxiao on 2016/6/30.
 * 参考:http://docs.spring.io/spring/docs/current/spring-framework-reference/html/aop-api.html
 * 12.7 Creating AOP proxies programmatically with the ProxyFactory
 *
 *   Advice和Advisor的区别，阅读Spring源码和官方文档学习
 *
 *
 */
public class ProxyFactoryTest {

    @Test
    public void testProxyFactory() {
        /*
         * 基于编程式的方式创建AOP代理
         * 指定真实对象,通过ProxyFactory获取到代理对象
         */
       // ProxyFactory proxyFactory = new ProxyFactory(new RealSubject());


        ProxyFactory proxyFactory = new ProxyFactory(RealSubject.class.getInterfaces());
        proxyFactory.setTarget(new RealSubject());

        //Advice最终会被包装成Advisor
        proxyFactory.addAdvice(new MyAfterAdvice());
        proxyFactory.addAdvice(new MyBeforeAdvice());

        /*
         * 获取到代理对象:
         * ProxyFactory包装了Advice,ProxyFactory在创建JdkDynamicAopProxy时作为参数传递,
         * 然后JdkDynamicAopProxy就可以通过ProxyFactory获取到Advisor，然后执行。
         */
        Subject proxy = (Subject) proxyFactory.getProxy();


        String result = proxy.sayHello("吴大神");
        System.out.println(result);
    }

    static class MyBeforeAdvice implements MethodBeforeAdvice{

        @Override
        public void before(Method method, Object[] args, Object target) throws Throwable {
            System.out.println("before real subject invoke");
        }
    }

    static class MyAfterAdvice implements AfterReturningAdvice {

        @Override
        public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
            System.out.println("after real subject invoke");
        }
    }


}
