package com.panlingxiao.spring.aop.test.proxy.cglib;

import com.panlingxiao.spring.aop.proxy.RealSubject;
import com.panlingxiao.spring.aop.proxy.Subject;
import com.panlingxiao.spring.aop.proxy.cglib.CGLibProxy;
import org.springframework.cglib.core.DebuggingClassWriter;

/**
 * CGLIb代理测试
 */
public class CGLibProxyTest {


    public static void main(String[] args) {
        // 保存CGLIb所生成子类的Class文件
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, ".");
        System.setProperty("net.sf.cglib.core.DebuggingClassWriter.traceEnabled","true");
        Subject subject = CGLibProxy.getProxy(new RealSubject());
        subject.sayHello("cglib proxy");
        System.out.println(subject.getClass().getName());
    }
}
