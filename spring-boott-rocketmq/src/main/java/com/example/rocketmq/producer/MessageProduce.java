package com.example.rocketmq.producer;

import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageProduce {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    /**
     * @param topic 主题
     * @param message 消息体
     */
    public void sendMessage(String topic,String message){
        rocketMQTemplate.convertAndSend(topic,message.getBytes());
    }

}
