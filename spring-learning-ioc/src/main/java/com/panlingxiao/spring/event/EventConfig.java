package com.panlingxiao.spring.event;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.panlingxiao.spring.event")
@Data
public class EventConfig {

    @Autowired
    private ApplicationContext applicationContext;
}
