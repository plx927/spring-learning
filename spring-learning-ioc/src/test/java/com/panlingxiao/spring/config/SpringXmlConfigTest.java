package com.panlingxiao.spring.config;

import org.junit.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Created by panlingxiao on 2016/7/7.
 * Spring配置文件以及XSD校验测试
 */
public class SpringXmlConfigTest {

    @Test
    public void testConfigXmlFile(){
        //ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("app-context-beans-test.xml");
        GenericXmlApplicationContext  context = new GenericXmlApplicationContext("classpath:app-context-beans-test.xml");
        context.setValidating(false);
    }
}
