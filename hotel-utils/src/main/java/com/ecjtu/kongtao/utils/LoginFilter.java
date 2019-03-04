package com.ecjtu.kongtao.utils;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author sepK
 */
@Component("loginFilter")
public class LoginFilter implements Filter {

    /**不过滤的uri*/
    private static String[] notFilter = new String[] {
            "/login",
            "/assets",
            "/adminLogin",
            "/static",
            "/app",
            "/js",
            "/css",
            "/images",
            "/user/verifyCode",
    };
    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response =(HttpServletResponse)res;
        HttpSession session = request.getSession();
        String uri = request.getRequestURI().trim();
        boolean doFilter = true;
        for (String s : notFilter) {
            if(uri.contains(s)){
                doFilter = false;
                break;
            }
        }
        if (doFilter) {
            if(request.getSession().getAttribute(SessionKey.USER) != null){
                chain.doFilter(req, res);
                return;
            }
            response.sendRedirect("/login");
            return;
        }
        chain.doFilter(req, res);
    }

    @Override
    public void init(FilterConfig config) throws ServletException {

    }

}
