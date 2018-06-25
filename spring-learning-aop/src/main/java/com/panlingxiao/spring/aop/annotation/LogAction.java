package com.panlingxiao.spring.aop.annotation;

import java.lang.annotation.*;

@Documented
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface LogAction {
    String name();
}
