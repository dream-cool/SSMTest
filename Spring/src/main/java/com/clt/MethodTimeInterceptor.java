package com.clt;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class MethodTimeInterceptor implements HandlerInterceptor {

    private  static final Logger LOGGER = Logger.getLogger(MethodTimeInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        long start =System.currentTimeMillis();
        httpServletRequest.setAttribute("start",start);
        LOGGER.info(httpServletRequest.getRequestURL()+"请求到达");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        long start= (long) httpServletRequest.getAttribute("start");
        long end =System.currentTimeMillis();
        long spengtime=end-start;
        if(spengtime>1000){
            LOGGER.warn("方法耗时严重"+spengtime+"毫秒");
        }else {
            LOGGER.info("方法耗时："+spengtime+"毫秒");
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
