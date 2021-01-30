package com.gupaoedu.springcloud.example.springcloudorderservice;


import org.redisson.Redisson;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@ConditionalOnClass(Redisson.class)
public class RedissonAutoConfiguration {
}
