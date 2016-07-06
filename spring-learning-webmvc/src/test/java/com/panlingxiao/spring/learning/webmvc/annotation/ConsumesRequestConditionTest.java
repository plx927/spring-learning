package com.panlingxiao.spring.learning.webmvc.annotation;

import org.junit.Test;
import org.springframework.http.MediaType;
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
        String[] consumes = {"application/json"};
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





}
