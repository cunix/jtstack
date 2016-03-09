package com.jtstack.quartz.demo;

import org.quartz.CronScheduleBuilder;
import org.quartz.DateBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

public class SimpleCronExample {

    public void run() throws Exception {
    	
        Logger log = LoggerFactory.getLogger(SimpleCronExample.class);
        // 定义调度器
        SchedulerFactory sf = new StdSchedulerFactory();
        Scheduler sched = sf.getScheduler();
        // 获取当前时间的下一分钟
        Date runTime = DateBuilder.evenMinuteDate(new Date());
        // 定义job
        JobDetail job =JobBuilder.newJob(HelloJob.class).withIdentity("job1", "group1").build();
        // 定义触发器，每2秒执行一次
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "group1").withSchedule(CronScheduleBuilder.cronSchedule("*/1 * * * * ?")).build();

        // 将job注册到调度器
        sched.scheduleJob(job, trigger);
        log.info(job.getKey() + " will run at: " + runTime);
        // 启动调度器
        sched.start();
        // 等待1分钟
        try {
            Thread.sleep(60L * 1000L);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 关闭调度器
        sched.shutdown(true);
    }

    public static void main(String[] args) throws Exception {

        SimpleCronExample example = new SimpleCronExample();
        example.run();

    }

}
