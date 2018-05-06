package com.panlingxiao.spring.aop.service.impl;

import com.panlingxiao.spring.aop.bean.Category;
import com.panlingxiao.spring.aop.log.Logable;
import com.panlingxiao.spring.aop.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService,Logable {
    @Override
    public void addCategory() {
        System.out.println("add category");
    }

    @Override
    public List<Category> listCategories() {
        System.out.println("list categories");
        return null;
    }

    @Override
    public void log() {
        System.out.println("log from categoryService");
    }
}
