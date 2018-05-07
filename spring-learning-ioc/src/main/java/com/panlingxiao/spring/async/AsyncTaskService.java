package com.panlingxiao.spring.async;

import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.framework.AopContext;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class AsyncTaskService {

    public void createUser() {
        log.info("create User");
    }

    @Async("taskExecutor1")
    public ListenableFuture<String> sendMsg() {
        try {
            TimeUnit.SECONDS.sleep(3);
            log.info("send msg");
            return new AsyncResult<>("hello world");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void log() {
        log.info("log info");
    }

}
