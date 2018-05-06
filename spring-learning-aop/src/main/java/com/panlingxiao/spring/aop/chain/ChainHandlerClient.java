package com.panlingxiao.spring.aop.chain;

import java.util.Arrays;

public class ChainHandlerClient {

    public static void main(String[] args) {
        Chain chain = new Chain(Arrays.asList(new ChainHandlerA(), new ChainHandlerB(), new ChainHandlerC()));
        chain.process();
    }
}
