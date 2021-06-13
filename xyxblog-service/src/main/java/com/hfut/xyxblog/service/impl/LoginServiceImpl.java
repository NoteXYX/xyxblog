package com.hfut.xyxblog.service.impl;

import com.hfut.xyxblog.common.enums.ResCode;
import com.hfut.xyxblog.common.response.CommonResp;
import com.hfut.xyxblog.dao.Entity.User;
import com.hfut.xyxblog.dao.Dao.UserDao;
import com.hfut.xyxblog.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private UserDao userDao;

    //登录接口实现
    //TODO 异常处理
    @Override
    public CommonResp loginIn(String userName, String password) {
        User userFromDB = userDao.selectUserByUserName(userName);
        CommonResp res = new CommonResp();
        if (Objects.nonNull(userFromDB)) {
            if (password.equals(userFromDB.getPassword())) {
                res.setCode(ResCode.SUCCESS);
                res.setMessage("登录成功！");
            } else {
                res.setCode(ResCode.FAILURE);
                res.setMessage("用户名或密码错误！");
            }
        } else {
            res.setCode(ResCode.FAILURE);
            res.setMessage("用户名不存在！");
        }
        return res;
    }
}
