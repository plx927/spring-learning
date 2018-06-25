package com.panlingxiao.spring.aop.test.advisor;

import com.panlingxiao.spring.aop.advice.GreetingBeforeAdvice;
import com.panlingxiao.spring.aop.advisor.GreetingAdvisor;
import com.panlingxiao.spring.aop.pointcut.GreetingDynamicMethodMatcherPointcut;
import com.panlingxiao.spring.aop.bean.Seller;
import com.panlingxiao.spring.aop.bean.Waiter;
import com.panlingxiao.spring.aop.bean.WaiterDelegate;
import com.panlingxiao.spring.aop.bean.NativeWaiter;
import org.junit.Test;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.ControlFlowPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.RegexpMethodPointcutAdvisor;

/**
 * Created by panlingxiao on 2018/6/9.
 */
public class AdvisorTest {

    @Test
    public void testStaticMethodMatcherPointcutAdvisor() {
        ProxyFactory proxyFactory = new ProxyFactory(new NativeWaiter());
        proxyFactory.addAdvisor(new GreetingAdvisor(new GreetingBeforeAdvice()));
        Waiter waiter = (Waiter) proxyFactory.getProxy();


        ProxyFactory proxyFactory2 = new ProxyFactory(new Seller());
        proxyFactory2.addAdvisor(new GreetingAdvisor(new GreetingBeforeAdvice()));
        Seller seller = (Seller) proxyFactory2.getProxy();

        waiter.greetTo("Join");
        waiter.serveTo("John");
        seller.greetTo("John");

    }


    @Test
    public void testRegExpMethodPointcutAdvisor() {
        RegexpMethodPointcutAdvisor advisor = new RegexpMethodPointcutAdvisor();
        advisor.setAdvice(new GreetingBeforeAdvice());
        // 对greet开头的方法进行拦截
        advisor.setPattern(".*greet.*");

        ProxyFactory proxyFactory = new ProxyFactory(new NativeWaiter());
        proxyFactory.addAdvisor(advisor);

        Waiter waiter = (Waiter) proxyFactory.getProxy();
        waiter.greetTo("Alice");
        System.out.println("---------------------");
        waiter.serveTo("Alice");
    }


    @Test
    public void testDynamicPointcutAdvisor() {
        GreetingDynamicMethodMatcherPointcut pointcut = new GreetingDynamicMethodMatcherPointcut();
        DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor(pointcut, new GreetingBeforeAdvice());
        ProxyFactory proxyFactory = new ProxyFactory(new NativeWaiter());
        proxyFactory.addAdvisor(advisor);

        Waiter waiter = (Waiter) proxyFactory.getProxy();
        // 会进入动态的参数匹配
        waiter.greetTo("Tom");
        System.out.println("---------------------");
        waiter.greetTo("Alice");
        System.out.println("---------------------");
        // 静态匹配
        waiter.serveTo("Alice");
    }

    @Test
    public void testControlFlowPointcutAdvisor() {
        ControlFlowPointcut pointcut = new ControlFlowPointcut(WaiterDelegate.class, "service");
        DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor(pointcut, new GreetingBeforeAdvice());

        ProxyFactory proxyFactory = new ProxyFactory(new NativeWaiter());
        proxyFactory.addAdvisor(advisor);
        Waiter waiter = (Waiter) proxyFactory.getProxy();

        WaiterDelegate waiterDelegate = new WaiterDelegate(waiter);
        waiterDelegate.service("Tom");
        System.out.println("------------------");
        waiter.greetTo("Tom");
    }


}


