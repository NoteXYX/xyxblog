package com.hfut.xyxblog.dao.Entity;

import lombok.Data;

@Data
public class User {
    //用户表主键id
    private long id;

    //用户名
    private String userName;

    //密码
    private String password;

}
