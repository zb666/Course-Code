package com.example.rocketmq.consumer;


import org.apache.rocketmq.spring.annotation.MessageModel;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class RokcetServiceListener {

    @Service
    @RocketMQMessageListener(consumerGroup = "consumer-group-1", topic = "rocket-topic-1")
    public class Consumer1 implements RocketMQListener<String> {

        @Override
        public void onMessage(String s) {
//            log.info("consumer1 rocket收到消息：{}", s);
            System.out.println("consumer1 rocket收到消息：{}"+s);
        }
    }

    // RocketMQ支持两种消费方式，集器消费和广播消费
    @Service
    @RocketMQMessageListener(consumerGroup = "consumer-group-2", topic = "rocket-topic-2",
            selectorExpression = "tag2", messageModel = MessageModel.BROADCASTING)
    public class Consumer2 implements RocketMQListener<String> {
        @Override
        public void onMessage(String s) {
            System.out.println("consumer2 rocket收到消息：{}"+s);
        }
    }

}