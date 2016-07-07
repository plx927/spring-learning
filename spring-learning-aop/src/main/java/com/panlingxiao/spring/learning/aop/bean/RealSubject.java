package com.panlingxiao.spring.learning.aop.bean;

/**
 * Created by panlingxiao on 2016/7/7.
 */
public class RealSubject implements Subject{
    @Override
    public String sayHello(String name) {
        System.out.println("real subject");
        return "hello:"+name;
    }
}
