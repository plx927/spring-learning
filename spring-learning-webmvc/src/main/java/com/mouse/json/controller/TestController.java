package com.mouse.json.controller;

import com.panlingxiao.spring.learning.webmvc.domain.ParamBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Mahone Wu on 2016/7/19.
 */
@Controller
@RequestMapping("/test")
public class TestController {

    @RequestMapping(value = "/json")
    public void toTests(@ModelAttribute ParamBean paramBean){
        System.out.println(paramBean);
        System.out.println("123");
    }
}
