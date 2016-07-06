package com.panlingxiao.spring.learning.webmvc.domain;

import com.thoughtworks.xstream.annotations.XStreamAliasType;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Date;

/**
 * Created by panlingxiao on 2016/6/27.
 */
@Data
@XmlRootElement
@XmlType(propOrder = {"birth","name","age"})
@XStreamAliasType("person")
public class Person {

    @NotBlank
    private String name;
    private int age;
    private Date birth;
}
