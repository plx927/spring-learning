package com.panlingxiao.spring.aop.test.autoproxy;


import com.panlingxiao.spring.aop.bean.Boo;
import com.panlingxiao.spring.aop.bean.Foo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.lang.reflect.Proxy;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:beanNameAutoProxyCreator-test2.xml")
public class BeanNameAutoProxyCreatorTest2 {

    @Autowired
    private Foo foo;

    @Autowired
    private Boo boo;

    @Test
    public void testAutoProxyCreator() {
        // 由于是基于类代理，所以会生成CGLIB代理，我们可以直接通过CGLIB来判断生成的bean是否是CGLIB代理
        Assert.assertTrue(Enhancer.isEnhanced(foo.getClass()));
        Assert.assertTrue(Enhancer.isEnhanced(boo.getClass()));
        foo.hello();
        System.out.println("----------");
        boo.hello();

    }

}
