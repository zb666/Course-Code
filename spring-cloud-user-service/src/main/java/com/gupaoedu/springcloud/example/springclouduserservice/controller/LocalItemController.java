package com.gupaoedu.springcloud.example.springclouduserservice.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LocalItemController {

    @RequestMapping("/hi")
    public String hi(){
        return "Say Hi";
    }

}
