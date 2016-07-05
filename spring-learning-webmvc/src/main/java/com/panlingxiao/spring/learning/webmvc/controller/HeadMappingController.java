package com.panlingxiao.spring.learning.webmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by panlingxiao on 2016/7/1.
 * 分析HeadersRequestCondition是如何对HTTP请求头做映射的
 * --headers中的元数据信息会被转变成HeaderExpression
 *
 */
@Controller
@RequestMapping("/headmapping")
public class HeadMappingController {

    /**
     * 表示Http请求头中不能有请求头的名字为aa出现。
     * 因为aa最后会被解析成HeaderExpression
     * 而它的name=aa,而value=null
     */
    @RequestMapping(value="/myTest1",headers = {"!aa"})
    public void myTest1(){
        System.out.println("headMapping,myTest1!");
    }

    /**
     * 理论上不支持这个格式,表示请求头中必须有aa,但是值时多少无所谓
     */
    @RequestMapping(value="/myTest2",headers = {"aa"})
    public void myTest2(){
        System.out.println("headMapping,myTest2");
    }

    @RequestMapping(value = "/myTest3",headers = {"aa=bb"})
    public void  myTest3(){
        System.out.println("headMapping,myTest3");
    }


    @RequestMapping(value = "/myTest4",headers = {"aa!=bb"})
    public void  myTest4(){
        System.out.println("headMapping,myTest4");
    }
}
