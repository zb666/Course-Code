package com.example.demo;

import com.itheima.EurekaFeignClientApplication;
import com.itheima.service.FeignService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = EurekaFeignClientApplication.class)
public class FeignDemoApplicationTests {

    @Autowired
    private FeignService feignService;

    @Test
    public void testFeignService(){
        String hello = feignService.hello();
        System.out.println(hello);
    }

}
