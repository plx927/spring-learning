package com.panlingxiao.spring.aop.chain;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ChainHandlerC implements ChainHandler {

    @Override
    public void handleRequest(Chain chain) {
        log.info("ChainHandlerC handle request");
        chain.process();
    }
}
