package com.zzuli.library.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *  登录拦截器进行登录校验.
 * @author hejjon
 * @date 2019/8/25 7:12
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        // 获取uri
        String uri = request.getRequestURI();
        if ("/login.html".equals(uri)) {
            return true;
        } else {
            Object flag = request.getSession().getAttribute("logged_in");
            if (flag != null) {
                return true;
            } else {
                request.getRequestDispatcher("/WEB-INF/page/404.jsp").forward(request, response);
                return false;
            }
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
