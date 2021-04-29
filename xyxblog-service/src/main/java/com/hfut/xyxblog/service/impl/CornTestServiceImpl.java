package com.hfut.xyxblog.service.impl;

import com.hfut.xyxblog.common.job.RandomCornJob;
import com.hfut.xyxblog.service.CornTestService;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CornTestServiceImpl implements CornTestService {

    @Autowired
    private Scheduler scheduler;

    @Override
    public void addJobAndTrigger(Long userId) {

        JobDetail startJobDetail = JobBuilder.newJob(RandomCornJob.class)
                // 指定任务组名和任务名
                .withIdentity("job_" + userId.toString(),
                        "group0")
                // 添加一些参数，执行的时候用
//                .usingJobData("username", proposerUsername)
//                .usingJobData("time", startTime.toString())
                .build();
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("0/5 * * * * ?");
        CronTrigger startCronTrigger = TriggerBuilder.newTrigger()
                // 指定触发器组名和触发器名
                .withIdentity("job_" + userId.toString(),
                        "group0")
                .withSchedule(scheduleBuilder)
                .build();

        // 将job和trigger添加到scheduler里
        try {
            scheduler.scheduleJob(startJobDetail, startCronTrigger);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    public Scheduler getScheduler() {
        return scheduler;
    }
}
