package com.gupaoedu.redission;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sun.security.krb5.Config;

@ConditionalOnClass(Redisson.class)
@Configuration
public class RedissonAutoConfiguration {

    @Bean
    RedissonClient getRedisionConfig(){
        org.redisson.config.Config config = new org.redisson.config.Config();
        return Redisson.create(config);
    }

}
