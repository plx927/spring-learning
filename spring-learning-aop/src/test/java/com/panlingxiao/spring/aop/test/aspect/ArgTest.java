package com.panlingxiao.spring.aop.test.aspect;

import com.panlingxiao.spring.aop.service.ProductService;
import com.panlingxiao.spring.aop.test.AopBaseTest;
import org.junit.Test;

import javax.annotation.Resource;

public class ArgTest extends AopBaseTest {

    @Resource
    private ProductService productService;

    @Test
    public void argPointcutTest() {
        productService.addProduct();
        productService.addProduct("hello");
        productService.addProduct("world");
    }
}
