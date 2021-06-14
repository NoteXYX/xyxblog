package com.hfut.xyxblog.dao.Dao;

import com.hfut.xyxblog.dao.Entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {

    //根据id查找用户完整信息
    User selectUserById(long id);

    //根据用户名查找用户的完整信息
    User selectUserByUserName(String userName);
}
