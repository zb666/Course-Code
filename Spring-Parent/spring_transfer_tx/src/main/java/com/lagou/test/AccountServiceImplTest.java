package com.lagou.test;

import com.lagou.config.SpringConfig;
import com.lagou.servlet.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class AccountServiceImplTest {

    @Autowired
    private AccountService accountService;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testTransfer(){
        accountService.transfer("李四","张三",10d);
           String sql = "select * from account";
//        jdbcTemplate.query(sql);
    }

}
