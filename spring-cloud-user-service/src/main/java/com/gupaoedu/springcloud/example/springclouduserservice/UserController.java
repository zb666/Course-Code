package com.gupaoedu.springcloud.example.springclouduserservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpSession;

/**
 * 咕泡学院，只为更好的你
 * 咕泡学院-Mic: 2227324689
 * http://www.gupaoedu.com
 **/
@RestController
public class UserController {

    @Autowired
    RestTemplate restTemplate;

    @Value("${server.port}")
    private Integer port;

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/user")
    public String findById() {
        // 调用订单的服务获得订单信息
//        String invokeResult = restTemplate.getForObject("http://spring-cloud-order-service/orders", String.class);
        return "调用的结果是: ";
    }

    @GetMapping("/set")
    public String setValue(HttpSession httpSession){
        httpSession.setAttribute("name","GUPao@du.com");
        return port.toString();
    }

    @GetMapping("/get")
    public String getValue(HttpSession httpSession){
        Object forObject = restTemplate.getForObject("https://www.baidu.com/", Object.class);
        return httpSession.getAttribute("name")+": "+port;
    }

}
