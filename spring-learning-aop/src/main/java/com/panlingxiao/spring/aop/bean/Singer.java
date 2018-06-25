package com.panlingxiao.spring.aop.bean;

import java.util.Objects;

/**
 * Created by panlingxiao on 2018/6/25.
 */
public class Singer {

    public String sing(String song) {
        if (Objects.isNull(song)) {
            throw new IllegalArgumentException("song is null");
        }
        System.out.println("sing a song,song is:" + song);
        return "sing song";
    }


}
