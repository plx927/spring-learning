package com.panlingxiao.spring.learning.webmvc.controller;

import com.panlingxiao.spring.learning.webmvc.domain.Person;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Date;

/**
 * Created by panlingxiao on 2016/6/27.
 */
@Controller
@RequestMapping("/handlerAdapter")
public class HandlerAdapterController {


    //最土的方法，通常不会用

    /*
     *  RequestMappingHandlerAdapter#getModelFactory方法中的处理，首选会去查找不使用@RequestMapping但是使用@ModelAttribute的方法。
     */
//    @InitBinder
//    public void initDataBind(DataBinder dataBinder) {
//        dataBinder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"), true));
//    }


    @RequestMapping(value = "/databind1")
    public void testDataBind1(Date date) {
        System.out.println(date);
    }

    @RequestMapping("/valid")
    public void testValidation(@Valid Person person,BindingResult errors){
        System.out.println("testValidation");
    }

}
