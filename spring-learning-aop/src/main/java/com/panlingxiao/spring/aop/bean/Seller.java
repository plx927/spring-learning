package com.panlingxiao.spring.aop.bean;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by panlingxiao on 2018/6/9.
 */
@Slf4j
public class Seller {

    public void greetTo(String name) {
        log.info("seller greet to " + name);
    }
}
