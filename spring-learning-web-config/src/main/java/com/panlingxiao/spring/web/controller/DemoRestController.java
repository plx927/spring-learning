package com.panlingxiao.spring.web.controller;


import com.panlingxiao.spring.web.vo.DemoObj;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.http.MediaType.APPLICATION_XML_VALUE;

@RestController
public class DemoRestController {

    @GetMapping(name = "/getJson", produces = APPLICATION_JSON_UTF8_VALUE)
    public DemoObj getJson() {
        DemoObj demoObj = new DemoObj();
        demoObj.setName("张三");
        demoObj.setId(123);
        return demoObj;
    }


    @GetMapping(name = "/getXml", produces = APPLICATION_XML_VALUE)
    public DemoObj getXml() {
        DemoObj demoObj = new DemoObj();
        demoObj.setName("李四");
        demoObj.setId(123);
        return demoObj;
    }


}
