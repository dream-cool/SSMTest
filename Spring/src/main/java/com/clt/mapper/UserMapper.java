package com.clt.mapper;

import com.clt.pojo.User;

import java.util.List;


public interface UserMapper {

    User selectLogin(User user);

    int insertUser(User user);

    List <User> selectAll();

    boolean deleteUserByUserId(Integer userId);

    boolean deleteUserByUserName(String userName);

    User selectByuserId(Integer userId);

    int updateUser(User user);

    User selectByuserName(String userName);
}
