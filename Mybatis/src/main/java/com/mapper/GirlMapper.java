package com.mapper;

import com.pojo.A;
import com.pojo.B;
import com.pojo.Girl;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public interface GirlMapper {

    int insert(Girl girl);

    Girl selectByid(long id);

    Girl selectByName(String name);

    Girl selectByNameFlower(@Param("name") String name, @Param("flower") String flower);

    Girl selectByNameFlower2( Girl girl);

    Girl selectByNameFlower3(Map<String,Object> map);

    Girl selectByAB(@Param("a") A a ,@Param("b") B b);

    Girl selectBybirthday(Date date);

    int add();
}
