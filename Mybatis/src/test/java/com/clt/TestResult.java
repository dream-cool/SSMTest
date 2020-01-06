package com.clt;

import com.mapper.UserMapper;
import com.mybatis.Util;
import com.pojo.UserBlog;
import com.pojo.UserDetail;
import com.pojo.UserWithDetail;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class TestResult {

    @Test
    public  void  m1(){
        SqlSession sqlSession= Util.getSession();

        UserMapper mapper=sqlSession.getMapper(UserMapper.class);

        UserWithDetail userWithDetail=mapper.selectById(1);

//        System.out.println(userWithDetail.getCreatetime());

        System.out.println(userWithDetail);

        sqlSession.close();
    }
    @Test
    public  void  m2(){
        SqlSession sqlSession= Util.getSession();

        UserMapper mapper=sqlSession.getMapper(UserMapper.class);

        List<UserBlog> userBlogs=mapper.selectByIdWithBlog(1);

//        System.out.println(userWithDetail.getCreatetime());

        System.out.println(userBlogs);

        sqlSession.close();
    }
}
