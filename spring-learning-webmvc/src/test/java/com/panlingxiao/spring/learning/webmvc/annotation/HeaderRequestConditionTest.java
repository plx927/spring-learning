package com.panlingxiao.spring.learning.webmvc.annotation;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.servlet.mvc.condition.HeadersRequestCondition;
import org.springframework.web.servlet.mvc.condition.NameValueExpression;

import java.util.Enumeration;
import java.util.Set;

/**
 * Created by panlingxiao on 2016/7/5.
 */
public class HeaderRequestConditionTest {

    //MOCK--假的

    /**
     * 测试RequestMapping(headers={!aa})
     */
    @Test
    public void testNameValueExpression() {
        //传入的每一个字符串都会被解析成NameValueExpression,通过parseExpressions方法查看
        HeadersRequestCondition headersRequestCondition = new HeadersRequestCondition("!aa", "bb", "cc=dd", "hello!=world");
        //!aa && bb && cc=dd && hello!=world
        System.out.println(headersRequestCondition);
        Set<NameValueExpression<String>> expressions = headersRequestCondition.getExpressions();
        for (NameValueExpression expression : expressions) {
            System.out.println("name:" + expression.getName() + ",value:" + expression.getValue() + ",isNegated:" + expression.isNegated());
        }
    }

    /**
     * !aa，表示请求头中不能由aa
     */
    @Test
    public void testMockHeaderRequestConditionMatch() {
        HeadersRequestCondition headersRequestCondition = new HeadersRequestCondition("!aa");
        MockHttpServletRequest request = new MockHttpServletRequest();
        //当匹配的时候就不为空
        HeadersRequestCondition matchingCondition = headersRequestCondition.getMatchingCondition(request);
        Assert.assertNotNull(matchingCondition);

        request.addHeader("aa", "test");
        matchingCondition = headersRequestCondition.getMatchingCondition(request);
        Assert.assertNull(matchingCondition);
    }

    /**
     * bb,表示请求头中必须有bb，但是不限定具体的值
     */
    @Test
    public void testMockHeaderRequestConditionMatch2() {
        //name=aa,value=null,isNegated=false
        HeadersRequestCondition headersRequestCondition = new HeadersRequestCondition("bb");

        //创建请求
        MockHttpServletRequest request = new MockHttpServletRequest();
        HeadersRequestCondition matchingCondition = headersRequestCondition.getMatchingCondition(request);
        Assert.assertNull(matchingCondition);

        request.addHeader("bb", "cc");
        matchingCondition = headersRequestCondition.getMatchingCondition(request);
        Assert.assertEquals(headersRequestCondition, matchingCondition);
    }

    /**
     * cc=dd,表示请求头中必须有bb，但是不限定具体的值
     */
    @Test
    public void testMockHeaderRequestConditionMatch3() {
        //name=aa,value=null,isNegated=false
        HeadersRequestCondition headersRequestCondition = new HeadersRequestCondition("cc=dd");

        //创建请求
        MockHttpServletRequest request = new MockHttpServletRequest();
        HeadersRequestCondition matchingCondition = headersRequestCondition.getMatchingCondition(request);
        Assert.assertNull(matchingCondition);


        /*
         * 底层源码实现只取一个值，因此如果同一个请求头出现多次，可能未必会被取到。因为匹配的请求头在后面，而SpringMVC取到的是前面的请求头
         * 如果将
         *   request.addHeader("cc", "dd");
         *   request.addHeader("cc", "ee");
         *  顺序替换，则执行报错。
         */
        request.addHeader("cc", "dd");
        request.addHeader("cc", "ee");
        matchingCondition = headersRequestCondition.getMatchingCondition(request);
        Assert.assertEquals(headersRequestCondition, matchingCondition);
        //Assert.assertNull(matchingCondition);
        System.out.println(request.getHeader("cc"));

        Enumeration<String> headers = request.getHeaders("cc");
        while (headers.hasMoreElements()) {
            String value = headers.nextElement();
            System.out.println("value:" + value);
        }

        //request.getParameter("hobby")==  request.getParameterValues("hobby")[0];
       // request.getParameter("hobby");
        //request.getParameterValues("hobby");
    }

    /**
     *  cc!=world,表示请求头中如果有hello,那么它的值必须不能为world,请求头中也可以没有hello
     */
    @Test
    public void testMockHeaderRequestConditionMatch4() {
        //name=aa,value=null,isNegated=false
        HeadersRequestCondition headersRequestCondition = new HeadersRequestCondition("hello!=world");

        //创建请求，没有请求头
        MockHttpServletRequest request = new MockHttpServletRequest();
        HeadersRequestCondition matchingCondition = headersRequestCondition.getMatchingCondition(request);
        Assert.assertEquals(headersRequestCondition, matchingCondition);


        request.addHeader("hello", "world");
        matchingCondition = headersRequestCondition.getMatchingCondition(request);
        Assert.assertNull(matchingCondition);

        request = new MockHttpServletRequest();
        request.addHeader("hello", "welcome");
        matchingCondition = headersRequestCondition.getMatchingCondition(request);
        Assert.assertEquals(headersRequestCondition, matchingCondition);

        request = new MockHttpServletRequest();
        request.addHeader("world", "world");
        matchingCondition = headersRequestCondition.getMatchingCondition(request);
        Assert.assertEquals(headersRequestCondition, matchingCondition);
    }


    /**
     * 综合测试:
     * {aa=bb,cc!=dd,ff,!gg}
     */
    @Test
    public void testMockHeaderRequestConditionMatch5() {
        HeadersRequestCondition headersRequestCondition = new HeadersRequestCondition("aa=bb","ff","cc!=dd","!gg");
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.addHeader("aa","bb");
        request.addHeader("ff","bb");
        HeadersRequestCondition matchingCondition = headersRequestCondition.getMatchingCondition(request);
        Assert.assertEquals(headersRequestCondition, matchingCondition);

        request.addHeader("cc","hello");
        matchingCondition = headersRequestCondition.getMatchingCondition(request);
        Assert.assertEquals(headersRequestCondition, matchingCondition);
    }







    /**
     * 测试@RequestMapping(headers={"!aa"}
     */
    @Test
    public void testHeaderMapping() throws Exception {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("http://localhost:8080/spring-learning-webmvc/headmapping/myTest1");
        httpGet.setHeader("aa", "bb");
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
