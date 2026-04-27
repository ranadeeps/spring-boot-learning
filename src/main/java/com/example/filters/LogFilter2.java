package com.example.filters;

import jakarta.servlet.*;
import org.springframework.boot.web.servlet.FilterRegistration;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@FilterRegistration(urlPatterns = {"/*"})
public class LogFilter2 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("LogFilter2"+servletRequest.getAttribute("name"));
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
