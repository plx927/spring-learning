package com.panlingxiao.spring.aop.test.cglib;

import com.panlingxiao.spring.aop.cglib.DemoMethodInterceptor;
import com.panlingxiao.spring.aop.proxy.RealSubject;
import com.panlingxiao.spring.aop.proxy.Subject;
import org.junit.Test;
import org.springframework.cglib.proxy.Enhancer;

public class CglibTest {

    @Test
    public void testCglibProxy() {
        Enhancer enhancer = new Enhancer();
        enhancer.setCallback(new DemoMethodInterceptor(new RealSubject()));
        enhancer.setSuperclass(Subject.class);
        Subject subject = (Subject) enhancer.create();
        subject.sayHello("cglib proxy");

    }
}
