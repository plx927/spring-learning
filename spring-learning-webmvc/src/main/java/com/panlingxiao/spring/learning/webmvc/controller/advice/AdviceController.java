package com.panlingxiao.spring.learning.webmvc.controller.advice;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;

/**
 * Created by panlingxiao on 2016/6/28.
 * 使用@ControllerAdvice会应用到所有的Handler之上
 * 它会被RequestMappingHandler通过方法进行反射，然后这些类会被其封装成ControllerAdviceBean
 */
@Component
@ControllerAdvice
@Order(value=Integer.MAX_VALUE)
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

//    /**
//     * 总是会被调用
//    * @param request
//    */
//    @ModelAttribute
//    public void initModel(HttpServletRequest request){
//        System.out.println("controller Advice:init Model");
//        System.out.println(request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE));
//    }



//    @ExceptionHandler(Exception.class)
//    public void handleException(Exception e){
//        System.out.println("抛出异常:"+e);
//    }
}
