package com.panlingxiao.spring.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UseFunctionService {

    @Autowired
    private FunctionService functionService;

    public void setFunctionService(FunctionService functionService) {
        this.functionService = functionService;
    }

    public String sayHello(String name) {
        return functionService.sayHello(name);
    }
}
