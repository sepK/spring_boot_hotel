package com.ecjtu.kongtao.utils;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author sepK
 */
@WebFilter(filterName = "LoginFilter",urlPatterns = "/templates/*")
public class LoginFilter implements Filter {
    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        if(request.getSession().getAttribute("loginUser") != null){
            chain.doFilter(req, resp);
        }
    }

    @Override
    public void init(FilterConfig config) throws ServletException {

    }

}
