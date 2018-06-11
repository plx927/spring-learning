package com.panlingxiao.spring.aop.pointcut;

import com.panlingxiao.spring.aop.service.Waiter;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.DynamicMethodMatcherPointcut;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

/**
 * 动态方法切点，会根据方法的具体参数对连接点进行匹配
 * Created by panlingxiao on 2018/6/10.
 */
public class GreetingDynamicMethodMatcherPointcut extends DynamicMethodMatcherPointcut {

    private List<String> specialClientList = Arrays.asList("John", "Tom");

    @Override
    public ClassFilter getClassFilter() {
        return Waiter.class::isAssignableFrom;
    }

    @Override
    public boolean matches(Method method, Class<?> targetClass) {
        return "greetTo".equals(method.getName());
    }

    @Override
    public boolean matches(Method method, Class<?> targetClass, Object... args) {
        System.out.println("动态参数匹配");
        String name = (String) args[0];
        return specialClientList.contains(name);
    }

}
