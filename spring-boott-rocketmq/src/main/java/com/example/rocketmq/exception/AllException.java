package com.example.rocketmq.exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@ControllerAdvice
public class AllException {
    @ExceptionHandler(Exception.class)
    public void exception(Exception e, HttpServletResponse response) throws IOException {
        response.setContentType ("text/html;charset=utf-8");
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode root = mapper.createObjectNode();//创建一个根对象
        root.put("code", 900);
        root.put("msg", e.getMessage());
        root.put("level", "应用级异常");
        PrintWriter out = response.getWriter();
        out.write(root.toString());
        out.flush();
        out.close();
    }
}
