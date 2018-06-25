package com.panlingxiao.spring.aop.test.pointcut;

import com.panlingxiao.spring.aop.annotation.LogAction;
import com.panlingxiao.spring.aop.service.CategoryService;
import com.panlingxiao.spring.aop.service.ProductService;
import com.panlingxiao.spring.aop.service.impl.CategoryServiceImpl;
import com.panlingxiao.spring.aop.service.impl.ProductServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.MethodMatcher;
import org.springframework.aop.Pointcut;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.*;
import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;

import java.lang.reflect.Method;
import java.util.List;

@Slf4j
public class PointcutTest {


    @Test
    public void tesNameMatchMethodPointcut() {
        NameMatchMethodPointcut pointcut = new NameMatchMethodPointcut();
        // 匹配所有add开头的方法,*代表任意字符
        pointcut.addMethodName("add*");

        ClassFilter classFilter = pointcut.getClassFilter();
        MethodMatcher methodMatcher = pointcut.getMethodMatcher();

        // NameMatchMethodPointcut的ClassFilter不会对Class进行过滤，因此总是返回true，它只会对方法进行拦截
        Assert.assertTrue(classFilter.matches(ProductService.class));
        Assert.assertTrue(classFilter.matches(Object.class));
        Assert.assertTrue(classFilter.matches(String.class));
        Assert.assertTrue(classFilter.matches(List.class));

        Method[] methods = ProductService.class.getDeclaredMethods();
        for (Method method : methods) {
            if (method.getName().startsWith("add")) {
                // 如果方法以add开头，则方法匹配成功
                Assert.assertTrue(methodMatcher.matches(method, ProductService.class));
                log.info("method match success,method is:{}", method);
            } else {
                Assert.assertFalse(methodMatcher.matches(method, ProductService.class));
                log.warn("method match fail,method is:{}", method);
            }
        }
    }


    @Test
    public void testJdkRegexpMethodPointcut() {
        JdkRegexpMethodPointcut pointcut = new JdkRegexpMethodPointcut();
        // 这里可以设置多个正则表达式
        pointcut.setPatterns(".*del.*");
        ClassFilter classFilter = pointcut.getClassFilter();

        // 与NameMatchMethodPointcut类似，其ClassFilter匹配默认总是为true
        Assert.assertTrue(classFilter.matches(ProductService.class));
        Assert.assertTrue(classFilter.matches(Object.class));
        Assert.assertTrue(classFilter.matches(String.class));
        Assert.assertTrue(classFilter.matches(List.class));


        MethodMatcher methodMatcher = pointcut.getMethodMatcher();
        Method[] methods = ProductService.class.getDeclaredMethods();

        for (Method method : methods) {
            if (method.getName().startsWith("del")) {
                Assert.assertTrue(methodMatcher.matches(method, ProductService.class));
                log.info("method match success,method is:{}", method);
            } else {
                Assert.assertFalse(methodMatcher.matches(method, ProductService.class));
                log.warn("method match fail,method is:{}", method);
            }
        }
    }

