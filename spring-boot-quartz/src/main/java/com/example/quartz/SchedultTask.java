package com.example.quartz;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;

@Configuration
@EnableScheduling
public class SchedultTask {

    @Scheduled(cron = "0/5 * * * * ?")
//    @Scheduled(fixedRate = 5000)
    private void configTasks(){
        System.out.println("执行定时任务: "+ LocalDateTime.now());
    }

}
