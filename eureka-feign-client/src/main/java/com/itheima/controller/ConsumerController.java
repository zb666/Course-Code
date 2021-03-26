package com.itheima.controller;

import com.itheima.service.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

    //调用微服务
    @Autowired
    private FeignService helloService;

    @RequestMapping(value="/hello",method = RequestMethod.GET)
    public String hello() {
        return  helloService.hello();
    }


}