    @Test
    public void testComposablePointcut() {

        ClassFilter classFilter1 = ProductService.class::isAssignableFrom;
        ClassFilter classFilter2 = CategoryService.class::isAssignableFrom;

        // 将两个ClassFilter取交、并集运算组合，形成一个新的Pointcut
        ComposablePointcut pointcut = new ComposablePointcut().intersection(classFilter1).union(classFilter2);

        Assert.assertTrue(pointcut.getClassFilter().matches(ProductServiceImpl.class));
        Assert.assertTrue(pointcut.getClassFilter().matches(CategoryServiceImpl.class));
        Assert.assertFalse(pointcut.getClassFilter().matches(String.class));
        Assert.assertFalse(pointcut.getClassFilter().matches(List.class));


        NameMatchMethodPointcut pointcut1 = new NameMatchMethodPointcut();
        pointcut1.setMappedName("add*");

        JdkRegexpMethodPointcut pointcut2 = new JdkRegexpMethodPointcut();
        pointcut2.setPatterns(".+del.*");

        // 进行并集运算,新返回的Pointcut既可以匹配add开头的方法，也可以匹配del开头的方法
        Pointcut newPointcut = Pointcuts.union(pointcut1, pointcut2);
        Assert.assertEquals(ComposablePointcut.class, newPointcut.getClass());
        MethodMatcher methodMatcher = newPointcut.getMethodMatcher();

        Method[] methods = ProductService.class.getMethods();
        for (Method method : methods) {
            Assert.assertTrue(methodMatcher.matches(method, ProductService.class));
        }


        // 测试MethodMatcher之间的交、并
        ComposablePointcut composablePointcut = new ComposablePointcut(pointcut1.getMethodMatcher()).union(pointcut2.getMethodMatcher());
        MethodMatcher methodMatcher2 = composablePointcut.getMethodMatcher();
        for (Method method : methods) {
            Assert.assertTrue(methodMatcher2.matches(method, ProductService.class));
        }

    }

    @Test
    public void testControlFlowPointcut() {
        ControlFlowPointcut pointcut = new ControlFlowPointcut(PointcutTest.class);
        Assert.assertTrue(pointcut.matches(null, PointcutTest.class, new Object[]{}));
    }


    @Test
    public void testAnnotationMethodPointcut() {

        // 默认是根据Class查找注解
        AnnotationMatchingPointcut annotationMatchingPointcut = new AnnotationMatchingPointcut(LogAction.class);
        // 由于只有ProductService上声明了注解，因此只有ProductService返回true
        Assert.assertTrue(annotationMatchingPointcut.getClassFilter().matches(ProductService.class));
        Assert.assertFalse(annotationMatchingPointcut.getClassFilter().matches(CategoryService.class));
        Assert.assertFalse(annotationMatchingPointcut.getClassFilter().matches(ProductServiceImpl.class));


        // 第二个参数设置为true,就会到当前Class的父类或者实现的接口上去查找注解是否存在
        AnnotationMatchingPointcut annotationMatchingPointcut2 = new AnnotationMatchingPointcut(LogAction.class, true);
        Assert.assertTrue(annotationMatchingPointcut2.getClassFilter().matches(ProductService.class));
        Assert.assertFalse(annotationMatchingPointcut2.getClassFilter().matches(CategoryService.class));
        Assert.assertTrue(annotationMatchingPointcut2.getClassFilter().matches(ProductServiceImpl.class));


        // 根据Method查找LogAction注解
        AnnotationMatchingPointcut annotationMatchingPointcut3 = AnnotationMatchingPointcut.forMethodAnnotation(LogAction.class);
        Method[] methods = ProductService.class.getMethods();
        for (Method method : methods) {
            Assert.assertFalse(annotationMatchingPointcut3.getMethodMatcher().matches(method, method.getDeclaringClass()));
        }


        // Category的方法上都有LogAction，因此匹配都成功
        methods = CategoryService.class.getMethods();
        for (Method method : methods) {
            Assert.assertTrue(annotationMatchingPointcut3.getMethodMatcher().matches(method, method.getDeclaringClass()));
        }
    }


    @Test
    public void testAspectJPointCut() {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        // 设置AspectJ表达式
        pointcut.setExpression("within(com.panlingxiao.spring.aop.service..*)");

        // 针对所有com.panlingxiao.spring.aop.service包及其子包下都会匹配
        ClassFilter classFilter = pointcut.getClassFilter();
        Assert.assertTrue(classFilter.matches(ProductService.class));
        Assert.assertTrue(classFilter.matches(ProductServiceImpl.class));
        Assert.assertTrue(classFilter.matches(CategoryService.class));
        Assert.assertTrue(classFilter.matches(CategoryServiceImpl.class));
        Assert.assertFalse(classFilter.matches(String.class));
        MethodMatcher methodMatcher = pointcut.getMethodMatcher();


        // 由于方法是任意方法，所以方法匹配都是成功的
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
