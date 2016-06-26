package com.panlingxiao.spring.learning.webmvc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by panlingxiao on 2016/6/20.
 */
//@RequestMapping("/aa")
//@Controller
public class TestController {
    private static Logger LOG = LoggerFactory.getLogger(TestController.class);

    //最后都会被转换成RequestMappingInfo
    @RequestMapping(value={"/test","abc","def"},method= RequestMethod.GET)
    public String test(Model model,HttpServletRequest request){
        LOG.info("Handler 执行!!!");
        model.addAttribute("test", "test");
        Object val = request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
        System.out.println(val);
        return "test";
    }

    @RequestMapping(value="test1",method= RequestMethod.GET)
    public String test1(Model model){
        LOG.info("Handler 执行!!!");
        model.addAttribute("test1", "test1");
        return "test1";
    }

    @RequestMapping(value="/test**",method = RequestMethod.GET)
    public String test2(Model model){
        LOG.info("Handler 执行!!!");
        return "test2";
    }

    public String other(){
        return "";
    }


}
