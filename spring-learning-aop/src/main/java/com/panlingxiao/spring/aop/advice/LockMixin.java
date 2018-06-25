package com.panlingxiao.spring.aop.advice;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;

/**
 * Created by panlingxiao on 2018/6/25.
 */
public class LockMixin extends DelegatingIntroductionInterceptor implements Lockable {
    private boolean locked;

    public void lock() {
        this.locked = true;
    }

    public void unlock() {
        this.locked = false;
    }

    public boolean locked() {
        return this.locked;
    }

    public Object invoke(MethodInvocation invocation) throws Throwable {
        if (implementsInterface(invocation.getMethod().getDeclaringClass())) {
            return invocation.getMethod().invoke(this, invocation.getArguments());
        }
        if (locked()) {
            throw new RuntimeException("method is lock");
        }
        return super.invoke(invocation);
    }
}
