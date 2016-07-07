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

参考SpringFramework文档---22.4 Handler mappings


##### ConsumesRequestCondition
ConsumeRequestCondition用于匹配Http请求头中的Content-Type，判断服务器端是否能对客户端发送的Http数据进行消费处理。
一个ConsumeRequestCondition中的信息最后会对应一个或者多个ConsumeMediaTypeExpression

SpringMVC对于Contetn-Type的匹配检查其实本质上有两个地方:
1.第一个地方是在RequestMappingHandlerMapping根据@RequestMapping中配置的header(Content-Type)以及consumes来和HttpServletRequest中的Content-Type进行匹配。
2.第二个地方是在RequestMappingHandlerAdapter中使用HandlerMethodArgumentResolver时，
  HandlerMethodArgumentResolver使用HttpMessageConverter完成方法参数绑定的时候，同样需要根据HttpServletRequest的Content-Type进行检查。






