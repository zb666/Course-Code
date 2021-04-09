package com.es.job.dyncmic;

import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperConfiguration;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DynamicConfig {


    @Value("${dynamiczk}")
    private String dynamiczk;
    @Value("${dynamicnamespace}")
    private String dynamicnamespace;

    @Bean
    public ZookeeperConfiguration zookeeperConfiguration(){
        return new ZookeeperConfiguration(dynamiczk,dynamicnamespace);
    }

    @Bean(initMethod = "init")
    public ZookeeperRegistryCenter zookeeperRegistryCenter(ZookeeperConfiguration zookeeperConfiguration){
        return new ZookeeperRegistryCenter(zookeeperConfiguration);
    }

}
