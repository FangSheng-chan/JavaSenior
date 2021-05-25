package com.ss.springboottool.utils;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Service;

/**
 * @author fangsheng
 * @date 2021/5/20 10:10 上午
 */

public class QuartzTestJob extends QuartzJobBean {
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        String userName = (String) jobExecutionContext.getJobDetail().getJobDataMap().get("userName");
        System.out.println("userName:" + userName);
    }
}
