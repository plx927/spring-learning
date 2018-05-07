package com.panlingxiao.spring.async;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Slf4j
public class AsyncApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(AsyncConfig.class);
        ctx.refresh();
        AsyncTaskService asyncTaskService = ctx.getBean("asyncTaskService", AsyncTaskService.class);
        asyncTaskService.createUser();
        asyncTaskService.sendMsg().addCallback(new ListenableFutureCallback<String>() {
            @Override
            public void onFailure(Throwable ex) {
                log.error("execute fail:", ex);
                ctx.close();
            }

            @Override
            public void onSuccess(String result) {
                log.info("result:{}", result);
                ctx.close();
            }
        });
        asyncTaskService.log();
    }
}
