package com.panlingxiao.spring.aop.test.framework;

import com.panlingxiao.spring.aop.advice.MyAfterAdvice;
import com.panlingxiao.spring.aop.advice.MyBeforeAdvice;
import com.panlingxiao.spring.aop.service.ProductService;
import com.panlingxiao.spring.aop.service.impl.ProductServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.aop.framework.Advised;
import org.springframework.aop.framework.ProxyFactory;

/**
 * Created by panlingxiao on 2018/7/25.
 */
public class AdvicedTest {

    @Test
    public void testAdviced() {
        ProxyFactory proxyFactory = new ProxyFactory(new ProductServiceImpl());
        proxyFactory.addAdvice(new MyBeforeAdvice());
        proxyFactory.addAdvice(new MyAfterAdvice());
        ProductService productService = (ProductService) proxyFactory.getProxy();
        /*
         * Any AOP proxy obtained from Spring can be cast to this interface to
         * allow manipulation of its AOP advice.
         */
        Assert.assertTrue(productService instanceof Advised);
        productService.addProduct();

        // 动态删除切面
        Advised advised = (Advised) productService;
        advised.removeAdvisor(0);
        productService.addProduct();
    }



}
