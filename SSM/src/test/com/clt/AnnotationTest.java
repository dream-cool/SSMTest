package com.clt;

import com.clt.service.ProvideService;
import com.clt.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationTest {
    @Test
    public void m1(){
        ApplicationContext ctx= new ClassPathXmlApplicationContext("spring/spring-test1.xml");
        UserService userService = (UserService) ctx.getBean("userService");
//        userService.show("he");
//        ProvideService provideService= (ProvideService) ctx.getBean("provideService");
//        provideService.add1();
//        userService.eat("西瓜");
//        System.out.println(userService.re());
//        userService.exe();
//        userService.around();

    }
}

