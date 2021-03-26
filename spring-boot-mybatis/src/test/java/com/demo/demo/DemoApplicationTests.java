package com.demo.demo;

import com.demo.demo.service.FeignService;
import feign.Feign;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
        FeignService feignService = Feign.builder().target(FeignService.class, "http://127.0.0.1:8080");
        feignService.sayHello();
    }

}
