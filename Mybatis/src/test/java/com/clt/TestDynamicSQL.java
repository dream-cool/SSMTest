package com.clt;
import java.nio.charset.Charset;
import com.mapper.AddressesMapper;
import com.mybatis.Util;
import com.pojo.Addresses;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestDynamicSQL {

    public static void main(String[] args) {

    }

    @Test
    public  void m1(){
        SqlSession sqlSession= Util.getSession();
        AddressesMapper mapper=sqlSession.getMapper(AddressesMapper.class);
        List<Addresses> addresses=mapper.selectByCountryCity("china","");
        System.out.println(addresses);
        sqlSession.close();
    }

    @Test
    public  void m2(){
        SqlSession sqlSession= Util.getSession();
        AddressesMapper mapper=sqlSession.getMapper(AddressesMapper.class);
        Addresses addresses=new Addresses();
        addresses.setAddrId(1);
        addresses.setCity("liling");
        addresses.setCountry("china");
        addresses.setState("hunan");
        addresses.setStreet("hongsha");
        System.out.println(mapper.update(addresses));
        sqlSession.commit();
        sqlSession.close();
    }


    @Test
    public  void m3(){
        SqlSession sqlSession= Util.getSession();
        AddressesMapper mapper=sqlSession.getMapper(AddressesMapper.class);
        Addresses address=new Addresses();
//        address.setCity("wuhan");
//        address.setCountry("china");
        address.setState("hunan");
        List<Addresses> addresses=mapper.select(address);
        System.out.println(addresses);
        sqlSession.close();
    }
    @Test
    public  void m4(){
        SqlSession sqlSession= Util.getSession();
        AddressesMapper mapper=sqlSession.getMapper(AddressesMapper.class);
        Addresses address=new Addresses();
        address.setCity("changsha");
        address.setCountry("china");
        address.setState("hunan");
        List<Addresses> addresses=mapper.selecttrim(address);
        System.out.println(addresses);
        sqlSession.close();
    }

    @Test
    public  void m5(){
        SqlSession sqlSession= Util.getSession();
        AddressesMapper mapper=sqlSession.getMapper(AddressesMapper.class);
        List<Integer> list =new ArrayList<>();
        list.add(1);

        List<Addresses> addresses=mapper.selectByIds(list);
        System.out.println(addresses);
        sqlSession.close();
    }

    @Test
    public  void m6(){
        SqlSession sqlSession= Util.getSession();
        AddressesMapper mapper=sqlSession.getMapper(AddressesMapper.class);
        List<Addresses> addresses=mapper.selectLike("an");
        System.out.println(addresses);
        System.out.println("吃开户客服老师疯了");
        sqlSession.close();
    }
    @Test
    public  void m7(){
        SqlSession sqlSession= Util.getSession();
        AddressesMapper mapper=sqlSession.getMapper(AddressesMapper.class);
        List<Addresses> addresses=mapper.selectall();
        System.out.println(addresses);
        sqlSession.close();
    }

    @Test
    public  void m8(){
        System.out.println(System.getProperty("file.encoding"));
        System.out.println(Charset.defaultCharset().name());
    }

    @Test
    public  void m9(){
        SqlSession sqlSession= Util.getSession();
        SqlSession sqlSession1=Util.getSession();
        AddressesMapper mapper=sqlSession.getMapper(AddressesMapper.class);
        AddressesMapper mapper1=sqlSession1.getMapper(AddressesMapper.class);
        List<Addresses> addresses=mapper.selectall();
        sqlSession.close();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<Addresses> addresses1=mapper1.selectall();
        sqlSession1.close();
        System.out.println(addresses1);
        System.out.println(addresses);
        sqlSession.close();
    }

    @Test
    public void m10(){

    }

    @Test
    public void m11(){

    }



}
