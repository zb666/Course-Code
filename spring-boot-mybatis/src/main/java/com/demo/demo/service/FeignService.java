package com.demo.demo.service;

import com.demo.demo.fallback.HellobackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Service
@FeignClient(value = "feign-service",fallbackFactory = HellobackFactory.class)
public interface FeignService {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    String sayHello();

}
