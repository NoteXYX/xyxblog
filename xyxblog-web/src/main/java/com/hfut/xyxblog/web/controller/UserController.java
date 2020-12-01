package com.hfut.xyxblog.web.controller;

import com.hfut.xyxblog.dao.Entity.User;
import com.hfut.xyxblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/getUserById")
    public User getUserById(long id) {
        return userService.getUserById(id);
    }

}
