package com.panlingxiao.spring.scope;

import com.panlingxiao.spring.config.ScopeConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ScopeConfig.class)
public class ScopeTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void testBeanScope() {
        DemoSingletonService demoSingletonService1 =
                applicationContext.getBean("demoSingletonService", DemoSingletonService.class);

        DemoSingletonService demoSingletonService2 =
                applicationContext.getBean("demoSingletonService", DemoSingletonService.class);

        Assert.assertEquals(demoSingletonService1, demoSingletonService2);


        DemoPrototypeService demoPrototypeService1 =
                applicationContext.getBean("demoPrototypeService", DemoPrototypeService.class);
        DemoPrototypeService demoPrototypeService2 =
                applicationContext.getBean("demoPrototypeService", DemoPrototypeService.class);


        Assert.assertNotEquals(demoPrototypeService1, demoPrototypeService2);

    }
}
