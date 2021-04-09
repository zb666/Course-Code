package com.gupaoedu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class BootTestApp {

    public static void main(String[] args) {
        SpringApplication.run(BootTestApp.class,args);
    }

}
