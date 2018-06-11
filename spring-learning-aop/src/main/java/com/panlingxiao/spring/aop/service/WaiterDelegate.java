package com.panlingxiao.spring.aop.service;

/**
 * Created by panlingxiao on 2018/6/10.
 */
public class WaiterDelegate {

    private Waiter waiter;

    public WaiterDelegate(Waiter waiter) {
        this.waiter = waiter;
    }

    public void service(String name) {
        waiter.greetTo(name);
    }
}
