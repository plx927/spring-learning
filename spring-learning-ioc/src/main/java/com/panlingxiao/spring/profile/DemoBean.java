package com.panlingxiao.spring.profile;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DemoBean {

    public DemoBean(String content) {
        log.info("content:{}", content);
    }
}
