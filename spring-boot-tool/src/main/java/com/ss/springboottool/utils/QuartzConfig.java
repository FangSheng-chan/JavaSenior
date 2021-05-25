package com.ss.springboottool.utils;

import org.quartz.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author fangsheng
 * @date 2021/5/20 10:11 上午
 */
@Configuration
public class QuartzConfig {

    @Value("${ss.spring.quartz.cron}")
    private String testCron;

//    /**
//     * 创建定时任务
//     */
//    @Bean
//    public JobDetail quartzTestDetail() {
//        JobDetail jobDetail = JobBuilder.newJob(QuartzTestJob.class)
//                .withIdentity("quartzTestDetail", "QUARTZ_TEST")
//                .usingJobData("userName", "fangsheng")
//                .storeDurably()
//                .build();
//        return jobDetail;
//    }

    /**
     * 创建触发器
     */
//    @Bean
//    public Trigger quartzTestJobTrigger() {
//        //每隔5秒执行一次
//        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(testCron);
//
//        //创建触发器
//        Trigger trigger = TriggerBuilder.newTrigger()
//                .forJob(quartzTestDetail())
//                .withIdentity("quartzTestJobTrigger", "QUARTZ_TEST_JOB_TRIGGER")
//                .withSchedule(cronScheduleBuilder)
//                .build();
//        return trigger;
//    }


}
