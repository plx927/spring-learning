package com.panlingxiao.spring.aop.test.framework;

import com.panlingxiao.spring.aop.aspect.WithinAspect;
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
}
