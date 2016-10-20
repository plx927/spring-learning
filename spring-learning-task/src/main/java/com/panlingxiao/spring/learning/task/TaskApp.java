package com.panlingxiao.spring.learning.task;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by panlingxiao on 2016/10/20.
 */
public class TaskApp {

    public static void main(String[] args) {
        new ClassPathXmlApplicationContext("classpath:task.xml");
    }
}
