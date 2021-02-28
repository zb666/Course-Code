package com.example.kafka;

import com.example.kafka.producer.KafkaProducer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaOperations;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootTest
class KafkaApplicationTests {

    @Autowired
    private KafkaTemplate<String,Object> kafkaTemplate;

    @Autowired
    private KafkaProducer producer;

    // 消费者：先启动 kafkaApp
    //  Must set acks to all in order to use the idempotent producer.
    @Test
    void executeInTransaction() {
        long time = System.currentTimeMillis();
        producer.send("msg 消息");
    }

}
