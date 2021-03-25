package com.gupaoedu.springcloud.example.interceptor;

import com.gupaoedu.springcloud.example.configadapter.WebMVcConfigureAdapter;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

//webmvc 拦截器
@Configuration
public class SessionConfiguration extends WebMVcConfigureAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new DemoInterceptor())
                .addPathPatterns("/goods/cart"); //对这个方法进行拦截
    }

}
