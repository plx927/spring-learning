package com.panlingxiao.spring.service;

import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class FunctionService {

    public String sayHello(String name) {
        return String.format("Hello:%s!", name);
    }

    public Date getCurrentDate() {
        return new Date();
    }
}
