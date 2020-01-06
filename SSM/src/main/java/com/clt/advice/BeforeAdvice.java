package com.clt.advice;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Order(3)
@Component
@Aspect
public class BeforeAdvice {

    public void methodBefore(){
        System.out.println("点");
    }

    @Before(value = "execution(* com.clt.service.UserService.show(String))")
    public void before2(){
        System.out.println("在1个世纪以前");
    }






}
