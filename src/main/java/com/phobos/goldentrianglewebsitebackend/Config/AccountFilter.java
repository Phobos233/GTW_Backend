package com.phobos.goldentrianglewebsitebackend.Config;

import com.phobos.goldentrianglewebsitebackend.utils.JWTUtils;
import com.phobos.goldentrianglewebsitebackend.utils.ResultAPI;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter(urlPatterns = "/*")
public class AccountFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String requestURI = request.getRequestURI();
        if (requestURI.contains("/login")) {
            System.out.println("登录请求，放行");
            filterChain.doFilter(request, response);
            return;
        }
        String token = request.getHeader("token");
        if (token == null || token.isEmpty()) {
            System.out.println("未登录");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }
        try {
            JWTUtils.parseToken(token);
        } catch (Exception e) {
            System.out.println("token无效");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }
        filterChain.doFilter(request,response);
        return ;
    }
}
