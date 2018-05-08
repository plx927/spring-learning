package com.panlingxiao.spring.web.vo;


import lombok.Data;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@Data
@XmlRootElement
@XmlType(propOrder = {"id","name"})
public class DemoObj {

    private int id;

    private String name;

}
