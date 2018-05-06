package com.panlingxiao.spring.aop.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DemoMethodService {

    public void add() {
        log.info("DemoMethodService add");
    }

    public void add(String name) {
        log.info("DemoMethodService add,name:{}", name);
    }

    public void add(String name, Integer num) {
        log.info("DemoMethodService add,name:{},num:{}", name, num);
    }
}
