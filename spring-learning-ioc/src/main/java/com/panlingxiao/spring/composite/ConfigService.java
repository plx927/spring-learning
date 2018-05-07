package com.panlingxiao.spring.composite;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ConfigService {

    public void say() {
        log.info("test annotation composite");
    }
}
