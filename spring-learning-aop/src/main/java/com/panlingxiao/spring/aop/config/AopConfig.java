package com.panlingxiao.spring.aop.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "com.panlingxiao.spring.aop")
/*
 * Enables the use of the @AspectJ style of Spring AOP
 *
 * proxy-target-class:
 *  Are class-based (CGLIB) proxies to be created? By default,
 *  standard Java interface-based proxies are created.
 */
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AopConfig {

}
