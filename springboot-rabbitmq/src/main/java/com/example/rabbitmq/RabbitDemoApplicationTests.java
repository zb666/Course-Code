package com.example.rabbitmq;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RabbitDemoApplicationTests {

    @Autowired
    private MsgProducer msgProducer;

    @Test
    public void directTest(){
        msgProducer.sendMsg("RabbitMQ Msg");
    }

    @Test
    public void topicTest(){
        msgProducer.sendTopicMsg();
    }

    @Test
    public void fanoutTest(){
        msgProducer.sendFanoutMsg();
    }



}
