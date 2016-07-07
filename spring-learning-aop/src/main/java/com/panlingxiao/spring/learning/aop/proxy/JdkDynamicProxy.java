package com.panlingxiao.spring.learning.aop.proxy;

import com.panlingxiao.spring.learning.aop.bean.Subject;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by panlingxiao on 2016/7/7.
 */
public class JdkDynamicProxy implements InvocationHandler{

    private Subject subject;

    public JdkDynamicProxy(Subject subject){
        this.subject = subject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before real subject invoke");
        Object value = method.invoke(subject, args);
        System.out.println("after real subject invoke");
        return  value;
    }

}
