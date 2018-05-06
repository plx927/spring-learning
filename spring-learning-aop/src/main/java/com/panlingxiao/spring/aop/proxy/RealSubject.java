package com.panlingxiao.spring.aop.proxy;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by panlingxiao on 2016/7/7.
 */
@Slf4j
public class RealSubject implements Subject {
    @Override
    public String sayHello(String name) {
        log.info("RealSubject sayHello,name:{}",name);
        return "hello:" + name;
    }
}
