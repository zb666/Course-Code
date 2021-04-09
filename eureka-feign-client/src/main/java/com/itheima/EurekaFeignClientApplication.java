package com.itheima;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient  //服务发现 去发现提供者的服务
@EnableFeignClients
public class EurekaFeignClientApplication {

    //该微服务会注册到Eureka注册中心中
    public static void main(String[] args) {
        SpringApplication.run(EurekaFeignClientApplication.class,args);
    }

}
