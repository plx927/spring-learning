package com.panlingxiao.spring.lifecycle;

import lombok.extern.slf4j.Slf4j;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Slf4j
public class JSR250WayService {

    @PostConstruct
    public void init() {
        log.info("JSR250-init-method");
    }

    public JSR250WayService() {
        log.info("Construct JSR250WayService");
    }

    @PreDestroy
    public void destroy() {
        log.info("JSR250-destroy-method");
    }
}
