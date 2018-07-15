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
@ContextConfiguration(locations = "classpath*:beanNameAutoProxyCreator-test.xml")
public class BeanNameAutoProxyCreatorTest {

    @Resource
    private ProductService productService;

    @Resource
    private CategoryService categoryService;


    @Test
    public void testAutoProxyCreator() {
        Assert.assertTrue(Proxy.isProxyClass(productService.getClass()));
        Assert.assertTrue(Proxy.isProxyClass(categoryService.getClass()));
        productService.addProduct();
    }


}
