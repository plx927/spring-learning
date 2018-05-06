package com.panlingxiao.spring.aop.service.impl;

import com.panlingxiao.spring.aop.service.PersonService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PersonServiceImpl implements PersonService {
    @Override
    public void setAge() {
        log.warn("set age");
    }

    @Override
    public void getAge() {
        log.warn("get age");
    }

    @Override
    public void goHome() {
        log.info("go home");
    }
}
