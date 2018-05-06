package com.panlingxiao.spring.el;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Data
public class DemoElService {

    @Value("zhangsan")
    private String name;
}
