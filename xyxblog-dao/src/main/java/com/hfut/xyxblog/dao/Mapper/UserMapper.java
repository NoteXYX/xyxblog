package com.hfut.xyxblog.dao.Mapper;

import com.hfut.xyxblog.dao.Entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    //根据id查找用户信息
    User queryUserById(long id);
}
