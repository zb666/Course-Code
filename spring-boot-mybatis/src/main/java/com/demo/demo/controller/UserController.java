package com.demo.demo.controller;

import com.demo.demo.entity.UserTestBean;
import com.demo.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/user")
@RestController
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("1.0/test/insert")
    public void insertUserTest(@RequestBody UserTestBean userTestBean){
        userService.insertUser(userTestBean);
    }

    @PostMapping("1.0/test/insert/other")
    public void insertUserWithParam(@RequestBody UserTestBean userTestBean){
        userService.insertUserWithParam(userTestBean.getUserName(),userTestBean.getUserAge(),userTestBean.getUserTime());
    }

    @Bean
    public UserService createServiceBean(){
        return new UserService();
    }
}
