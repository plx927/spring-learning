package com.panlingxiao.spring.learning.webmvc.other;

import com.panlingxiao.spring.learning.webmvc.domain.Person;
import org.junit.Test;
import org.springframework.beans.BeanUtils;

/**
 * Created by panlingxiao on 2016/6/29.
 */
public class BeanUtilsTest {


    @Test
    public void testIsSimpleType(){
        boolean result = BeanUtils.isSimpleProperty(Person.class);
        System.out.println(result);
    }


}
