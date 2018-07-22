package com.panlingxiao.spring.aop.test.autoproxy;

import com.panlingxiao.spring.aop.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by panlingxiao on 2018/7/22.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:annotationAwareAspectJAutoProxyCreator-test.xml")
public class AnnotationAwareAspectJAutoProxyCreatorTest {

    @Resource
    private ProductService productService;

    @Test
    public void testAutoProxyByAspectJ() {
        productService.addProduct("apple");
    }
}
