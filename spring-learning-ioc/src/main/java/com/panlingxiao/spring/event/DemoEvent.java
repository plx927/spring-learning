package com.panlingxiao.spring.event;

import lombok.Data;
import org.springframework.context.ApplicationEvent;

@Data
public class DemoEvent extends ApplicationEvent{
    private String message;
    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public DemoEvent(Object source,String message) {
        super(source);
        this.message = message;
    }
}
