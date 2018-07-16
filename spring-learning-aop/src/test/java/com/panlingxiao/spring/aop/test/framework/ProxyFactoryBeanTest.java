package com.panlingxiao.spring.aop.test.framework;

import com.panlingxiao.spring.aop.service.PersonService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:proxyFactoryBean-test.xml")
public class ProxyFactoryBeanTest {

    @Autowired
    private PersonService personService;

    @Test
    public void testMethodIntercept() {
        personService.setAge();
        personService.getAge();
        personService.goHome();
    }
}
