package com.hfut.xyxblog.dao.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class User {
    //用户表主键id
    private long id;

    //用户名
    private String userName;

    //密码
    private String password;

    //绑定邮箱
    private String email;

}
