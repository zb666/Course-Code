package com.demo.demo.controller;

import com.demo.demo.service.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/hellofeign")
public class FeignController {

    @Autowired
    private FeignService feignService;

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello(){
        return feignService.sayHello();
    }

}
