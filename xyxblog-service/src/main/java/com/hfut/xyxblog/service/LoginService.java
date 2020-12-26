package com.hfut.xyxblog.service;

import com.hfut.xyxblog.common.response.CommonRes;
import com.hfut.xyxblog.dao.Entity.User;

public interface LoginService {
    //登录服务
    CommonRes loginIn(String userName, String password);
}
