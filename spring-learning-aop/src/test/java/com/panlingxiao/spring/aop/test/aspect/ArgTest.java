package com.panlingxiao.spring.aop.test.aspect;

import com.panlingxiao.spring.aop.service.DemoMethodService;
import com.panlingxiao.spring.aop.test.AopBaseTest;
import org.junit.Test;

import javax.annotation.Resource;

public class ArgTest extends AopBaseTest{

    @Resource
    private DemoMethodService demoMethodService;

    @Test
    public void argPointcutTest(){
        demoMethodService.add();
        demoMethodService.add("hello");
        demoMethodService.add("world",123);
    }
}
