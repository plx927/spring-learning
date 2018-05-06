package com.panlingxiao.spring.aop.chain;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class Chain {

    /**
     * 保存所有的处理器
     */
    private List<ChainHandler> handlers;

    /**
     * 当前执行到哪一个Handler
     */
    private int index;

    public Chain(List<ChainHandler> handlers) {
        this.handlers = handlers;
    }

    public void process() {
        if (index < handlers.size()) {
            handlers.get(index++).handleRequest(this);
        }
    }
}

