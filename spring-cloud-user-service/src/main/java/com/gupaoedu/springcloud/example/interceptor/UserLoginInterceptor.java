package com.gupaoedu.springcloud.example.interceptor;

import org.apache.http.util.TextUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserLoginInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        String userAccount = (String) session.getAttribute("uaccount");
        if (TextUtils.isEmpty(userAccount)) {
            return false;
        }
        return true;
    }
}
