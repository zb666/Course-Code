package com.es.job;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = MallJobApplication.class)
public class MallJobApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallJobApplication.class,args);
    }


}
