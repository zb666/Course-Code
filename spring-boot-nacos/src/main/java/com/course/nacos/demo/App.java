package com.course.nacos.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

@Import(Dog.class)
public class App {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(App.class);
        Dog bean = context.getBeanFactory().getBean(Dog.class);
        System.out.println(bean.hashCode());
    }

}
