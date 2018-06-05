package com.panlingxiao.spring.configurable;


import com.panlingxiao.spring.config.ProductConfig;
import com.panlingxiao.spring.domain.Product;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

@ContextConfiguration(classes = ProductConfig.class)
public class ConfigurableTest extends AbstractJUnit4SpringContextTests {

    @Test
    public void testProduct(){
        Product product = new Product("","");

    }
}
