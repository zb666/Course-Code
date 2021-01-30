package com.gupaoedu.springcloud.example.springclouduserservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@EnableFeignClients //Feign服务调用
@EnableEurekaServer
//@ComponentScan(basePackages = "com.gupaoedu")
@SpringBootApplication
@EnableHystrix
//@RibbonClient(name = "MICRO_SOFT",configuration = ConfigBean.class)
public class SpringCloudUserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudUserServiceApplication.class, args);
    }

}
