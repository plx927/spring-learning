package com.panlingxiao.spring.learning.webmvc.controller;

import com.panlingxiao.spring.learning.webmvc.domain.Person;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by panlingxiao on 2016/7/5.
 */
@Controller
@RequestMapping(value="/consume",consumes = MediaType.APPLICATION_JSON_VALUE)
public class ConsumeController {



    @RequestMapping(value="/myTest",headers = {"Content-Type=text/json"})
    public void myTest1(){

    }


    /**
     * 请求映射的URL:/consume/myTest2
     * Content-Type:JSON 参考ConsumeRequestCondition的combine方法
     * @param person
     */
    @RequestMapping(value="/myTest2",consumes = {MediaType.APPLICATION_XML_VALUE})
    public void myTest2(@RequestBody Person person){
        System.out.println(person);
    }


    @RequestMapping("/urlConnection")
    public void testHttpURLConnection(HttpServletRequest request){
        String contentType = request.getContentType();
        String acceptHeader = request.getHeader("Accept");
        System.out.println("ContentType:"+contentType+",Accept:"+acceptHeader);
    }

    /**
     * 但是HttpServletRequest必须设置Content-Type，否则数据无法绑定
     * 在使用Ajax发送异步请求的时候，也必须制定Content-Type，否则会返回415状态码
     * org.springframework.web.HttpMediaTypeNotSupportedException: Content type 'application/x-www-form-urlencoded' not supported
     * org.springframework.web.HttpMediaTypeNotSupportedException: Content type 'multipart/form-data;boundary=----WebKitFormBoundaryB2jCMsbxvd8GFQJg' not supported
     */
    @RequestMapping(value = "/bindPersonByJson")
    public void bindPersonByJson(@RequestBody Person person){
        System.out.println(person);
    }









}
