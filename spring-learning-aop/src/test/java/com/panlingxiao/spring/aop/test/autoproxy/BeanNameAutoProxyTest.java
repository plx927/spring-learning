package com.panlingxiao.spring.aop.test.autoproxy;


import com.panlingxiao.spring.aop.service.CategoryService;
import com.panlingxiao.spring.aop.service.ProductService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.lang.reflect.Proxy;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:beanNameAutoProxy.xml")
public class BeanNameAutoProxyTest {

    @Resource
    private ProductService productService;


    @Resource
    private CategoryService categoryService;


    @Test
    public void testProductService() {
        Assert.assertTrue(Proxy.isProxyClass(productService.getClass()));

        productService.addProduct();
    }


    @Test
    public void testCategoryService() {
        Assert.assertTrue(Proxy.isProxyClass(categoryService.getClass()));
        categoryService.addCategory();
    }

}
