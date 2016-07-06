package com.panlingxiao.spring.learning.webmvc.annotation;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.springframework.http.MediaType;

/**
 * Created by panlingxiao on 2016/7/6.
 */
public class ResponseBodyTest {

    /**
     *  设置用户代理只能接受applicaiton/xml内容的数据,而服务器端却只能生成application/json，那么两者不匹配
     *  此时会抛出HttpMediaTypeNotAcceptableException
     */
    @Test
    public void test406Reponse() throws Exception{
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("http://localhost:8080/spring-learning-webmvc/responseBody/myTest2");
        Header[] accepts = httpGet.getHeaders("Accept");
        if(accepts == null){
            System.out.println("Accept请求为空");
        }else{
            for(Header accept : accepts){
                System.out.println(accept);
            }
        }
        httpGet.setHeader("Accept", MediaType.APPLICATION_XML_VALUE);
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
    }


    /**
     * 设置Accpet的权重,默认让其直接返回JSON
     * @throws Exception
     */
    @Test
    public void testDefaultReturnJson() throws Exception{
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("http://localhost:8080/spring-learning-webmvc/responseBody/myTest3");
        Header[] accepts = httpGet.getHeaders("Accept");
        if(accepts == null){
            System.out.println("Accept请求为空");
        }else{
            for(Header accept : accepts){
                System.out.println(accept);
            }
        }
        httpGet.setHeader("Accept",MediaType.APPLICATION_XML_VALUE+";q=.8,"+MediaType.APPLICATION_JSON_VALUE+";q=.8");
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
    }
}
