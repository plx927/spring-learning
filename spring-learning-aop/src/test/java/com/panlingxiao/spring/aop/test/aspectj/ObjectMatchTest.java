package com.panlingxiao.spring.aop.test.aspectj;

import com.panlingxiao.spring.aop.log.Logable;
import com.panlingxiao.spring.aop.test.AopBaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ObjectMatchTest extends AopBaseTest {

    @Autowired
    private Logable logUtil;

    @Test
    public void testLogUtil() {
        logUtil.log();
    }
}
