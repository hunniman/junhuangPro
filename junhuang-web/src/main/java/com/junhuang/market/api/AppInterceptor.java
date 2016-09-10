package com.junhuang.market.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by oyhk on 15/11/29.
 * 应用 检查 是否请求认证 的拦截器
 */
@Component
public class AppInterceptor extends HandlerInterceptorAdapter {


    @Autowired
    ObjectMapper objectMapper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        response.setContentType("application/json;charset=UTF-8");
        System.err.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        return super.preHandle(request, response, handler);
    }
}
