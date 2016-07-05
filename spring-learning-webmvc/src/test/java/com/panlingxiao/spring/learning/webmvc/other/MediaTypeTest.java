package com.panlingxiao.spring.learning.webmvc.other;

import org.junit.Test;
import org.springframework.http.MediaType;

/**
 * Created by panlingxiao on 2016/7/5.
 */
public class MediaTypeTest {

    @Test
    public void testParseMediaType(){
        MediaType mediaType = MediaType.parseMediaType("applciation/json");
        System.out.println(mediaType);
    }
}
