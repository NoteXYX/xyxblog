package com.hfut.xyxblog.web.controller;

import com.hfut.xyxblog.common.enums.ResCode;
import com.hfut.xyxblog.common.response.CommonResp;
import com.hfut.xyxblog.dao.Entity.User;
import com.hfut.xyxblog.service.LoginService;
import com.hfut.xyxblog.service.impl.CornTestServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

@Slf4j
@RestController
public class LoginController {

    @Autowired
    LoginService loginService;

    @Autowired
    CornTestServiceImpl cornTestService;

    @Autowired
    Scheduler scheduler;

    @CrossOrigin
    @PostMapping(value = "/login")
    public CommonResp login(@RequestBody User reqUser) {
        // 对 html 标签进行转义，防止 XSS 攻击
        String userName = reqUser.getUserName();
        userName = HtmlUtils.htmlEscape(userName);
        String password = reqUser.getPassword();
        CommonResp res = loginService.loginIn(userName, password);
        //TODO 写入日志
        if (res.getCode() == ResCode.SUCCESS) {
            log.info("{}用户登录成功！", userName);
        } else {
            log.info(res.getMessage());
        }
        return res;
    }

    @RequestMapping("/cornStart")
    public String cornTestStart(long userId) {
        cornTestService.addJobAndTrigger(userId);
        scheduler = cornTestService.getScheduler();
        return "cornStart!";
    }

    @RequestMapping("/cornStop")
    public String cornTestStop(long userId) throws SchedulerException {
        scheduler.shutdown();
        return "cornStop!";
    }
}
