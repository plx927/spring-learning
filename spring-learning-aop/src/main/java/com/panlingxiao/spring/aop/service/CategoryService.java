package com.panlingxiao.spring.aop.service;


import com.panlingxiao.spring.aop.annotation.LogAction;
import com.panlingxiao.spring.aop.bean.Category;

import java.util.List;

public interface CategoryService {

    @LogAction(name = "addCategory")
    void addCategory();

    @LogAction(name = "listCategories")
    List<Category> listCategories();
}
