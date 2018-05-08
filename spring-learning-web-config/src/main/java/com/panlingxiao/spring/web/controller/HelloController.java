package com.panlingxiao.spring.web.controller;

import com.panlingxiao.spring.web.vo.DemoObj;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
public class HelloController {

    @RequestMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("key", "hello world");
        return "hello";
    }

    @RequestMapping("/getObj")
    @ResponseBody
    public DemoObj getObj() {
        DemoObj demoObj = new DemoObj();
        demoObj.setId(123);
        demoObj.setName("world");
        return demoObj;
    }
}
