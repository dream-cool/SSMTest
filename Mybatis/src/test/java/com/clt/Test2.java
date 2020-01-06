package com.clt;

import com.mapper.GirlMapper;
import com.mybatis.Util;
import com.pojo.A;
import com.pojo.B;
import com.pojo.Girl;
import javafx.beans.binding.ObjectBinding;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Test2 {

    @Test
    public void m1(){
        SqlSession sqlSession= Util.getSession();
        GirlMapper mapper =sqlSession.getMapper(GirlMapper.class);

        Girl girl=mapper.selectByid(1L);

        System.out.println(girl.getBirthday());
        sqlSession.close();


    }
    @Test

    public void m2(){
        SqlSession sqlSession= Util.getSession();
        GirlMapper mapper =sqlSession.getMapper(GirlMapper.class);

        Girl girl=mapper.selectByName("林心如");

        System.out.println(girl.getBirthday());
        sqlSession.close();



    }
    @Test
    public void m3(){
        SqlSession sqlSession= Util.getSession();
        GirlMapper mapper =sqlSession.getMapper(GirlMapper.class);
        Girl girl=mapper.selectByNameFlower("林心如","玫瑰花");
        System.out.println(girl.getBirthday());
        sqlSession.close();

    }

    @Test
    public void m4(){
        SqlSession sqlSession= Util.getSession();
        GirlMapper mapper =sqlSession.getMapper(GirlMapper.class);
        Girl g=new Girl();
        g.setFlower("玫瑰花");
        g.setName("林心如");
        Girl girl=mapper.selectByNameFlower2(g);
        System.out.println(girl.getBirthday());
        sqlSession.close();

    }

    @Test
    public void m5(){
        SqlSession sqlSession= Util.getSession();
        GirlMapper mapper =sqlSession.getMapper(GirlMapper.class);
        Girl g=new Girl();
        Map<String,Object> map=new HashMap<>();
        map.put("name","林心如");
        map.put("flower","玫瑰花");

        Girl girl=mapper.selectByNameFlower3(map);
        System.out.println(girl.getBirthday());
        sqlSession.close();

    }

    @Test
    public void m6(){
        SqlSession sqlSession= Util.getSession();
        GirlMapper mapper =sqlSession.getMapper(GirlMapper.class);
        Girl g=new Girl();
        A a=new A();
        B b=new B();
        a.setName("林心如");
        b.setFlower("玫瑰花");

        Girl girl=mapper.selectByAB(a,b);
        System.out.println(girl.getBirthday());
        sqlSession.close();

    }

}
