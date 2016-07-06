package com.panlingxiao.spring.learning.webmvc.annotation;

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.servlet.mvc.condition.ConsumesRequestCondition;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by panlingxiao on 2016/7/4.
 * ConsumeRequestCondition对MIME的解析处理
 *
 * Content-Type是请求代理对其发送数据的MIME的描述,用于告诉服务器端以哪种方式来进行处理。
 *
 * type/subType;attr1=value1;attr2;value2
 *
 */
public class ConsumesRequestConditionTest {


    @Test
    public void testCreateConsumeRequestCondition(){
        String[] consumes = {"application/json","!application/xml"};
        String[] headers = {"Content-Type!=text/html"};
        ConsumesRequestCondition consumesRequestCondition = new ConsumesRequestCondition(consumes,headers);
        System.out.println(consumesRequestCondition);

        MediaType mediaType = MediaType.parseMediaType("application/json");
        System.out.println("fullType="+mediaType.getType()+",subType="+mediaType.getSubtype());

        mediaType = MediaType.parseMediaType("*");
        System.out.println("fullType="+mediaType.getType()+",subType="+mediaType.getSubtype());

    }

    //Accept:text/html, image/gif, image/jpeg, *; q=.2, */*; q=.2
    @Test
    public void testHttpURLConnection() throws IOException {
        URL url = new URL("http://localhost:8080/spring-learning-webmvc/consume/urlConnection");
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        String message = urlConnection.getResponseMessage();
        System.out.println(message);
    }


    /**
     * -----------------测试ConsumeRequestCondition是如何对HttpServletRequest的Content-Type进行匹配的----------------
     */


    /*
     * 当不设置任何ConsumeRequestCondition时，此时对于任何MediaType都能够成功匹配
     * 但是在最后数据绑定时可能由于无法找到合适的HandlerMethodArgumentResolver而导致HttpMediaTypeNotSupportedException
     */
    @Test
    public void testMatchMediaType1(){
        ConsumesRequestCondition consumesRequestCondition = new ConsumesRequestCondition(new String[]{}, new String[]{});
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.addHeader("Content-Type",MediaType.APPLICATION_FORM_URLENCODED_VALUE);
        ConsumesRequestCondition matchingCondition = consumesRequestCondition.getMatchingCondition(request);
        System.out.println(matchingCondition);
    }


    // 当consume为*/*时,则对于任何MediaType都能够匹配
    @Test
    public void testMatchMediaType2(){
        //  /*/, application/atom+xml
        String[] consumes = {MediaType.ALL_VALUE,MediaType.APPLICATION_ATOM_XML_VALUE};
        ConsumesRequestCondition consumesRequestCondition = new ConsumesRequestCondition(consumes);
        MockHttpServletRequest request = new MockHttpServletRequest();
        ConsumesRequestCondition matchingCondition = consumesRequestCondition.getMatchingCondition(request);
        System.out.println(matchingCondition);
    }


    // 当consume设置为application/*时，此时可以匹配application/json
    @Test
    public void testMatchMediaType3(){
        String[] consumes = {"application/*"};
        ConsumesRequestCondition consumesRequestCondition = new ConsumesRequestCondition(consumes);
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.addHeader("Content-Type",MediaType.APPLICATION_ATOM_XML_VALUE);
        ConsumesRequestCondition matchingCondition = consumesRequestCondition.getMatchingCondition(request);
        System.out.println(matchingCondition);
    }


    // application/*+xml匹配application/atom+xml
    @Test
    public void testMatchMediaType4(){
        String[] consumes = {"application/*+xml"};
        ConsumesRequestCondition consumesRequestCondition = new ConsumesRequestCondition(consumes);
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.addHeader("Content-Type",MediaType.APPLICATION_ATOM_XML_VALUE);
        ConsumesRequestCondition matchingCondition = consumesRequestCondition.getMatchingCondition(request);
        System.out.println(matchingCondition);
    }











}
