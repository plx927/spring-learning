package com.panlingxiao.spring.aop.test.api;

import com.panlingxiao.spring.aop.advice.MyAfterAdvice;
import com.panlingxiao.spring.aop.advice.MyBeforeAdvice;
import com.panlingxiao.spring.aop.service.ProductService;
import com.panlingxiao.spring.aop.service.impl.ProductServiceImpl;
import org.junit.Test;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.NameMatchMethodPointcutAdvisor;

import java.lang.reflect.Method;

/**
 * Created by panlingxiao on 2016/6/30.
 * 参考:http://docs.spring.io/spring/docs/current/spring-framework-reference/html/aop-api.html
 * 12.7 Creating AOP proxies programmatically with the ProxyFactory
 * <p>
 * Advice和Advisor的区别，阅读Spring源码和官方文档学习
 */
public class ProxyFactoryTest {

    @Test
    public void testProxyFactory() {
        /*
         * 基于编程式的方式创建AOP代理
         * 指定真实对象,通过ProxyFactory获取到代理对象
         */
        ProxyFactory proxyFactory = new ProxyFactory(new ProductServiceImpl());
        //proxyFactory.setOptimize(true);


//        ProxyFactory proxyFactory = new ProxyFactory(RealSubject.class.getInterfaces());
//        proxyFactory.setTarget(new RealSubject());

        //Advice最终会被包装成Advisor
        proxyFactory.addAdvice(new MyAfterAdvice());
        proxyFactory.addAdvice(new MyBeforeAdvice());

        /*
         * 获取到代理对象:
         * ProxyFactory包装了Advice,ProxyFactory在创建JdkDynamicAopProxy时作为参数传递,
         * 然后JdkDynamicAopProxy就可以通过ProxyFactory获取到Advisor，然后执行。
         */
        ProductService productService = (ProductService) proxyFactory.getProxy();
        System.out.println(productService.getClass().getName());
        System.out.println("--------------------------");
        productService.addProduct();
        System.out.println("-------------------------");
        productService.deleteProduct();
        System.out.println("-------------------------");
    }


    /**
     * 只希望对add方法进行拦截
     */
    @Test
    public void testProxyFactory2() {
        ProxyFactory proxyFactory = new ProxyFactory(new ProductServiceImpl());
        NameMatchMethodPointcutAdvisor advisor = new NameMatchMethodPointcutAdvisor();
        advisor.setMappedName("add*");
        advisor.setAdvice(new MyBeforeAdvice());
        proxyFactory.addAdvisor(advisor);
        ProductService productService = (ProductService) proxyFactory.getProxy();
        productService.addProduct();
        System.out.println("-------------------------");
        // delete方法没有执行Advice
        productService.deleteProduct();
    }


}
