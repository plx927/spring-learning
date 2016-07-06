package com.panlingxiao.spring.learning.webmvc.controller;

import com.panlingxiao.spring.learning.webmvc.domain.Person;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * Created by panlingxiao on 2016/7/6.
 */
@Controller
@RequestMapping("/responseBody")
public class ResponseBodyController {


    /**
     * 使用JAXB生成XML
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/myTest1", produces = {MediaType.APPLICATION_XML_VALUE})
    public Person myTest1() {
        Person person = new Person();
        person.setName("你妹");
        person.setAge(99);
        person.setBirth(new Date());
        return person;
    }


    /**
     * 设置Http响应的Content-Type为JSON
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/myTest2", produces = {MediaType.APPLICATION_JSON_VALUE})
    public Person myTest2() {
        Person person = new Person();
        person.setName("你妹");
        person.setAge(99);
        person.setBirth(new Date());
        return person;
    }


    /**
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/myTest3")
    public Person myTest3() {
        Person person = new Person();
        person.setName("hello world");
        person.setAge(99);
        person.setBirth(new Date());
        return person;
    }


}
