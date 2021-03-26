package com.itheima.service;

import com.itheima.config.FeignConfig;
import com.itheima.fallback.FeignApiFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//该服务由 eureka-provider微服务提供
@FeignClient(name = "eureka-provider",
//        url = "http://localhost:7006",
        configuration = FeignConfig.class,
        fallback = FeignApiFallBack.class)
public interface FeignService {

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    String hello();

}
