package com.clt;

import com.clt.pojo.PrivderDao;
import com.clt.pojo.User;
import com.clt.service.ProvideService;
import com.clt.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Test1Autowired {

    @Test
    public void m1(){

        ApplicationContext ctx=new ClassPathXmlApplicationContext("autowired.xml");
        User user= (User) ctx.getBean("userd");
        System.out.println(user);

    }
    @Test
    public void m2(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("autowired.xml");
        ProvideService  ps= (ProvideService) ctx.getBean("provideService");
        ps.getPrivderDao().update();
    }
    @Test
    public void m3(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("resources.xml");
        PrivderDao pd= (PrivderDao) ctx.getBean("privderDao");
        System.out.println(pd);

    }




}

