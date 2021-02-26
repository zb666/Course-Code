package com.example.rabbitmq;


import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MsgTopicReceiver {

    @RabbitListener(queues = "topic.messages")
    public void processMsg(String content){
        System.out.println("接收到了主题交换机中的消息: "+content);
    }


}
