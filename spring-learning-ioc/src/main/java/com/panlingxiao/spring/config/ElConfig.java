package com.panlingxiao.spring.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@ComponentScan(basePackages = "com.panlingxiao.spring.el")
@PropertySource("app.properties")
@Data
public class ElConfig {

    /**
     * 注入普通字符串
     */
    @Value("Hello World!")
    private String normalStr;

    @Value("#{systemProperties['os.name']}")
    private String osName;

    @Value("#{T(java.lang.Math).random() * 100}")
    private double number;

    @Value("#{demoElService.name}")
    private String anotherName;

    @Value("${book.author}")
    private String author;



}
