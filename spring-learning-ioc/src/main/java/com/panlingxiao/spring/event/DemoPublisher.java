package com.panlingxiao.spring.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class DemoPublisher {

    @Autowired
    private ApplicationContext applicationContext;

    public void publish(String message) {
        ApplicationEvent event = new DemoEvent(this, message);
        log.info("publish event");
        applicationContext.publishEvent(event);
    }
}
