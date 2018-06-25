package com.panlingxiao.spring.aop.test.aspect;

import com.panlingxiao.spring.aop.service.ProductService;
import com.panlingxiao.spring.aop.test.AopBaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class WithinTest extends AopBaseTest {

    @Autowired
    private ProductService productService;


    /**
     * PointCut为某一个具体的类
     */
    @Test
    public void testWithinProductService() {
        productService.addProduct();
        System.out.println("----------------------");
        productService.deleteProduct();
        System.out.println("----------------------");
    }



}


