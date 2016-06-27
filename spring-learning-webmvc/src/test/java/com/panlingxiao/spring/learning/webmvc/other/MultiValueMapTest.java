package com.panlingxiao.spring.learning.webmvc.other;

import org.junit.Test;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.List;

/**
 * Created by panlingxiao on 2016/6/27.
 */
public class MultiValueMapTest {


    @Test
    public void testAddDataToMultiValueMap(){
        MultiValueMap map = new LinkedMultiValueMap();
        map.add("aa","123");
        map.add("aa", "456");
        List<Object> objs = (List<Object>) map.get("aa");
        System.out.println(objs+","+objs.getClass().getName());
    }
}
