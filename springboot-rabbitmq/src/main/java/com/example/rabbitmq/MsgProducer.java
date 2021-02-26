package com.example.rabbitmq;

import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MsgProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 通过Routing_Key发送消息到交换机
     *
     * @param content
     */
    public void sendMsg(String content) {
        //绑定到直连类型的交换机上
        CorrelationData correlationData = new CorrelationData("123456");
        rabbitTemplate.convertAndSend(
                RabbitConfig.EXCHANGE_A,
                RabbitConfig.ROUTING_KEY_A, //Queue从
                "消息content",
                correlationData
        );
    }

    public void sendTopicMsg() {
        CorrelationData correlationData = new CorrelationData("123456");
        rabbitTemplate.convertAndSend(
                "topicExchange",
                "topic.messages.keyTest", //Queue从
                "主题信息",
                correlationData
        );
    }

    public void sendFanoutMsg() {
        //这里就相当于跳过了BindingKey的设置
        CorrelationData correlationData = new CorrelationData("123456");
        rabbitTemplate.convertAndSend(FanoutRabbitConfig.FANOUT_EXCHANGKEY,"","广播类型消息，忽略路由Key和BindingKey");
    }

}
