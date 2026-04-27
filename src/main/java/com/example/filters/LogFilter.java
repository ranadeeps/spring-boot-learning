package com.example.filters;

import jakarta.servlet.*;
import org.springframework.boot.web.servlet.FilterRegistration;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@FilterRegistration(urlPatterns = {"/*"})
public class LogFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("LogFilter"+servletRequest.getRemoteAddr());
        servletRequest.setAttribute("name","ranadeep");
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
