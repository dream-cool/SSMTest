package com.clt.service.impl;


import com.clt.mapper.UserMapper;
import com.clt.pojo.User;
import com.clt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired()
    private UserMapper userMapper;

    @Override
    public User selectLogin(User user) {
        return userMapper.selectLogin(user);
    }

    @Override
    public boolean insertUser(User user) {
        return userMapper.insertUser(user)==1 ? true:false;
    }

    @Override
    public List<User> selectAll() {
        return userMapper.selectAll();
    }

    @Override
    public boolean deleteUserByUserId(Integer userId) {
        return userMapper.deleteUserByUserId(userId);
    }

    @Override
    public boolean deleteUserByUserName(String userName) {
        return userMapper.deleteUserByUserName(userName);
    }

    @Override
    public User selectByuserId(Integer userId) {
        User user=userMapper.selectByuserId(userId);
        return user;
    }

    @Override
    public boolean updateUser(User user) {
        return userMapper.updateUser(user)==1 ? true:false;
    }

    @Override
    public User selectByuserName(String userName) {
        return userMapper.selectByuserName(userName);
    }


}
