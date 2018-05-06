package com.panlingxiao.spring.service;

import org.springframework.stereotype.Service;

@Service
public class FunctionService {

    public String sayHello(String name) {
        return String.format("Hello:%s!", name);
    }
}
