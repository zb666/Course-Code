package com.gupaoedu.springcloud.example.configadapter;

import com.gupaoedu.springcloud.example.interceptor.DemoInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMVcConfigureAdapter implements WebMvcConfigurer {

    @Bean
    public DemoInterceptor demoInterceptor() {
        return new DemoInterceptor();
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(demoInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/*.html");
    }
}
