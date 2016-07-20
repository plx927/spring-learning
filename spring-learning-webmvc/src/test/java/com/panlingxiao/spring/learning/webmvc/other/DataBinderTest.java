package com.panlingxiao.spring.learning.webmvc.other;

import com.panlingxiao.spring.learning.webmvc.domain.Person;
import org.junit.Test;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.validation.DataBinder;

/**
 * Created by panlingxiao on 2016/6/28.
 */
public class DataBinderTest {

    @Test
    public void testBind1(){
        Person p = new Person();
        DataBinder dataBinder = new DataBinder(p);
       //设置是否忽略未知的属性
       // dataBinder.setIgnoreUnknownFields(false);
        MutablePropertyValues mutablePropertyValues = new MutablePropertyValues();
        mutablePropertyValues.add("name","aa");
        mutablePropertyValues.add("age","12");
        mutablePropertyValues.add("age12","12");
        mutablePropertyValues.add("hobby","sing,dance");
        dataBinder.bind(mutablePropertyValues);
        System.out.println(p);
    }
}
