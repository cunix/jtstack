package com.jtstack.quartz.demo;

import static org.quartz.DateBuilder.evenMinuteDate;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;


public class SimpleExample {

    public void run() throws Exception {
        Logger log = LoggerFactory.getLogger(SimpleExample.class);
        // 定义调度器
        SchedulerFactory sf = new StdSchedulerFactory();
        Scheduler sched = sf.getScheduler();
        // 获取当前时间的下一分钟
        Date runTime = evenMinuteDate(new Date());
        // 定义job
        // 在quartz中，有组的概念，组+job名称 唯一的
        JobDetail job = newJob(HelloJob.class).withIdentity("job1", "group1").build();
        // 定义触发器，在下一分钟启动
        Trigger trigger = newTrigger().withIdentity("trigger1", "group1").startAt(runTime).build();
        // 将job注册到调度器
        sched.scheduleJob(job, trigger);
        log.info(job.getKey() + " will run at: " + runTime);
        // 启动调度器
        sched.start();
        // 等待65秒
        try {
            Thread.sleep(65L * 1000L);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 关闭调度器
        sched.shutdown(true);
    }

    public static void main(String[] args) throws Exception {
        SimpleExample example = new SimpleExample();
        example.run();

    }

}
