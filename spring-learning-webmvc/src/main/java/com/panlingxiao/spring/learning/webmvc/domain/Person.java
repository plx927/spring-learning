package com.panlingxiao.spring.learning.webmvc.domain;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import java.util.Date;

/**
 * Created by panlingxiao on 2016/6/27.
 */
@Data
public class Person {

    @NotBlank
    private String name;
    private int age;
    private Date birth;
}
