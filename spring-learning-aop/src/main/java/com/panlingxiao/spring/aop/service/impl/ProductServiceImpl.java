package com.panlingxiao.spring.aop.service.impl;

import com.panlingxiao.spring.aop.annotation.LogAction;
import com.panlingxiao.spring.aop.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    @LogAction(name = "abc")
    @Override
    public void addProduct() {
        log.info("add product");
    }

    @Override
    public void addProduct(String product) {
        log.info("add product,product is {}", product);

    }

    @Override
    public void deleteProduct() {
        log.info("delete product");
    }
}
