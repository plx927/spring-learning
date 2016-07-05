package com.panlingxiao.spring.learning.webmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by panlingxiao on 2016/7/5.
 */
@Controller
@RequestMapping("/consume")
public class ConsumeController {



    @RequestMapping(value="/myTest",headers = {"Content-Type=text/json"})
    public void myTest1(){

    }


    @RequestMapping("/urlConnection")
    public void testHttpURLConnection(HttpServletRequest request){
        String contentType = request.getContentType();
        String acceptHeader = request.getHeader("Accept");
        System.out.println("ContentType:"+contentType+",Accept:"+acceptHeader);
    }
}
