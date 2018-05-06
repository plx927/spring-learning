package com.panlingxiao.spring.aop.chain;

public class HandlerClient {

    public static void main(String[] args) {

        Handler handlerA = new HandlerA();
        Handler handlerB = new HandlerB();
        Handler handlerC = new HandlerC();

        // 这里需要用户自己手动设置责任链中对象的依赖关系
        handlerA.setSuccessor(handlerB);
        handlerB.setSuccessor(handlerC);

        handlerA.handleRequest();

    }
}
