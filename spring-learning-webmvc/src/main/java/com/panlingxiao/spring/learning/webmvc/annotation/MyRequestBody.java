package com.panlingxiao.spring.learning.webmvc.annotation;

import java.lang.annotation.*;

/**
 * Created by panlingxiao on 2016/7/20.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
@Documented
public @interface MyRequestBody {
    /**
     * Whether body content is required.
     * <p>Default is {@code true}, leading to an exception thrown in case
     * there is no body content. Switch this to {@code false} if you prefer
     * {@code null} to be passed when the body content is {@code null}.
     */
    boolean required() default true;
}
