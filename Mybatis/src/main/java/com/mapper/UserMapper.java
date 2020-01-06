package com.mapper;

import com.pojo.User;
import com.pojo.UserBlog;
import com.pojo.UserDetail;
import com.pojo.UserWithDetail;

import java.util.List;

public interface UserMapper {

    UserWithDetail selectById(Integer id);

    List<UserBlog> selectByIdWithBlog(Integer id);
}
