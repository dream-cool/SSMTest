package com.clt;

import com.clt.pojo.Dog;
import com.clt.pojo.Girl;
import com.clt.pojo.People;
import com.clt.pojo.PrettyGirl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Test1 {

    @Test
    public void m1(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("spring/applicationContext.xml");

//        Girl girl2= (Girl) ctx.getBean("girl2");
//

//        ((PrettyGirl)girl).show();
//        System.out.println(girl.getName());


 //       ((ClassPathXmlApplicationContext) ctx).close();
 //       ((ClassPathXmlApplicationContext) ctx).refresh();
//        Girl girl3=(Girl) ctx.getBean("girl3");
//        Girl girl4=(Girl) ctx.getBean("girl4");
//
//        System.out.println();
//        System.out.println(girl3);
    }

    @Test
        public  void m2(){
        long start =System.currentTimeMillis();
        ApplicationContext ctx=new ClassPathXmlApplicationContext("test.xml");
        long end =System.currentTimeMillis();
        long totle =end-start;
        System.out.println(totle);
    }
    @Test
    public void  m3(){

        long start =System.currentTimeMillis();
        ApplicationContext ctx=new ClassPathXmlApplicationContext("test1.xml");
        long end =System.currentTimeMillis();
        long totle =end-start;
        System.out.println(totle);

    }
    @Test
    public void m4(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        Girl girl= (Girl) ctx.getBean("girl");
        Girl girlc= (Girl) ctx.getBean("girlc");
//        Girl girl1=ctx.getBean(Girl.class);
//        System.out.println(girl1.getDog().getName());
        System.out.println(girlc);
        System.out.println(girl.getDog().getName());
        Dog dog= (Dog) ctx.getBean("gdog");
        System.out.println(dog.getName());

//        Dog dog= (Dog) ctx.getBean("dog1");
//
//        System.out.println(dog.getName());

    }

    @Test
    public void m5(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        People people= (People) ctx.getBean("people");
        System.out.println(people);
        System.out.println(people.getFriends());
        System.out.println(people.getFriends().length);
    }
}

