package com.panlingxiao.spring.aop.chain;

import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

@Slf4j
public class HandlerA extends Handler {

    @Override
    public void handleRequest() {
        log.warn("HandlerA handle request");
        Optional.ofNullable(successor).ifPresent(Handler::handleRequest);
    }
}
