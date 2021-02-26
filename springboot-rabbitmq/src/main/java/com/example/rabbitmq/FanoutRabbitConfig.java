package com.example.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FanoutRabbitConfig {

    public static final String FANOUT_EXCHANGKEY = "fanoutExchange";

    @Bean
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange(FANOUT_EXCHANGKEY);
    }

    @Bean
    Queue queue1(){
        return new Queue("fanout1");
    }

    @Bean
    Queue queue2(){
        return new Queue("fanout2");
    }

    @Bean
    public Binding bindingExchange1(Queue queue1,FanoutExchange fanoutExchange){
        return BindingBuilder.bind(queue1).to(fanoutExchange); //这里就相当于跳过了 Routingkey的设置
    }

    @Bean
    public Binding bindingExchange2(Queue queue2,FanoutExchange fanoutExchange){
        return BindingBuilder.bind(queue2).to(fanoutExchange);
    }

}
