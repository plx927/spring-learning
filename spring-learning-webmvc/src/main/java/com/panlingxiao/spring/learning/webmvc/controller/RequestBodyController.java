package com.panlingxiao.spring.learning.webmvc.controller;

import com.panlingxiao.spring.learning.webmvc.domain.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by panlingxiao on 2016/7/6.
 */
@Controller
@RequestMapping("/requestBody")
public class RequestBodyController {


    @RequestMapping("/myTest1")
    @ResponseBody
    public Person myTest1(@RequestBody Person person){
        return person;
    }


}
