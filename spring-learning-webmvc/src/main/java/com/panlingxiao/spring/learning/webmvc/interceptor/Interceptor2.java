package com.panlingxiao.spring.learning.webmvc.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by panlingxiao on 2016/6/20.
 */
public class Interceptor2 extends HandlerInterceptorAdapter{

    private static final Logger LOG = LoggerFactory.getLogger(Interceptor2.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        LOG.info("Interceptor2 preHandle!!!");
        return super.preHandle(request, response, handler);
    }

    /**
     * 当没有HandlerMethod与请求的URL匹配时,而拦截器可以拦截请求,那么此时传入的ModelAndView就为null
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        LOG.info("Interceptor2 postHandle");
        modelAndView.addObject("interceptor2","interceptor2");
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        LOG.info("Interceptor2 afterCompletion");
        super.afterCompletion(request, response, handler, ex);
    }
}
