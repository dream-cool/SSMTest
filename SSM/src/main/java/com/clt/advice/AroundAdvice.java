package com.clt.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AroundAdvice {
    @Around(value = "execution(* com.clt.service.UserService.around())")
    public Object around (ProceedingJoinPoint poj) throws Throwable {
        System.out.println("我是环绕建议");
        Object proceed= poj.proceed();
        return  proceed;
    }

}
