package com.njwtframework.web.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


public class AuthHandler implements HandlerInterceptor {
	protected static Logger logger = LoggerFactory.getLogger(AuthHandler.class);
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        System.out.println(">>>AuthHandler>>>>>>>在请求处理之前进行调用（Controller方法调用之前）");
        String path = request.getContextPath();  
        String scheme = request.getScheme();  
        String serverName = request.getServerName();  
        int port = request.getServerPort();  
        String basePath = scheme + "://" + serverName + ":" + port + path;  
        request.setAttribute("rtx", basePath); 
        /**
        if (request.getCookies()==null) {  
            response.sendRedirect("/errorpage/404.jsp");  
            return false;  
        } 
        **/
        return true;// 只有返回true才会继续向下执行，返回false取消当前请求
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        System.out.println(">>>AuthHandler>>>>>>>请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）");
       
    }

    @Override 
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        System.out.println(">>>AuthHandler>>>>>>>在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）");
    }

}
