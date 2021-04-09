package com.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class DemoRunnable implements ApplicationRunner {

    @Autowired
    private Demo demo;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("测试 11111");
    }

    {
        System.out.println("测试 22222");
    }

    public DemoRunnable() {
        System.out.println("测试 33333");
    }

    @PostConstruct
    public void testPrint(){
        System.out.println("测试 44444"+demo.hashCode());
    }

    @PreDestroy
    public void preTest(){
        System.out.println("55555");
    }

}
