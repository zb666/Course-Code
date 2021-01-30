package com.gupaoedu.springcloud.example.springclouduserservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.netflix.ribbon.RibbonLoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 咕泡学院，只为更好的你
 * 咕泡学院-Mic: 2227324689
 * http://www.gupaoedu.com
 **/
@RestController
public class OpenFeignController {

    @Autowired
    private OrderServiceFeignClient orderServiceFeignClient;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/test")
    public String test(){
        return orderServiceFeignClient.getAllOrder();
    }

    @GetMapping("/ribbon/get2")
    public String get2(){
        return orderServiceFeignClient.getAllOrder();
    }

}
