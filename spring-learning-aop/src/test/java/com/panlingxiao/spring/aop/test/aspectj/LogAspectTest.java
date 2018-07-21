package com.panlingxiao.spring.aop.test.aspectj;

import com.panlingxiao.spring.aop.service.ProductService;
import com.panlingxiao.spring.aop.test.AopBaseTest;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * Created by panlingxiao on 2018/6/24.
 */
public class LogAspectTest extends AopBaseTest{

    @Resource
    private ProductService productService;

    @Test
    public void testAddProduct(){
        productService.addProduct();
    }
}
