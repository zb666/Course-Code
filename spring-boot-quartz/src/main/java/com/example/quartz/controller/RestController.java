package com.example.quartz.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

@Api(value = "测试Swagger文档")
@Service
public class RestController {
    //com.example.quartz.controller.RestController

    @ApiOperation(value = "消息生成接口")
    @ApiImplicitParams(
            @ApiImplicitParam(
                    name = "message",
                    value = "消息内容",
                    required = true,
                    dataTypeClass = String.class,
                    paramType = "String"
            )
    )
    public String getValue(String message) {
        return "value";
    }

}
