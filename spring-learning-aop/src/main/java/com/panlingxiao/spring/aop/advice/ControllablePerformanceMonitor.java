package com.panlingxiao.spring.aop.advice;

import com.panlingxiao.spring.aop.service.Monitorable;
import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;

import java.util.Objects;

/**
 * Created by panlingxiao on 2018/6/9.
 */
@Slf4j
public class ControllablePerformanceMonitor extends DelegatingIntroductionInterceptor implements Monitorable {

    private ThreadLocal<Boolean> monitorStatusMap = new ThreadLocal<>();


    @Override
    public void setMonitorActive(boolean active) {
        monitorStatusMap.set(active);
    }

    @Override
    public Object invoke(MethodInvocation mi) throws Throwable {
        Object result;
        if (Objects.nonNull(monitorStatusMap.get()) && monitorStatusMap.get()) {
            log.info("begin monitor");
            result = super.invoke(mi);
            log.info("after monitor");
        } else {
            result = super.invoke(mi);
        }
        return result;
    }
}
