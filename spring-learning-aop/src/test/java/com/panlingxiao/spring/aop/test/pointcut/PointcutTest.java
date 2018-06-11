package com.panlingxiao.spring.aop.test.pointcut;

import com.panlingxiao.spring.aop.service.CategoryService;
import com.panlingxiao.spring.aop.service.ProductService;
import com.panlingxiao.spring.aop.service.impl.CategoryServiceImpl;
import com.panlingxiao.spring.aop.service.impl.ProductServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.MethodMatcher;
import org.springframework.aop.Pointcut;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.*;

import java.lang.reflect.Method;

public class PointcutTest {


    @Test
    public void tesNameMatchMethodPointcut() {
        NameMatchMethodPointcut pointcut = new NameMatchMethodPointcut();
        // 匹配所有add开头的方法
        pointcut.addMethodName("add*");

        ClassFilter classFilter = pointcut.getClassFilter();
        MethodMatcher methodMatcher = pointcut.getMethodMatcher();
        Assert.assertTrue(classFilter.matches(ProductService.class));
        Method[] methods = ProductService.class.getDeclaredMethods();
        for (Method method : methods) {
            if (method.getName().startsWith("add")) {
                Assert.assertTrue(methodMatcher.matches(method, ProductService.class));
            } else {
                Assert.assertFalse(methodMatcher.matches(method, ProductService.class));
            }
        }
    }

    @Test
    public void testRegexPointcut() {
        JdkRegexpMethodPointcut pointcut = new JdkRegexpMethodPointcut();
        pointcut.setPatterns(ProductService.class.getName() + ".*");
        ClassFilter classFilter = pointcut.getClassFilter();
        MethodMatcher methodMatcher = pointcut.getMethodMatcher();
        Method[] methods = ProductService.class.getDeclaredMethods();
        Assert.assertTrue(classFilter.matches(ProductService.class));
        for (Method method : methods) {
            Assert.assertTrue(methodMatcher.matches(method, ProductService.class));
        }
    }

    @Test
    public void testComposablePointcut() {
        ClassFilter classFilter1 = ProductService.class::isAssignableFrom;
        ClassFilter classFilter2 = CategoryService.class::isAssignableFrom;
        Pointcut pointcut = new ComposablePointcut().union(classFilter1).union(classFilter2);
        Assert.assertTrue(pointcut.getClassFilter().matches(ProductServiceImpl.class));
        Assert.assertTrue(pointcut.getClassFilter().matches(CategoryServiceImpl.class));
    }

    @Test
    public void testControlFlowPointcut() throws Exception{
        ControlFlowPointcut pointcut = new ControlFlowPointcut(PointcutTest.class);
        Assert.assertTrue(pointcut.matches(null,PointcutTest.class,new Object[]{}));
    }


    @Test
    public void testAspectJPointCut() {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression("within(com.panlingxiao.spring.aop.service..*)");

        ClassFilter classFilter = pointcut.getClassFilter();
        Assert.assertTrue(classFilter.matches(ProductService.class));
        Assert.assertTrue(classFilter.matches(ProductServiceImpl.class));
        Assert.assertTrue(classFilter.matches(CategoryService.class));
        Assert.assertTrue(classFilter.matches(CategoryServiceImpl.class));
        Assert.assertFalse(classFilter.matches(String.class));
        MethodMatcher methodMatcher = pointcut.getMethodMatcher();

        Method[] methods = ProductService.class.getDeclaredMethods();
        Assert.assertTrue(classFilter.matches(ProductService.class));
        for (Method method : methods) {
            Assert.assertTrue(methodMatcher.matches(method, ProductService.class));
        }

        methods = CategoryService.class.getDeclaredMethods();
        Assert.assertTrue(classFilter.matches(ProductService.class));
        for (Method method : methods) {
            Assert.assertTrue(methodMatcher.matches(method, CategoryService.class));
        }
    }

}
