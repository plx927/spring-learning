package com.panlingxiao.spring.learning.webmvc.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by panlingxiao on 2016/6/28.
 * 使用@ControllerAdvice会应用到所有的Handler之上
 */
@Component
@ControllerAdvice
public class AdviceController {

//    /**
//     * 当HandlerMethod有参数时才会被调用
//     * @param dataBinder
//     * @param request
//     */
//    @InitBinder
//    public void initBinder(WebDataBinder dataBinder,HttpServletRequest request){
//        System.out.println("controller Advice:init Binder");
//        System.out.println(request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE));
//    }

    /**
     * 总是会被调用
     * @param request
     */
    @ModelAttribute
    public void initModel(HttpServletRequest request){
        System.out.println("controller Advice:init Model");
        System.out.println(request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE));
    }

//    @ExceptionHandler(Exception.class)
//    public void handleException(Exception e){
//        System.out.println("抛出异常:"+e);
//    }
}
