package com.panlingxiao.spring.learning.webmvc.other;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

/**
 * Created by panlingxiao on 2016/6/27.
 */
public class PathMatcherTest {

    @Test
    public void testCombineUrlByPathMatcher(){
        PathMatcher antPathMatcher = new AntPathMatcher();

        Assert.assertEquals("hello/world", antPathMatcher.combine("hello","world"));
        Assert.assertEquals("", antPathMatcher.combine(null,null));
        Assert.assertEquals("", antPathMatcher.combine("",""));
        Assert.assertEquals("", antPathMatcher.combine("",null));

        Assert.assertEquals("/hello", antPathMatcher.combine("","/hello"));
        Assert.assertEquals("/hello", antPathMatcher.combine(null,"/hello"));

        Assert.assertEquals("/hello", antPathMatcher.combine("/hello",""));
        Assert.assertEquals("/hello", antPathMatcher.combine("/hello",null));

        /*
         * /hello//world
         * /hello/world 是可以/hello//world匹配，但是需要遍历所有的RequestMappingInfo
         */
        Assert.assertEquals("/hello/world",antPathMatcher.combine("/hello","/world"));
        Assert.assertEquals("/hello/world",antPathMatcher.combine("/hello/","world"));
        Assert.assertEquals("hello/world",antPathMatcher.combine("hello","world"));
        Assert.assertEquals(true,antPathMatcher.match("/hello/world","/hello////////world"));
        Assert.assertEquals("/hello//world",antPathMatcher.combine("/hello/","/world"));

    }

}
