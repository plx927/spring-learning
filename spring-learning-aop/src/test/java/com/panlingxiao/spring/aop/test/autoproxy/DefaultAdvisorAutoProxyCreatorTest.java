package com.panlingxiao.spring.aop.test.autoproxy;


import com.panlingxiao.spring.aop.service.ProductService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.lang.reflect.Proxy;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:defaultAdvisorAutoProxy.xml")
public class DefaultAdvisorAutoProxyCreatorTest {

    @Resource
    private ProductService productService;

    @Test
    public void testProductService() {
        Assert.assertTrue(Proxy.isProxyClass(productService.getClass()));
        productService.addProduct();
    }
}
