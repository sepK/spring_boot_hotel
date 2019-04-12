package com.ecjtu.kongtao.filter;

import com.ecjtu.kongtao.utils.SessionKey;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author sepK
 */
@Component("FunctionFilter")
public class FunctionFilter implements Filter {

    private static Logger log = org.slf4j.LoggerFactory.getLogger(FunctionFilter.class);

    /**
     * 不过滤的uri
     */
    private static String[] notFilter = new String[]{
            "/login",
            "/assets",
            "/adminLogin",
            "/static",
            "/app",
            "/js",
            "/css",
            "/images",
            "/user/verifyCode",
            "/room/emptyRooms",
            "/order/addIndent/",
            "/order/getIndents",
            "/order/updateIndent",
            "/user/checkVerifyCode",
            "/room/rooms",
            "/alipay",
            "/user/logout"
    };

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        HttpSession session = request.getSession();
        String uri = request.getRequestURI().trim();
        boolean doFilter = true;
        for (String s : notFilter) {
            if (uri.contains(s)) {
                doFilter = false;
                break;
            }
        }
        if (doFilter) {
            if (request.getSession().getAttribute(SessionKey.ADMIN_USER) != null) {
                chain.doFilter(req, res);
                return;
            }
            response.sendRedirect("/login");
            return;
        }
        long in = System.currentTimeMillis();
        //log.info(uri + " in " + in);
        chain.doFilter(request, response);
        //log.info(uri + " out " + (System.currentTimeMillis() - in));

    }

    @Override
    public void init(FilterConfig config) throws ServletException {

    }

}
