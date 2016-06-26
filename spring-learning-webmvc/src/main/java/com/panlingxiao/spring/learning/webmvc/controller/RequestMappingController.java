package com.panlingxiao.spring.learning.webmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by panlingxiao on 2016/6/26.
 */
@Controller
public class RequestMappingController {

    @RequestMapping(value="/myTest",method = RequestMethod.GET)
    public void myTest1(){

    }

    @RequestMapping(value="/myTest")
    public void myTest2(){

    }



}
