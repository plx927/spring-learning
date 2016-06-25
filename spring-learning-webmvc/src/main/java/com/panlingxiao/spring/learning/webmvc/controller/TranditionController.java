package com.panlingxiao.spring.learning.webmvc.controller;

import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by panlingxiao on 2016/6/25.
 * 使用传统的BeanNameUrlHandlerMapping进行对Http请求处理
 */
@org.springframework.stereotype.Controller("/hello")
public class TranditionController implements Controller{


    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Object val = request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
        System.out.println(val);
        return new ModelAndView("hello");
    }
}
