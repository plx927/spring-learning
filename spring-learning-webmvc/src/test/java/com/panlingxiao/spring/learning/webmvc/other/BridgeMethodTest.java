package com.panlingxiao.spring.learning.webmvc.other;

import org.junit.Test;

import java.lang.reflect.Method;

/**
 * Created by panlingxiao on 2016/6/29.
 */
public class BridgeMethodTest {

    static class A<T>{
        public void hello(T t){

        }
    }

    static class B extends A<Integer>{
        @Override
        public void hello(Integer i) {
        }
    }

    @Test
    public void testResolveBridgeMethod(){
        Method[] methods = B.class.getDeclaredMethods();
        for(Method method : methods){
            System.out.println(method+",is bridge method:"+method.isBridge());
        }
    }



}
