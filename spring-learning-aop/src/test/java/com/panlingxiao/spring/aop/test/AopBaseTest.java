package com.panlingxiao.spring.aop.test;

import com.panlingxiao.spring.aop.config.AopConfig;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AopConfig.class)
public class AopBaseTest {
}
