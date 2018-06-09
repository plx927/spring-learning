package com.panlingxiao.spring.aop.test.advice;

import com.panlingxiao.spring.aop.advice.*;
import com.panlingxiao.spring.aop.service.Monitorable;
import com.panlingxiao.spring.aop.service.Waiter;
import com.panlingxiao.spring.aop.service.impl.NativeWaiter;
import org.junit.Test;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.interceptor.ConcurrencyThrottleInterceptor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by panlingxiao on 2018/6/9.
 */
public class GreetingAdviceTest {


    @Test
    public void testBeforeGreeting() {
        ProxyFactory proxyFactory = new ProxyFactory(new NativeWaiter());
        proxyFactory.addAdvice(new GreetingBeforeAdvice());
        Waiter waiter = (Waiter) proxyFactory.getProxy();
        waiter.greetTo("Tom");
        System.out.println("----------------------");
        waiter.serveTo("Tom");
    }


    @Test
    public void testAfterGreeting() {
        ProxyFactory proxyFactory = new ProxyFactory(new NativeWaiter());
        proxyFactory.addAdvice(new GreetingAfterAdvice());
        proxyFactory.addAdvice(new GreetingBeforeAdvice());
        Waiter waiter = (Waiter) proxyFactory.getProxy();
        waiter.greetTo("Jerry");
        System.out.println("----------------------");
        waiter.serveTo("Jerry");
    }

    @Test
    public void testAroundAdvice() {
        ProxyFactory proxyFactory = new ProxyFactory(new NativeWaiter());
        proxyFactory.addAdvice(new GreetingAfterAdvice());
        proxyFactory.addAdvice(new GreetingBeforeAdvice());
        proxyFactory.addAdvice(new GreetingAroundAdvice());
        Waiter waiter = (Waiter) proxyFactory.getProxy();
        waiter.greetTo("Lucy");
        System.out.println("----------------------");
        waiter.serveTo("Lucy");
    }


    @Test
    public void testThrowsAdvice() {
        ProxyFactory proxyFactory = new ProxyFactory(new NativeWaiter());
        proxyFactory.addAdvice(new GreetingAfterAdvice());
        proxyFactory.addAdvice(new GreetingBeforeAdvice());
        proxyFactory.addAdvice(new GreetingAroundAdvice());
        proxyFactory.addAdvice(new MyThrowsAdvice());
        Waiter waiter = (Waiter) proxyFactory.getProxy();
        waiter.lie("Jack");
        System.out.println("----------------------");
        waiter.lie("Alice");
    }


    @Test
    public void testIntroductionAdvice() {
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setInterfaces(Monitorable.class);
        proxyFactory.setTarget(new NativeWaiter());
        proxyFactory.addAdvice(new ControllablePerformanceMonitor());
        proxyFactory.setProxyTargetClass(true);

        Waiter waiter = (Waiter) proxyFactory.getProxy();
        waiter.serveTo("LiLei");

        System.out.println(waiter.getClass().getName());
        System.out.println(waiter instanceof NativeWaiter);
        System.out.println(waiter instanceof Monitorable);

        Monitorable monitorable = (Monitorable) waiter;
        monitorable.setMonitorActive(true);

        waiter.serveTo("HanMeiMei");

    }


    @Test
    public void testIntroductionAdvice2() {
        ApplicationContext context = new ClassPathXmlApplicationContext("introduction-test.xml");
        Waiter waiter = context.getBean("waiter", Waiter.class);
        waiter.serveTo("LiLei");
        System.out.println("----------------");
        Monitorable monitorable = (Monitorable) waiter;
        monitorable.setMonitorActive(true);
        waiter.serveTo("HanMeiMei");
    }
}
