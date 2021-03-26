package com.demo.demo.fallback;

import com.demo.demo.service.FeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class HellobackFactory implements FallbackFactory<FeignService> {
    @Override
    public FeignService create(Throwable cause) {
        return new FeignService() {
            @Override
            public String sayHello() {
                log.error("Feign 调用失败: " + cause.toString());
                return "调用失败: " + cause.toString();
            }
        };
    }
}
