package com.lagou.servlet.impl;

import com.lagou.dao.impl.AccountDao;
import com.lagou.servlet.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    //Spring事务
//    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.REPEATABLE_READ,timeout = 10,readOnly = false)
    public void transfer(String outUser, String inUser, Double money) {
        accountDao.out(outUser, money);
//        int c =1/0;
        accountDao.in(inUser,money);
    }

}
