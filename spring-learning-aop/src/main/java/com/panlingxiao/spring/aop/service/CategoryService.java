package com.panlingxiao.spring.aop.service;


import com.panlingxiao.spring.aop.bean.Category;

import java.util.List;

public interface CategoryService {

    void addCategory();


    List<Category> listCategories();
}
