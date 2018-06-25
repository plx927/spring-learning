package com.panlingxiao.spring.aop.service.impl;

import com.panlingxiao.spring.aop.annotation.LogAction;
import com.panlingxiao.spring.aop.service.ProductService;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @LogAction(name = "abc")
    @Override
    public void addProduct() {
        System.out.println("add product");
    }

    @Override
    public void addProduct(String product) {

    }

    @Override
    public void deleteProduct() {
        System.out.println("delete product");
    }
}
