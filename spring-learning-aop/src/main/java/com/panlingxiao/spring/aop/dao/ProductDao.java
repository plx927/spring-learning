package com.panlingxiao.spring.aop.dao;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
public class ProductDao {

    public void addProduct() {
        log.info("ProductDao addd product");
    }

    public void deleteProduct() {
        log.info("ProductDao delete product");
    }

}
