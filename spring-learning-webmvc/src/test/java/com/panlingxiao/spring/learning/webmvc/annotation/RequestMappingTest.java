package com.panlingxiao.spring.learning.webmvc.annotation;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.lang.reflect.Method;

/**
 * Created by panlingxiao on 2016/6/26.
 */
public class RequestMappingTest {

    @RequestMapping("hello")
    public void myTest1(){

    }

    @RequestMapping(value = "hello",method = RequestMethod.DELETE)
    public void myTest2(){

    }

    @Test
    public void testExtractRequestMappingInfo() throws Exception{
        Method method = RequestMappingTest.class.getMethod("myTest2", new Class[]{});
        RequestMapping mapping = method.getAnnotation(RequestMapping.class);
        RequestMethod[] methods = mapping.method();
        for(RequestMethod rm : methods){
            Assert.assertEquals(RequestMethod.DELETE,rm);
        }
    }

    @Test
    public void testRequestMethod(){
        Assert.assertEquals(RequestMethod.GET,RequestMethod.valueOf("GET"));
    }


}
