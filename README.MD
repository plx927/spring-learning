# spring-learning
个人对Spring框架的复习以及源码分析


#### FrameWorkServlet
根据你的配置信息(contextConfigLocation)的路径(WEB-INF/'servlet-name'-dispatcherServlet.xml)去创建WebApplicationContext。


#### HandlerMapping
```
    <!--默认会添加两个HandlerMapping
        BeanNameUrlHandlerMapping
        RequestMappingHandlerMappping
        
    -->
       <mvc:annotation-driven/>
```
如果在上下文中没有找到具体的HandlerMapping的话，从DispatcherServlet.properties文件中去获取HadnelrMapping的名字，然后通过反射来创建默认的HandlerMappping。

具体实现：
org.springframework.web.servlet.HandlerMapping=
org.springframework.web.servlet.handler.BeanNameUrlHandlerMapping
org.springframework.web.servlet.mvc.annotation.DefaultAnnotationHandlerMapping

