package com.panlingxiao.spring.learning.webmvc.annotation;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.condition.HeadersRequestCondition;
import org.springframework.web.servlet.mvc.condition.NameValueExpression;

import java.lang.reflect.Method;
import java.util.Set;

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


    @Test
    public void testNameValueExpression() {
        //传入的每一个字符串都会被解析成NameValueExpression
        HeadersRequestCondition headersRequestCondition = new HeadersRequestCondition("!aa","aa");
        Set<NameValueExpression<String>> expressions = headersRequestCondition.getExpressions();
        for (NameValueExpression expression : expressions) {
            String name = expression.getName();
            Object value = expression.getValue();
            System.out.println("name:" + name + ",value=" + value);
        }
    }


    /**
     * 测试@RequestMapping(headers={"!aa"}
     */
    @Test
    public void testHeaderMapping() throws Exception {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("http://localhost:8080/spring-learning-webmvc/headmapping/myTest1");
        httpGet.setHeader("aa","bb");
        CloseableHttpResponse response1 = httpclient.execute(httpGet);
        try {
            System.out.println(response1.getStatusLine());
            HttpEntity entity1 = response1.getEntity();
            // do something useful with the response body
            // and ensure it is fully consumed
            String value = EntityUtils.toString(entity1);
            System.out.println(value);
        } finally {
            response1.close();
        }

//        HttpPost httpPost = new HttpPost("http://targethost/login");
//        List <NameValuePair> nvps = new ArrayList <NameValuePair>();
//        nvps.add(new BasicNameValuePair("username", "vip"));
//        nvps.add(new BasicNameValuePair("password", "secret"));
//        httpPost.setEntity(new UrlEncodedFormEntity(nvps));
//        CloseableHttpResponse response2 = httpclient.execute(httpPost);
//
//        try {
//            System.out.println(response2.getStatusLine());
//            HttpEntity entity2 = response2.getEntity();
//            // do something useful with the response body
//            // and ensure it is fully consumed
//            EntityUtils.consume(entity2);
//        } finally {
//            response2.close();
//        }

    }

}
