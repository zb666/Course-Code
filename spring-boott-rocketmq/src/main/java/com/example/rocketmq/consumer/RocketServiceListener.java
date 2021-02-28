package com.example.rocketmq.consumer;

import org.apache.rocketmq.spring.annotation.MessageModel;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class RocketServiceListener {

    @Service
    @RocketMQMessageListener(consumerGroup = "consume-group-1",topic = "rocket-topic-2")
    public class Consumer1 implements RocketMQListener<String>{

        @Override
        public void onMessage(String s) {
            System.out.println("consumer1 收到了消息"+s);
        }
    }

    @Service
    @RocketMQMessageListener(consumerGroup = "consume-group-2",topic = "rocket-topic-2",
    selectorExpression = "tag2",
            messageModel = MessageModel.BROADCASTING
    )
    public class Consumer2 implements RocketMQListener<String>{

        @Override
        public void onMessage(String s) {
            System.out.println("consumer2 收到了消息"+s);
        }
    }



}
