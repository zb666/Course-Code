package com.example.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.annotation.RabbitListeners;
import org.springframework.stereotype.Component;

@Component
public class FanoutReceiver {

    @RabbitListener(queues = "fanout1")
    public void processQueue1(String content){
        System.out.println("广播类型: 1"+content);
    }

    @RabbitListener(queues = "fanout2")
    public void processQueue2(String content){
        System.out.println("广播类型: 2"+content);
    }

}
