package com.panlingxiao.spring.learning.webmvc.controller;

import com.panlingxiao.spring.learning.webmvc.domain.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * Created by panlingxiao on 2016/6/28.
 */
@Controller
@SessionAttributes("person")
@RequestMapping("/sessionAttr")
public class SessionAttributeController {

    @RequestMapping("/myTest1")
    public void myTest1(Person p){

    }

}
