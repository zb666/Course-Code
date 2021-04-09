package com.example.rocketmq.consumer;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * 消息消费者
 *  配置的Topic和ConsumerGroup
 *  要和生产者的配置保持一致
 */
@Component
@RocketMQMessageListener(topic = "BenchmarkTest",consumerGroup = "CID_ONSAPI_OWNER",selectorExpression = "*")
public class RocketConsumerListener implements RocketMQListener<String>{

    @Override
    public void onMessage(String s) {
        System.out.println("Consumer: "+s);
    }

}
