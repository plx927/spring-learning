package com.panlingxiao.spring.aop.test.framework;

import com.panlingxiao.spring.aop.aspect.ProGreetingAspect;
import com.panlingxiao.spring.aop.aspect.WithinAspect;
import com.panlingxiao.spring.aop.bean.NativeWaiter;
import com.panlingxiao.spring.aop.bean.Waiter;
import com.panlingxiao.spring.aop.service.ProductService;
import com.panlingxiao.spring.aop.service.impl.ProductServiceImpl;
import org.junit.Test;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;

public class AspectJFactoryTest {

    @Test
    public void testAspectJFactory() {

        // create a factory that can generate a proxy for the given target object
        AspectJProxyFactory factory = new AspectJProxyFactory(new ProductServiceImpl());


        // add an aspect, the class must be an @AspectJ aspect
        // you can call this as many times as you need with different aspects
        factory.addAspect(WithinAspect.class);


        ProductService productService = factory.getProxy();
        productService.addProduct();
        productService.deleteProduct();

    }


    @Test
    public void testNativeWaiter() {
        AspectJProxyFactory aspectJProxyFactory = new AspectJProxyFactory(new NativeWaiter());
        aspectJProxyFactory.addAspect(new ProGreetingAspect());
        Waiter waiter = aspectJProxyFactory.getProxy();
        waiter.greetTo("Tom");
        System.out.println("------------------------------");
        waiter.serveTo("Tom");
    }


}
