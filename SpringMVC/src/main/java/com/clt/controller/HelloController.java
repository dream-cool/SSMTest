package com.clt.controller;


import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//实现control接口的方式
public class HelloController  implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView mav =new ModelAndView();
        mav.addObject("girl","ff");
        mav.setViewName("girl");
        return mav;
    }
}
