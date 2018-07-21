package com.panlingxiao.spring.aop.bean;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NativeWaiter implements Waiter {


    @Override
    public void greetTo(String name) {
        log.info("greet to:{}...", name);
    }

    @Override
    public void serveTo(String name) {
        log.info("serve to:{}...", name);
    }

    @Override
    public void lie(String name) {
        throw new RuntimeException("can not be lied to " + name);
    }
}
