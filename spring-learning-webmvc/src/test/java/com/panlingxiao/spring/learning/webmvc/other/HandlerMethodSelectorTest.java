package com.panlingxiao.spring.learning.webmvc.other;

import org.junit.Test;

import java.lang.reflect.Method;

/**
 * Created by panlingxiao on 2016/6/27.
 */
public class HandlerMethodSelectorTest {


    @Test
    public void testBridgeMethod() {
        Method[] declaredMethods = B.class.getDeclaredMethods();
        for (Method method : declaredMethods) {
            System.out.println(method);
        }

        declaredMethods = D.class.getDeclaredMethods();
        for (Method method : declaredMethods) {
            System.out.println(method);
        }
    }

    static class A<T> {
        public void fun(T t) {
        }
    }

    static class B extends A<Integer> {
        @Override
        public void fun(Integer integer) {
            super.fun(integer);
        }
    }

    static class C {
        public void fun() {

        }
    }

    static class D extends C {
        @Override
        public void fun() {
            super.fun();
        }
    }
}
