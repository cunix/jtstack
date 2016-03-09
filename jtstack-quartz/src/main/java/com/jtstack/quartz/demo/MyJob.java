package com.jtstack.quartz.demo;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class MyJob extends QuartzJobBean {
    
    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        System.out.println("myJob 执行了............." + context.getTrigger().getKey().getName());
        ApplicationContext applicationContext = (ApplicationContext) context.getJobDetail().getJobDataMap().get("applicationContext");
        System.out.println("获取到的Spring容器是： " + applicationContext);
    }

}
