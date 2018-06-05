package com.panlingxiao.spring.aop.test.cglib;

import com.panlingxiao.spring.aop.cglib.DemoMethodInterceptor;
import com.panlingxiao.spring.aop.proxy.RealSubject;
import com.panlingxiao.spring.aop.proxy.Subject;
import org.junit.Test;

public class CglibTest {

    @Test
    public void testCglibProxy() {
        Subject subject = DemoMethodInterceptor.getProxy(new RealSubject());
        subject.sayHello("cglib proxy");

    }
}
