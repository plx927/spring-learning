package com.panlingxiao.spring.learning.webmvc.resolver.argument;

import com.panlingxiao.spring.learning.webmvc.annotation.MyRequestBody;
import com.panlingxiao.spring.learning.webmvc.param.MyMethodParameter;
import org.springframework.context.ApplicationContext;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodArgumentResolverComposite;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor;
import org.springframework.web.servlet.mvc.method.annotation.ServletModelAttributeMethodProcessor;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by panlingxiao on 2016/7/20.
 * 自定义参数解析器，可以同时适配application/x-www-form-urlencoded和JSON、XML等格式的数据
 */
public class MyMultiContentTypeArgumentResolver implements HandlerMethodArgumentResolver {

    private ServletModelAttributeMethodProcessor servletModelAttributeMethodProcessor;
    private RequestResponseBodyMethodProcessor requestResponseBodyMethodProcessor;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterAnnotation(MyRequestBody.class) != null;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        HttpServletRequest request = (HttpServletRequest) webRequest.getNativeRequest();
        ApplicationContext applicationContext = (ApplicationContext) request.getAttribute(DispatcherServlet.WEB_APPLICATION_CONTEXT_ATTRIBUTE);
        String contentType = request.getContentType();


        if (contentType != null) {
            if (MediaType.APPLICATION_FORM_URLENCODED_VALUE.equals(contentType) || contentType.startsWith(MediaType.MULTIPART_FORM_DATA_VALUE)) {
                if (servletModelAttributeMethodProcessor == null) {
                    RequestMappingHandlerAdapter requestMappingHandlerAdapter = applicationContext.getBean(RequestMappingHandlerAdapter.class);
                    HandlerMethodArgumentResolverComposite argumentResolvers = requestMappingHandlerAdapter.getArgumentResolvers();
                    List<HandlerMethodArgumentResolver> resolvers = argumentResolvers.getResolvers();
                    for (HandlerMethodArgumentResolver handlerMethodArgumentResolver : resolvers) {
                        Class<? extends HandlerMethodArgumentResolver> clazz = handlerMethodArgumentResolver.getClass();
                        if (clazz == ServletModelAttributeMethodProcessor.class) {
                            this.servletModelAttributeMethodProcessor = (ServletModelAttributeMethodProcessor) handlerMethodArgumentResolver;
                            break;
                        }
                    }
                }
                return servletModelAttributeMethodProcessor.resolveArgument(parameter, mavContainer, webRequest, binderFactory);
            } else {
                if (requestResponseBodyMethodProcessor == null) {
                    RequestMappingHandlerAdapter requestMappingHandlerAdapter = applicationContext.getBean(RequestMappingHandlerAdapter.class);
                    HandlerMethodArgumentResolverComposite argumentResolvers = requestMappingHandlerAdapter.getArgumentResolvers();
                    List<HandlerMethodArgumentResolver> resolvers = argumentResolvers.getResolvers();
                    for (HandlerMethodArgumentResolver handlerMethodArgumentResolver : resolvers) {
                        Class<? extends HandlerMethodArgumentResolver> clazz = handlerMethodArgumentResolver.getClass();
                        if (clazz == RequestResponseBodyMethodProcessor.class) {
                            this.requestResponseBodyMethodProcessor = (RequestResponseBodyMethodProcessor) handlerMethodArgumentResolver;
                            break;
                        }
                    }
                }
                MyMethodParameter myMethodParameter = new MyMethodParameter(parameter, parameter.getParameterAnnotation(MyRequestBody.class));
                return requestResponseBodyMethodProcessor.resolveArgument(myMethodParameter, mavContainer, webRequest, binderFactory);
            }
        }
        return null;
    }


}
