package com.panlingxiao.spring.aop.service;

import com.panlingxiao.spring.aop.annotation.LogAction;

@LogAction(name = "ProductService")
public interface ProductService {

    void addProduct();

    void addProduct(String product);

    void deleteProduct();
}
