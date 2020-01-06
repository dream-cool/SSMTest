package com.clt.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Order
@Component
@Aspect
public class After {

    @org.aspectj.lang.annotation.After(value = "execution(* com.clt.service.UserService.exe())")
    public void after(JoinPoint joinPoint){
        System.out.println("方法后");
        System.out.println(joinPoint.toString());
        System.out.println(joinPoint.getSignature().toString());
        System.out.println(joinPoint.getSignature().getName()+ Arrays.toString(joinPoint.getArgs()));
//        System.out.println("吃完后");
    }
}
