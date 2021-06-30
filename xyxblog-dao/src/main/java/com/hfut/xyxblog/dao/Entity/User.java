package com.hfut.xyxblog.dao.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
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
