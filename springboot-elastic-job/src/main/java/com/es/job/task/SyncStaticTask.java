package com.es.job.task;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import com.dangdang.elasticjob.lite.annotation.ElasticSimpleJob;
import org.springframework.stereotype.Component;

@ElasticSimpleJob(
        jobName = "${elasticjob.zookeeper.namespace}",
        shardingTotalCount = 1,
        cron = "0/5 * * * * ? *"
)
@Component
public class SyncStaticTask implements SimpleJob {
    @Override
    public void execute(ShardingContext shardingContext) {
        System.out.println("StaticJobTask--execute");
    }
}
