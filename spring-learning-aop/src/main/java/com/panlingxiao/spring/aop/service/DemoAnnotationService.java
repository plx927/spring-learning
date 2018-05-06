package com.panlingxiao.spring.aop.service;

import com.panlingxiao.spring.aop.annotation.LogAction;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DemoAnnotationService {


    @LogAction(name = "注解式拦截")
    public void add() {
        log.info("DemoAnnotationService add");
    }
}
