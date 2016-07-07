package com.panlingxiao.spring.learning.webmvc.other;

import org.junit.Test;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.method.HandlerMethodSelector;

import java.lang.reflect.Method;
import java.util.Set;

/**
 * Created by panlingxiao on 2016/6/27.
 * 测试AbstractHandlerMethodMapping如何完成对Handler方法的查找
 */
public class HandlerMethodSelectorTest {

    /**
     * 分析HandlerMethodSelector查找HandlerMethod的策略
     */
    @Test
    public void testSelectHandlerMethod(){
        final Class<?> userType = TestController.class;
        Set<Method> methods = HandlerMethodSelector.selectMethods(userType,new ReflectionUtils.MethodFilter(){
            @Override
            public boolean matches(Method method) {
                RequestMapping methodAnnotation = AnnotationUtils.findAnnotation(method, RequestMapping.class);
                return methodAnnotation != null;
            }
        });

        if(methods != null && methods.size() > 0) {
            for (Method method : methods) {
                System.out.println(method);
            }
        }else{
            System.out.println("未找到HandlerMethod");
        }

        System.out.println(IFoo.class.getSuperclass());

    }


    interface IFoo{

    }

    class TestController{

        @RequestMapping
        public void method1(){

        }

        public void method2(){

        }

        @RequestMapping("/aa")
        public void method3(){

        }
    }




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
