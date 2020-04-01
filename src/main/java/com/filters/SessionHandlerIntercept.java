package com.filters;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 一杯咖啡
 */
//@Controller
public class SessionHandlerIntercept implements HandlerInterceptor {
    private static final Logger log = Logger.getLogger(SessionHandlerIntercept.class);

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String loginUser = (String) httpServletRequest.getSession().getAttribute("loginUser");
        if (loginUser == null || loginUser.equals("")) {
            httpServletResponse.sendRedirect("/index");
            return false;
        }
        log.info(loginUser);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {

    }
}
