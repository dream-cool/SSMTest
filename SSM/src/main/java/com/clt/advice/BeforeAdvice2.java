package com.clt.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Order(2)
@Component
@Aspect
public class BeforeAdvice2 {


    public void methodBefore(){
        System.out.println("点");
    }


    @Before(value = "execution(* com.clt.service.UserService.show(String)))")
    public void before(JoinPoint joinPoint){
        System.out.println(joinPoint.getSignature().getName()+ Arrays.toString(joinPoint.getArgs()));

        System.out.println("在2个世纪以前");
    }




}
