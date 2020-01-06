package com.clt.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Order
@Component
@Aspect
public class AfterReturning {

    @org.aspectj.lang.annotation.AfterReturning(value = "execution(* com.clt.service.UserService.re())")
    public void after(JoinPoint joinPoint){
        System.out.println("返回值之后");
        System.out.println(joinPoint.toString());
        System.out.println(joinPoint.getSignature().toString());
        System.out.println(joinPoint.getSignature().getName()+ Arrays.toString(joinPoint.getArgs()));
//        System.out.println("吃完后");
    }
    @org.aspectj.lang.annotation.AfterThrowing(value = "execution(* com.clt.service.UserService.exe())")
    public void exee(JoinPoint joinPoint){
        System.out.println("异常之后");
        System.out.println(joinPoint.toString());
        System.out.println(joinPoint.getSignature().toString());
        System.out.println(joinPoint.getSignature().getName()+ Arrays.toString(joinPoint.getArgs()));
//        System.out.println("吃完后");
    }
}
