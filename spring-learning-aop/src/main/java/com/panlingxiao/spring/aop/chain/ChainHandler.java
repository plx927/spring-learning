package com.panlingxiao.spring.aop.chain;

public interface ChainHandler {
    /**
     * @param chain 调用链，通过Chain完成Handler之间的调用
     */
    void handleRequest(Chain chain);
}
