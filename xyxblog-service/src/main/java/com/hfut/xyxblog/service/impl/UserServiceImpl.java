package com.hfut.xyxblog.service.impl;

import com.hfut.xyxblog.dao.Entity.User;
import com.hfut.xyxblog.dao.Mapper.UserMapper;
import com.hfut.xyxblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    //根据用户id获得用户信息
    @Override
    public User getUserById(long id) {
        return userMapper.queryUserById(id);
    }
}
