package com.panlingxiao.spring.aop.advisor;

import org.aopalliance.aop.Advice;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.StaticMethodMatcherPointcutAdvisor;

import java.lang.reflect.Method;

/**
 * 自定义Advisor
 *
 * @author panlingxiao
 */
public class MyStaticMethodPointcutAdvisor extends StaticMethodMatcherPointcutAdvisor {

    private AspectJExpressionPointcut pointcut;

    public MyStaticMethodPointcutAdvisor(Advice advice, String pointcutExpression) {
        super(advice);
        this.pointcut = new AspectJExpressionPointcut();
        this.pointcut.setExpression(pointcutExpression);
    }


    @Override
    public boolean matches(Method method, Class<?> targetClass) {
        return pointcut.matches(method, targetClass);
    }
}
