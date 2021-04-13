package com.lagou.servlet.impl;

import com.lagou.servlet.IAccountService;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements IAccountService {
    public void transfer() {
        System.out.println("转账的方法被执行了");
    }
}
