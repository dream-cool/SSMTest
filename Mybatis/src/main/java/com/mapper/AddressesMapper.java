package com.mapper;

import com.pojo.A;
import com.pojo.Addresses;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AddressesMapper  {

    Addresses selectByid(Integer id);

    List<Addresses> selectByCountryCity(@Param("country") String country, @Param("city") String city);

    int update(Addresses addresses);

    List<Addresses> select(Addresses addresses);

    List<Addresses> selecttrim(Addresses addresses);

    List<Addresses> selectByIds(List<Integer> ids);

    List<Addresses> selectLike(String str);

    List<Addresses> selectall();


}
