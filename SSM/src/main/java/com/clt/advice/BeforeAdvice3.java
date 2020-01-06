package com.clt.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Order(1)
@Component
@Aspect
public class BeforeAdvice3 {


    @Before(value = "execution(* com.clt.service.UserService.show(String)))")
    public void before2(){
            System.out.println("在3个世纪以前");
    }




}
