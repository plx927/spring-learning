package com.panlingxiao.spring.aop.test.aspectj;

import com.panlingxiao.spring.aop.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by panlingxiao on 2018/7/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:aop.xml")
public class AspectJAopBaseXml {

    @Resource
    private ProductService productService;


    @Test
    public void testProductService(){

    }
}
