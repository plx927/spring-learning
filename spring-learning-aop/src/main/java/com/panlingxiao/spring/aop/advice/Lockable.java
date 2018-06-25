package com.panlingxiao.spring.aop.advice;

/**
 * Created by panlingxiao on 2018/6/25.
 */
public interface Lockable {

    void lock();

    void unlock();

    boolean locked();
}
