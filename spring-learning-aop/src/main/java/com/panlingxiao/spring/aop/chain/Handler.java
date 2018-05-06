package com.panlingxiao.spring.aop.chain;


import lombok.Data;

@Data
public abstract class Handler {

    /**
     * 后继处理对象
     */
    protected Handler successor;


    /**
     * 请求处理方法
     * 该方法是否接受参数根据具体业务而定
     */
    public abstract void handleRequest();


}
