package com.panlingxiao.spring.aop.test.advice;

import com.panlingxiao.spring.aop.advice.*;
import com.panlingxiao.spring.aop.bean.Singer;
import org.junit.Test;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by panlingxiao on 2018/6/25.
 */
public class AdviceTest {


    @Test
    public void testMethodInterceptor() {
        ProxyFactory proxyFactory = new ProxyFactory(new Singer());
        // 添加Advice
        proxyFactory.addAdvice(new TracingInterceptor());

        // 获取代理对象
        Singer singer = (Singer) proxyFactory.getProxy();
        singer.sing("hello world");
    }


    @Test(expected = IllegalArgumentException.class)
    public void testThrowsAdvice() {
        ProxyFactory proxyFactory = new ProxyFactory(new Singer());
        // 添加Advice
        proxyFactory.addAdvice(new SingerThrowsAdvice());

        // 获取代理对象
        Singer singer = (Singer) proxyFactory.getProxy();
        singer.sing(null);
    }

    @Test
    public void testIntroduction() {
        Enhancer enhancer = new Enhancer();
        // 为Singer生成代理对象
        enhancer.setSuperclass(Singer.class);
        // 这里只是测试
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                return null;
            }
        });
        // 让生成的子类，同时实现Lockable接口
        enhancer.setInterfaces(new Class[]{Lockable.class});
        Object object = enhancer.create();
        // 生成的代理是Singer类的子类
        System.out.println("obj is instance of Singer" + (object instanceof Singer));
        // 生成的代理同时实现了Lockable接口
        System.out.println("obj is instance of Lockable" + (object instanceof Lockable));
    }


    @Test
    public void testIntroductionAdvice() {
        ProxyFactory proxyFactory = new ProxyFactory(new Singer());
        proxyFactory.setProxyTargetClass(true);
        proxyFactory.addAdvice(new LockAdvice());
        Singer singer = (Singer) proxyFactory.getProxy();
        singer.sing("hello");

        Lockable lockable = (Lockable) singer;
        lockable.lock();
        try {
            singer.sing("hello");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        lockable.unlock();
        singer.sing("hello");

    }


    @Test
    public void testIntroductionAdvice2() {
        ProxyFactory proxyFactory = new ProxyFactory(new Singer());
        proxyFactory.setProxyTargetClass(true);
        proxyFactory.addAdvice(new LockMixin());
        Singer singer = (Singer) proxyFactory.getProxy();
        singer.sing("hello");

        Lockable lockable = (Lockable) singer;
        lockable.lock();

        try {
            singer.sing("hello");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        lockable.unlock();
        singer.sing("hello");
    }


}
