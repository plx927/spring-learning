package com.panlingxiao.spring.aop.test.aspect;

import com.panlingxiao.spring.aop.service.DemoAnnotationService;
import com.panlingxiao.spring.aop.service.DemoMethodService;
import com.panlingxiao.spring.aop.test.AopBaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class LogAspectTest extends AopBaseTest {

    @Autowired
    private DemoMethodService demoMethodService;


    @Autowired
    private DemoAnnotationService demoAnnotationService;

    /**
     * 注解式拦截
     */
    @Test
    public void testAnnotationPointCut() {
        demoAnnotationService.add();
    }


    @Test
    public void testMethodPointCut() {
        demoMethodService.add();
        demoMethodService.add("hello");
        demoMethodService.add("world", 123);
    }
}
