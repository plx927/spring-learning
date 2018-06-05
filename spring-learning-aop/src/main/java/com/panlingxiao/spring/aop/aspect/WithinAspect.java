package com.panlingxiao.spring.aop.aspect;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class WithinAspect {


    /**
     * 针对某个具体类设置切入点
     */
    @Pointcut("within(com.panlingxiao.spring.aop.service.impl.ProductServiceImpl)")
    public void isProductService() {
    }

    /**
     * 针对包以及子包设置切入点
     */
    @Pointcut("within(com.panlingxiao.spring.aop.dao..*)")
    public void isDaoLayer() {
    }


    /**
     * 对productService的所有前置通知添加切面
     */
    @Before("isProductService()")
    public void serviceBeforeAdvice() {
        System.out.println("before productService invoke");
    }


    @AfterReturning(pointcut = "isDaoLayer()")
    public void serviceAfterAdvice() {
        log.info("after daoLayer invoke");
    }

}
