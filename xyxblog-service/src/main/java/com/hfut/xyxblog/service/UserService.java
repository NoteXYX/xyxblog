package com.hfut.xyxblog.service;

import com.hfut.xyxblog.dao.Entity.User;

public interface UserService {
    //根据用户id获得用户信息
    User getUserById(long id);
}
