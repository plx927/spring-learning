package com.panlingxiao.spring.learning.webmvc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by panlingxiao on 2016/6/20.
 */
@Controller
public class TestController {
    private static Logger LOG = LoggerFactory.getLogger(TestController.class);

    @RequestMapping(value="/test",method= RequestMethod.GET)
    public String test(Model model){
        LOG.info("Handler 执行!!!");
        model.addAttribute("test","test");
        return "test";
    }

    @RequestMapping(value="test1",method= RequestMethod.GET)
    public String test1(Model model){
        LOG.info("Handler 执行!!!");
        model.addAttribute("test1","test1");
        return "test1";
    }

    @RequestMapping(value="/test**",method = RequestMethod.GET)
    public String test2(Model model){
        LOG.info("Handler 执行!!!");
        return "test2";
    }


}
