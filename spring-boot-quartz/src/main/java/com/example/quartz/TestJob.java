package com.example.quartz;

import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class TestJob implements IJob {

    @Override
    public void start(String name, String group, String cron, Class clazz) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println("do something");
        System.out.println(simpleDateFormat.format(new Date()));
    }


}