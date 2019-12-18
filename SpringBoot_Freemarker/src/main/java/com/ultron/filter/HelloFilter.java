package com.ultron.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author pixel
 */
public class HelloFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }
 
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("HelloFilter："+servletRequest.getLocalAddr());
        System.out.println("HelloFilter："+servletRequest.getLocalPort());
    }

    @Override
    public void destroy() {
 
    }
}