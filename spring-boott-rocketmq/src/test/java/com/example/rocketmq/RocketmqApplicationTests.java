package com.example.rocketmq;

import com.example.rocketmq.controller.RocketController;
import com.example.rocketmq.producer.MessageProduce;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RocketmqApplicationTests {

    @Autowired
    private MessageProduce messageProduce;

    @Autowired
    private RocketController rocketController;

    @Test
    void contextLoads() {
        messageProduce.sendMessage("rocket-topic-2","Hello Iam Rocket Message");
    }

    @Test
    void testSend(){
        rocketController.rocketSend();
    }

}
