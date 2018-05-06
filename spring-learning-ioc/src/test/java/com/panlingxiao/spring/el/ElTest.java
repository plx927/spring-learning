package com.panlingxiao.spring.el;


import com.panlingxiao.spring.config.ElConfig;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ElConfig.class)
@Slf4j
public class ElTest {

    @Autowired
    private Environment environment;

    @Autowired
    private ElConfig elConfig;

    @Test
    public void testVariableInject() {
        Assert.assertEquals("Hello World!", elConfig.getNormalStr());
        log.info("os name:{}", elConfig.getOsName());
        log.info("random number:{}", elConfig.getNumber());
        log.info("anotherName:{}", elConfig.getAnotherName());
        log.info("book author:{}", elConfig.getAuthor());
        log.info("book name:{}",environment.getProperty("book.name"));
        log.info("book author:{}",environment.getProperty("book.author"));
    }
}
