package com.es.job.dyncmic;

import com.dangdang.ddframe.job.api.simple.SimpleJob;
import com.dangdang.ddframe.job.config.JobCoreConfiguration;
import com.dangdang.ddframe.job.config.simple.SimpleJobConfiguration;
import com.dangdang.ddframe.job.lite.config.LiteJobConfiguration;
import com.dangdang.ddframe.job.lite.spring.api.SpringJobScheduler;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DynamicTaskCreate {

    @Autowired
    private ZookeeperRegistryCenter zookeeperRegistryCenter;

    //调用即可创建定时的任务
    public void create(String jobName, String cron, int shardingTotalCount, SimpleJob instance, String parameters){

        LiteJobConfiguration.Builder builder = LiteJobConfiguration.newBuilder(new SimpleJobConfiguration(
                JobCoreConfiguration.newBuilder(
                        jobName,
                        cron,
                        shardingTotalCount
                ).jobParameter(parameters).build(),
                instance.getClass().getName()
        )).overwrite(true);
        LiteJobConfiguration jobConfiguration = builder.build();
        //开启作业
        new SpringJobScheduler(instance,zookeeperRegistryCenter,jobConfiguration).init();
    }

}
