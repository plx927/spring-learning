package com.panlingxiao.spring.aop.advice;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.IntroductionInfo;
import org.springframework.aop.IntroductionInterceptor;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by panlingxiao on 2018/6/25.
 */
public class LockAdvice implements IntroductionInterceptor, IntroductionInfo, Lockable {

    private boolean lock;

    Set<Class<?>> classes = new HashSet<>();

    public LockAdvice() {
        classes.add(Lockable.class);
    }

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        Method method = invocation.getMethod();
        System.out.println("invoke method,method:" + invocation.getMethod());

        // if the invoked method is on an introduced interface,
        // the introduction interceptor is responsible for handling the method call - it cannot invoke proceed().
        if (implementsInterface(method.getDeclaringClass())) {
            return method.invoke(this, invocation.getArguments());
        }

        // 如果已经执行了lock，并且当前要执行set方法，则抛异常
        if (lock) {
            throw new RuntimeException("Method is lock");
        }

        return invocation.proceed();
    }

    @Override
    public Class<?>[] getInterfaces() {
        // 返回在目标类引介了哪些新的接口
        return classes.toArray(new Class[classes.size()]);
    }

    /**
     * 判断Introduction Advice是否实现了给定的接口，Spring内部会调用getInterfaces()方法，
     * 然后调用该方法来判断Introduction Advice是否实现了这些接口
     *
     * @param intf
     * @return
     */
    @Override
    public boolean implementsInterface(Class<?> intf) {
        return classes.contains(intf);
    }

    @Override
    public void lock() {
        lock = true;
    }

    @Override
    public void unlock() {
        lock = false;
    }

    @Override
    public boolean locked() {
        return lock;
    }


}
