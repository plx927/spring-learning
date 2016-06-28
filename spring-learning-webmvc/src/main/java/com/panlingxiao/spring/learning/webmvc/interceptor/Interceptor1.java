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
public class Interceptor1 extends HandlerInterceptorAdapter{

    private static final Logger LOG = LoggerFactory.getLogger(Interceptor1.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        LOG.info("Interceptor1 preHandle!!!");
        return super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        LOG.info("Interceptor1 postHandle");
        if(modelAndView != null){
            modelAndView.addObject("interceptor1","interceptor1");
        }
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        LOG.info("Interceptor1 afterCompletion");
        super.afterCompletion(request, response, handler, ex);
    }
}
