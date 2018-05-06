package com.panlingxiao.spring.aop.chain;

import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

@Slf4j
public class HandlerC extends Handler {

    @Override
    public void handleRequest() {
        log.warn("HandlerC handle request");
        Optional.ofNullable(successor).ifPresent(Handler::handleRequest);
    }
}
