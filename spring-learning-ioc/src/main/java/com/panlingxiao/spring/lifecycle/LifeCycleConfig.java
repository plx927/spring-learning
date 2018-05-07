package com.panlingxiao.spring.lifecycle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LifeCycleConfig {

    @Bean(initMethod = "init",destroyMethod = "destroy")
    public BeanWayService beanWayService(){
        return new BeanWayService();
    }

    @Bean
    public JSR250WayService jsr250WayService(){
        return new JSR250WayService();
    }

}
