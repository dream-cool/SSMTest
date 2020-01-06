package com.clt;

import com.clt.advice.AfterAdvice;
import com.clt.advice.BeforeAdvice;
import com.clt.service.ProvideService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AOPTest {
    @Test
    public void m1(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("spring/spring-*.xml");
//        BeforeAdvice beforeAdvice= (BeforeAdvice) ctx.getBean("beforeAdvice");
////        beforeAdvice.methodBefore();
        AfterAdvice afterAdvice= (AfterAdvice) ctx.getBean("afterAdvice");
//        afterAdvice.after1();
        afterAdvice.after2();
//        ProvideService provideService= (ProvideService) ctx.getBean("provideService");
//        provideService.add1();
    }
}
