package com.example.kafka.producer;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.header.Header;
import org.apache.kafka.common.header.internals.RecordHeader;
import org.apache.kafka.common.serialization.IntegerSerializer;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KafkaProducerTest {


    public static void main(String[] args) {

        Map<String, Object> configs = new HashMap<>();
        // 指定初始连接用到的broker地址
        configs.put("bootstrap.servers", "47.98.181.113:9092");
        // 指定key的序列化类
        configs.put("key.serializer", IntegerSerializer.class);
        // 指定value的序列化类
        configs.put("value.serializer", StringSerializer.class);
        List<Header> headers = new ArrayList<>();
        headers.add(new RecordHeader("biz.name", "producer.demo".getBytes()));
        KafkaProducer<Integer,String> kafkaProducer = new KafkaProducer<Integer, String>(configs);
        ProducerRecord<Integer,String> producerRecord = new ProducerRecord<Integer, String>(
                "topic_2",
                0,
                0,
                "hello lagou",
                headers
        );

        kafkaProducer.send(producerRecord, new Callback() {
            @Override
            public void onCompletion(RecordMetadata metadata, Exception exception) {
                String topic = metadata.topic(); //主题
                int partition = metadata.partition(); //分区
                //segment 偏移量
                long offset = metadata.offset();
                System.out.printf("主题 分区 "+topic+" partition "+partition +" 偏移量 "+offset);
            }
        });

        kafkaProducer.close();

    }

}
