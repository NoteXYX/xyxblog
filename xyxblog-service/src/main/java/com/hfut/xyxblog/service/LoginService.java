package com.hfut.xyxblog.service;

import com.hfut.xyxblog.common.response.CommonResp;

public interface LoginService {
    //登录服务
    CommonResp loginIn(String userName, String password);
}
