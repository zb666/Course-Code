package com.gupaoedu.springcloud.example.springcloudorderservice;

import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 咕泡学院，只为更好的你
 * 咕泡学院-Mic: 2227324689
 * http://www.gupaoedu.com
 **/
@RestController
public class OrderService {

    @Value("${server.port}")
    private int port;

    @Autowired
    private UserBean userBean;

    @Autowired
    private RestTemplate restTemplate;

    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    @GetMapping("/orders")
    public String getAllOrder(HttpServletRequest httpServletRequest){
        HttpSession session = httpServletRequest.getSession();
        System.out.println("port:"+port+" Session: "+session.toString());
        Object forObject = restTemplate.getForObject("https://www.baidu.com/", Object.class);
        return "Return All Order "+userBean.getPort();
    }

}
