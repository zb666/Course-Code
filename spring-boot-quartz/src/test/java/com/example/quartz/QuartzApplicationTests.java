package com.example.quartz;

import org.junit.jupiter.api.Test;
import org.quartz.JobBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class QuartzApplicationTests {

    @Autowired
    private TestJob testJob;

    @Test
    void contextLoads() {
    }

}
