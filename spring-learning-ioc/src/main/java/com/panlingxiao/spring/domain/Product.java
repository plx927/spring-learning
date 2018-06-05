package com.panlingxiao.spring.domain;


import com.panlingxiao.spring.service.FunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

import java.util.Date;

@Configurable(preConstruction = true)
public class Product {

    private final String name;
    private final String description;
    private final Date createDate;
    private Status status;
    private Date saleDate;
    @Autowired
    private FunctionService functionService;


    public Product(String name, String description) {
        this.name = name;
        this.description = description;
        this.status = Status.PENDING;
        this.createDate = functionService.getCurrentDate();
    }

    public static enum Status {
        PENDING, SALE;

    }


}
