package com.course.nacos.demo.conf;

import com.course.nacos.demo.DataSource;
import com.course.nacos.demo.Dog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import(DataSource.class)
@Configuration
public class NacosConfiguration {

    @Bean
    public Dog newDog(){
        return new Dog();
    }

}
