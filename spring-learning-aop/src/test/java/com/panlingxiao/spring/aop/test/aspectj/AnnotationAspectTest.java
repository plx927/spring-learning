package com.panlingxiao.spring.aop.test.aspectj;

import com.panlingxiao.spring.aop.service.CategoryService;
import com.panlingxiao.spring.aop.service.ProductService;
import com.panlingxiao.spring.aop.test.AopBaseTest;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * Created by panlingxiao on 2018/7/21.
 */
public class AnnotationAspectTest extends AopBaseTest {

    @Resource
    private CategoryService categoryService;

    @Resource
    private ProductService productService;


    @Test
    public void testCategoryService() {
        categoryService.addCategory();
        System.out.println("--------------------");
        categoryService.listCategories();
    }


    @Test
    public void testProductService() {
        productService.addProduct();
        System.out.println("--------------------");
        productService.addProduct("hello");
        System.out.println("--------------------");
        productService.deleteProduct();
    }
}
