package com.itheima.fallback;

import com.itheima.service.FeignService;


//这里最好做成工厂
public class FeignApiFallBack implements FeignService {
    @Override
    public String hello() {
        return "服务调用失败";
    }
}
