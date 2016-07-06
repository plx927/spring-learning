package com.panlingxiao.spring.learning.webmvc.annotation;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.panlingxiao.spring.learning.webmvc.domain.Person;
import com.thoughtworks.xstream.XStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.springframework.http.MediaType;

import java.io.IOException;
import java.nio.charset.Charset;

/**
 * Created by panlingxiao on 2016/7/6.
 */
public class RequestBodyTest {

    ObjectMapper mapper = new ObjectMapper();

    @Test
    public void testPostJson() throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost post = new HttpPost("http://localhost:8080/spring-learning-webmvc/requestBody/myTest1");
        Header[] accepts = post.getHeaders("Accept");
        if(accepts == null){
            System.out.println("Accept请求为空");
        }else{
            for(Header accept : accepts){
                System.out.println(accept);
            }
        }
        /*
         * 我发送的数据的MediaType，客户端必须指定自己所发送数据的MediaType
         * 如果不指定，服务器端不知道用哪个HttpMessageConverter来进行转换
         */
        post.setHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE);

        //我可以处理的数据的MediaType
        post.setHeader("Accept", MediaType.APPLICATION_JSON_VALUE);
        Person p = new Person();
        p.setAge(20);
        p.setName("hello");
        String content = mapper.writeValueAsString(p);
        post.setEntity(new StringEntity(content, Charset.forName("UTF-8")));
        CloseableHttpResponse response = httpclient.execute(post);
        try {
            System.out.println(response.getStatusLine());
            HttpEntity entity1 = response.getEntity();
            // do something useful with the response body
            // and ensure it is fully consumed
            String value = EntityUtils.toString(entity1);
            System.out.println(value);
        } finally {
            response.close();
        }
    }

    @Test
    public void testPostXml() throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost post = new HttpPost("http://localhost:8080/spring-learning-webmvc/requestBody/myTest1");
        Header[] accepts = post.getHeaders("Accept");
        if(accepts == null){
            System.out.println("Accept请求为空");
        }else{
            for(Header accept : accepts){
                System.out.println(accept);
            }
        }
        //我发送的数据的MediaType
        post.setHeader("Content-Type", MediaType.APPLICATION_XML_VALUE);


        //我可以处理的数据的MediaType
        post.setHeader("Accept", MediaType.APPLICATION_XML_VALUE);
        Person p = new Person();
        p.setAge(20);
        p.setName("hello");


        XStream xStream = new XStream();
        xStream.autodetectAnnotations(true);
        String content = xStream.toXML(p);
        post.setEntity(new StringEntity(content, Charset.forName("UTF-8")));
        CloseableHttpResponse response = httpclient.execute(post);
        try {
            System.out.println(response.getStatusLine());
            HttpEntity entity = response.getEntity();
            // do something useful with the response body
            // and ensure it is fully consumed
            String value = EntityUtils.toString(entity);
            System.out.println(value);
        } finally {
            response.close();
        }
    }


    @Test
    public void test3(){
        Person p = new Person();
        p.setAge(20);
        p.setName("hello");
        XStream xStream = new XStream();
        xStream.autodetectAnnotations(true);
        String value = xStream.toXML(p);
        System.out.println(value);
    }

}
