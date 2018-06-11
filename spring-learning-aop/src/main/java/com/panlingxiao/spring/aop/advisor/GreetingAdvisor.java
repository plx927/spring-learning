package com.panlingxiao.spring.aop.advisor;

import com.panlingxiao.spring.aop.service.Waiter;
import org.aopalliance.aop.Advice;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.StaticMethodMatcherPointcutAdvisor;

import java.lang.reflect.Method;

/**
 * Created by panlingxiao on 2018/6/9.
 */
public class GreetingAdvisor extends StaticMethodMatcherPointcutAdvisor {


    public GreetingAdvisor(Advice advice) {
        setAdvice(advice);
    }

    /**
     * 切点的方法匹配
     */
    @Override
    public boolean matches(Method method, Class<?> targetClass) {
        return "greetTo".equals(method.getName());
    }

    @Override
    public ClassFilter getClassFilter() {
        return Waiter.class::isAssignableFrom;
    }


}
