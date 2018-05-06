package com.panlingxiao.spring.aop.chain;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ChainHandlerB implements ChainHandler {

    @Override
    public void handleRequest(Chain chain) {
        log.info("ChainHandlerB handle request");
        chain.process();
    }
}
