package com.panlingxiao.spring.learning.webmvc.domain;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by panlingxiao on 2016/6/27.
 */
@Data
public class Person {

    @NotBlank
    private String name;
}
