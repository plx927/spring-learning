package com.panlingxiao.spring.learning.webmvc.controller;

import com.panlingxiao.spring.learning.webmvc.annotation.MyRequestBody;
import com.panlingxiao.spring.learning.webmvc.domain.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by panlingxiao on 2016/7/20.
 */
@RequestMapping("/arguResolve")
@Controller
public class ArgumentResolveController {

    /**
     * 前端可以同时以表单方式提交也可以使用JSON/XML的方式来进行提交。
     * @param person
     */
    @RequestMapping("/myTest1")
    public void myTest1(@MyRequestBody Person person){
        System.out.println(person);
    }



}
