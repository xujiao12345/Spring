package com.wisely.highlight_spring4.ch3.taskscheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class SchedulerTaskService {
    private  static final SimpleDateFormat dateFormat=new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 5000)//该方法是计划任务，使用fixedRate属性每隔固定时间执行
    public void reportCurrentTime(){
        System.out.println("每隔五秒执行一次 "+dateFormat.format(new Date()));
    }
    @Scheduled(cron = "0 13 22 ? * *")//每天11点28分执行
    public void fixTimeExcution(){
        System.out.println("在指定时间 "+dateFormat.format(new Date())+"执行");
    }
}
