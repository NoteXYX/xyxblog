package com.hfut.xyxblog.common.job;

import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Scheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

import java.util.Random;

@Slf4j
@Component
public class RandomCornJob extends QuartzJobBean {

    @Autowired
    private Scheduler scheduler;

    //定时任务逻辑
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        StringBuffer sbf = new StringBuffer();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            sbf.append(random.nextInt(10));
        }
        log.info("验证码：{}",sbf.toString());
    }
}
