package com.hfut.xyxblog.web.controller;

import com.hfut.xyxblog.common.enums.ResCode;
import com.hfut.xyxblog.common.response.CommonRes;
import com.hfut.xyxblog.dao.Entity.User;
import com.hfut.xyxblog.dao.Mapper.UserMapper;
import com.hfut.xyxblog.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;


@Controller
public class LoginController {
    @Autowired
    LoginService loginService;

    @Autowired
    UserMapper userMapper;

    @CrossOrigin
    @PostMapping(value = "/login")
    @ResponseBody
    public CommonRes login(@RequestBody User reqUser) {
        // 对 html 标签进行转义，防止 XSS 攻击
        String userName = reqUser.getUserName();
        userName = HtmlUtils.htmlEscape(userName);
        String password = reqUser.getPassword();
        CommonRes res = loginService.loginIn(userName, password);
        //TODO 写入日志
        if (res.getCode() == ResCode.SUCCESS) {
            System.out.println(String.format("%s用户登录成功！", userName));
        } else {
            System.out.println(res.getMessage());
        }
        return res;
    }

    @PostMapping(value = "/getUserById")
    @ResponseBody
    public User login(long id) {
        return userMapper.selectUserById(id);
    }
}
