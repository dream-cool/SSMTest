package com.clt;

import com.mapper.GirlMapper;
import com.mapper.ProductMapper;
import com.mybatis.Util;
import com.pojo.Girl;
import com.pojo.Product;
import com.pojo.dto.ProductDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Date;

public class Test1 {

    @Test
    public void m1(){
        SqlSession sqlSession= Util.getSession();
        GirlMapper mapper =sqlSession.getMapper(GirlMapper.class);
        Girl g=new Girl();
        g.setName("林心如");
        g.setFlower("玫瑰花");
        g.setBirthday(new Date());

        mapper.insert(g);
        sqlSession.commit();
        sqlSession.close();

    }

    @Test
    public void m2(){
        ProductDto productDto=new ProductDto();
        productDto.setColor("黑色");
        productDto.setPrice("300");
        productDto.setSize(null);
//        productDto.setSize("40");
        SqlSession sqlSession= Util.getSession();
        ProductMapper productMapper=sqlSession.getMapper(ProductMapper.class);
        productMapper.select(productDto);
        sqlSession.commit();
        sqlSession.close();

    }
}
