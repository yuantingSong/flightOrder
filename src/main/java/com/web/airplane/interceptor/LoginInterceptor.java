package com.web.airplane.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.web.airplane.pojo.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

public class LoginInterceptor implements HandlerInterceptor {
	
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {

        String requestUri = request.getRequestURI();
        String method = request.getMethod();
        String url = request.getContextPath();
        
        if (requestUri.indexOf("/login") >= 0) {
            return true;
        }
        if (requestUri.indexOf("/signup") >= 0) {
            return true;
        }
        
        User user =  (User) request.getSession().getAttribute("user");
        if(user == null){
        	request.getRequestDispatcher("/user/login").forward(request, response);
        }
        return true;
    }
	
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o, ModelAndView modelAndView) throws Exception {

    }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) throws Exception {
        
    }
}
