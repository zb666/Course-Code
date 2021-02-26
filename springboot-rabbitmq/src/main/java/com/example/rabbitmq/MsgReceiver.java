package com.example.rabbitmq;


import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MsgReceiver {

    @RabbitListener(queues = RabbitConfig.QUEUE_A)
    public void processMsg(String content){
        System.out.println("接收到了队列中的消息: "+content);
    }


}
