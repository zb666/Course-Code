package com.example.kafka.interceptor;

import org.apache.kafka.clients.producer.ProducerInterceptor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class TestInterceptor implements ProducerInterceptor<String,String> {


    Logger logger = LoggerFactory.getLogger(TestInterceptor.class);

    @Override
    public ProducerRecord<String, String> onSend(ProducerRecord<String, String> record) {
        return null;
    }

    @Override
    public void onAcknowledgement(RecordMetadata metadata, Exception exception) {
        System.out.println("消息被服务端接收了");
    }

    @Override
    public void close() {
        logger.info("生产者关闭了");
    }

    @Override
    public void configure(Map<String, ?> configs) {

    }
}
