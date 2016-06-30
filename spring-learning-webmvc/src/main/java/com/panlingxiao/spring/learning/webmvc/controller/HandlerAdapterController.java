package com.panlingxiao.spring.learning.webmvc.controller;

import com.panlingxiao.spring.learning.webmvc.domain.Person;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

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

    @RequestMapping("/exception")
    public void testException(){
        throw  new RuntimeException("测试抛个异常");
    }

    /**
     * 通过@ResponseStatus直接响应结果
     */
    @ResponseStatus(value = HttpStatus.NOT_FOUND,reason = "找不到女朋友!")
    @RequestMapping("/response")
    public void testResponseStatus(Model model,ModelMap modelMap){

    }

    /**
     * 测试RequestMappingHandlerAdapter使用什么参数解析器来完成Bean的自动创建
     * 底层实际使用的是ServletModelAttributeMethodProcessor
     * @param p
     */
    @RequestMapping("/createBean")
    public void testCreateBean(Person p){
        System.out.println(p);
    }


    @RequestMapping("/simpleTypeMapping")
    public void testSimpleTypeMapping(String abc){
        System.out.println(abc);
    }

}
