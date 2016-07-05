package com.panlingxiao.spring.learning.webmvc.other;

import org.junit.Test;
import org.springframework.core.BridgeMethodResolver;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Created by panlingxiao on 2016/6/29.
 */
public class BridgeMethodTest {

    //hello(Object)
    static class A<T>{
        public void hello(T t){
            System.out.println("Bridge-Method invoke");
        }
    }

    //hello(Integer),hello(Object)
    static class B extends A<Integer>{

        @Override
        public void hello(Integer integer) {
            super.hello(integer);
        }
    }

    @Test
    public void testResolveBridgeMethod() throws Exception{
        Method[] methods = B.class.getDeclaredMethods();
        for(Method method : methods){
           // System.out.println(method+",is bridge method:"+method.isBridge());
            if(method.isBridge()){
                method.invoke(new B(),new Object[]{123});
            }
        }
//        Constructor<?>[] constructors = B.class.getDeclaredConstructors();
//        for(Constructor constructor : constructors){
//            System.out.println(constructor);
//        }
//
//        methods = D.class.getDeclaredMethods();
//        for(Method method : methods){
//            System.out.println(method+",is bridge method:"+method.isBridge());
//        }
//        B b = new B();

//        C c = new D();
//        c.say("hello");
//
//        D d = new D();
//        d.say("world");
//        d.say((Object)"welcome");
//
//        A a = new B();
//        a.hello(new Integer(1));
//
//        //此时会抛出类型转换异常，因此调用桥接方法，而桥接方法会将参数进行类型转换
//        a.hello(new Object());


        //调用的桥接方法

    }

    @Test
    public void testBridgeMethodResolver(){
        Method[] methods = B.class.getDeclaredMethods();
        for(Method method : methods){
            System.out.println(method + ",is bridge method:" + method.isBridge());
            //执行Spring里面查找桥接的方法
            Method method1 = BridgeMethodResolver.findBridgedMethod(method);
            System.out.println(method1);
        }

        Integer[] array1 = new Integer[]{};



        int[] array2 = new int[]{1,2,3};
       // System.out.println(array1 instanceof Object[]);

        System.out.println(Object[].class.isAssignableFrom(array1.getClass()));
        System.out.println(Object[].class.isAssignableFrom(array2.getClass()));




        Method[] declaredMethods = E.class.getDeclaredMethods();
        for (Method method : declaredMethods){
            System.out.println(method);
        }

        E e = new E();
        e.testChanableArgu(new Integer[]{12,3,4});
        e.testChanableArgu(new Object[]{new int[]{1,2,3}});


        System.out.println(Arrays.asList(new Integer[]{1, 2, 3}));
        System.out.println(Arrays.asList(new int[]{1, 2, 3}));
    }



    static class C{
        public void say(Object obj){
            System.out.println("C1 "+obj);
        }

        public void say(String str){
            System.out.println("C2"+str);
        }
    }

    static class D extends C{
        @Override
        public void say(String obj){
            System.out.println("D "+obj);
        }
    }

    static class E{
        public void testChanableArgu(Object[]obj){

        }
    }

    @Test
    public void test1(){
        D d = new D();
        d.say((Object)"abc");
    }




}
