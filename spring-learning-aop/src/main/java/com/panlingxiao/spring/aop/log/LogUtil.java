package com.panlingxiao.spring.aop.log;

import org.springframework.stereotype.Component;

@Component
public class LogUtil implements Logable {
    @Override
    public void log() {
        System.out.println("log from LogUtil");
    }
}
