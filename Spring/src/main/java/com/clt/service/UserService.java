package com.clt.service;

import com.clt.pojo.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface UserService {
    User selectLogin(User user);

    boolean insertUser(User user);

    List<User> selectAll();

    boolean deleteUserByUserId(Integer userId);

    boolean deleteUserByUserName(String userName);

    User selectByuserId(Integer userId);

    boolean updateUser(User user);

    User selectByuserName(String userName);
}
