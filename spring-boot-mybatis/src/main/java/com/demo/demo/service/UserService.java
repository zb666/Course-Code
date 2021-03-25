package com.demo.demo.service;

import com.demo.demo.entity.UserTestBean;
import com.demo.demo.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.Date;

@Slf4j
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public int insertUser(UserTestBean userTestBean) {
        return userMapper.insertUser(userTestBean);
    }

    public int insertUserWithParam(String userName, int userAge, Date date){
        return userMapper.insertUserParam(userName,userAge,date);
    }


}
