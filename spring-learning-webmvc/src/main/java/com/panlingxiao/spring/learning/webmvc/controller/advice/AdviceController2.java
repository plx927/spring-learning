package com.panlingxiao.spring.learning.webmvc.controller.advice;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;


/**
 * Created by panlingxiao on 2016/6/28.
 */
@Component
@ControllerAdvice
@Order(value=Integer.MIN_VALUE)
public class AdviceController2 {


}
