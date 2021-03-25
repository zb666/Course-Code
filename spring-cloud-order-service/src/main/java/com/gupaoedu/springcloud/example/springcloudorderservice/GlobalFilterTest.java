package com.gupaoedu.springcloud.example.springcloudorderservice;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

//全局和局部的过滤器: Global
@Component
public class GlobalFilterTest implements GlobalFilter, Ordered {

    private List<String> clientList = new ArrayList<>();

    {
        clientList.add("127.0.0.1");
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        ServerHttpRequest httpRequest = exchange.getRequest();

        ServerHttpResponse httpResponse = exchange.getResponse();
        //远程主机地址
        String clientIp = httpRequest.getRemoteAddress().getHostString();

        if(clientList.contains(clientIp)){
            httpResponse.setStatusCode(HttpStatus.UNAUTHORIZED);
            //输出响应
            DataBuffer wrap = httpResponse.bufferFactory().wrap("request ".getBytes());
            return httpResponse.writeWith(Mono.just(wrap));
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE;
    }

}
