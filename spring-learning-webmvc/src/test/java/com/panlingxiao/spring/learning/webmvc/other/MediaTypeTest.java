package com.panlingxiao.spring.learning.webmvc.other;

import org.junit.Test;
import org.springframework.http.InvalidMediaTypeException;
import org.springframework.http.MediaType;

import java.util.List;

/**
 * Created by panlingxiao on 2016/7/5.
 */
public class MediaTypeTest {

    @Test
    public void testParseMediaType() {
        MediaType mediaType = MediaType.parseMediaType("applciation/json");
        infoMediaType(mediaType);
    }

    /**
     * 分析MediaType的解析过程
     */
    @Test
    public void testPraseMediaType2() {
        //权重，范围为0-1，不写为1,application/json;charset=UTF-8;q=.9,applcation/xml;q=.8
        MediaType mediaType = MediaType.parseMediaType("application/json;charset=UTF-8;q=.9");
        infoMediaType(mediaType);

    }

    private void infoMediaType(MediaType mediaType) {
        System.out.println("type:" + mediaType.getType() + ",subType:" + mediaType.getSubtype() + ",attrs:" + mediaType.getParameters());
        System.out.println("charset:" + mediaType.getCharSet());
        System.out.println("quality:" + mediaType.getQualityValue());
    }

    /**
     * MediaType必须有/结尾
     */
    @Test(expected = InvalidMediaTypeException.class)
    public void testParseInvalidMediaType() {
        MediaType mediaType = MediaType.parseMediaType("application/");
        System.out.println("charset:" + mediaType.getCharSet());
    }


    /**
     * 解析Chrome浏览器发送的Http请求时，Accept的结果值
     */
    //text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8
    @Test
    public void testParseDefaultChromeMediaType() {
        //解析出5个MIME类型
        List<MediaType> mediaTypes = MediaType.parseMediaTypes("text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
        System.out.println(mediaTypes.size());
        for (MediaType mediaType : mediaTypes) {
            System.out.println(mediaType);
        }
    }

    /**
     * MediaType
     *
     */
    @Test(expected = InvalidMediaTypeException.class)
    public void testParseInvalid2MediaType2() {
        MediaType.parseMediaType("*/json");
    }

    @Test
    public void testParseMediaType3(){
        //type=application,subtype=*,
        MediaType mediaType = MediaType.parseMediaType("application/*;charset=utf-8");
        infoMediaType(mediaType);

        mediaType = MediaType.parseMediaType("*");
        //type=*,subtype=*,attr=null
        infoMediaType(mediaType);
    }








}
