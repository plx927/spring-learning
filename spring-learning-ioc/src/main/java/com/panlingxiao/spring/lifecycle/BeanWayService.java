package com.panlingxiao.spring.lifecycle;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BeanWayService {


    public void init() {
        log.info("@Bean-init-method");
    }

    public BeanWayService() {
        log.info("Construct BeanWayService");
    }

    public void destroy() {
        log.info("@Bean-destroy-method");
    }
}

