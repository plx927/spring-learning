package com.panlingxiao.spring.learning.webmvc.controller;

import com.panlingxiao.spring.learning.webmvc.domain.Person;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by panlingxiao on 2016/6/28.
 */
@RequestMapping("/dataBind")
@Controller
public class DataBinderController {


    @InitBinder(value="person1")
    public void initBinder(Locale locale,WebDataBinder dataBinder){
        System.out.println(locale.getCountry()+","+locale.getDisplayName());
        //PropertyEditor非线程安全，因此会导致每次请求都会创建一次
        dataBinder.registerCustomEditor(Date.class,new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"),true));
    }

    @RequestMapping("/myTest1")
    @ResponseBody
    public Person myTest1(Person p){
        System.out.println(p);
        return  p;
    }



}
