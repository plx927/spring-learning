package com.panlingxiao.spring.learning.webmvc.annotation;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import org.springframework.util.StringValueResolver;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.condition.*;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.util.UrlPathHelper;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by panlingxiao on 2016/6/26.
 */
public class RequestMappingTest {

    @RequestMapping("hello")
    public void myTest1() {

    }


    @RequestMapping(value = "hello", method = RequestMethod.DELETE)
    public void myTest2() {

    }

    @Test
    public void testExtractRequestMappingInfo() throws Exception {
        Method method = RequestMappingTest.class.getMethod("myTest2", new Class[]{});
        RequestMapping mapping = method.getAnnotation(RequestMapping.class);
        RequestMethod[] methods = mapping.method();
        for (RequestMethod rm : methods) {
            Assert.assertEquals(RequestMethod.DELETE, rm);
        }
    }

    @Test
    public void testRequestMethod() {
        Assert.assertEquals(RequestMethod.GET, RequestMethod.valueOf("GET"));
    }


    /**
     * ------------------------------------------测试RequestMappingInfo---------------------------
     */


    private boolean useSuffixPatternMatch = true;
    private boolean useTrailingSlashMatch = true;
    private boolean useRegisteredSuffixPatternMatch = false;
    private ContentNegotiationManager contentNegotiationManager = new ContentNegotiationManager();
    private final List<String> fileExtensions = new ArrayList<String>();
    private StringValueResolver embeddedValueResolver;
    private UrlPathHelper urlPathHelper = new UrlPathHelper();
    private PathMatcher pathMatcher = new AntPathMatcher();


    /**
     * 模拟RequestMappingHandlerMapping创建RequestMappingInfo
     */
    @Test
    public void testRequestMappingInfo1(){
        RequestMapping annotation = null;
        String[] patterns = null;
        RequestCondition<?> customCondition = null;


        RequestMappingInfo requestMappingInfo = new RequestMappingInfo(
                new PatternsRequestCondition(patterns, this.urlPathHelper, this.pathMatcher,
                        this.useSuffixPatternMatch, this.useTrailingSlashMatch, this.fileExtensions),
                new RequestMethodsRequestCondition(annotation.method()),
                new ParamsRequestCondition(annotation.params()),
                new HeadersRequestCondition(annotation.headers()),
                new ConsumesRequestCondition(annotation.consumes(), annotation.headers()),
                new ProducesRequestCondition(annotation.produces(), annotation.headers(), contentNegotiationManager),
                customCondition);

    }



}
