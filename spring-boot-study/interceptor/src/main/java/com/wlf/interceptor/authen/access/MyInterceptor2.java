package com.wlf.interceptor.authen.access;


import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInterceptor2 implements HandlerInterceptor{

    @Override
    public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
            throws Exception {
        System.out.println("=====>(2)在整个请求之后调用，即在dispatcherServlet渲染了对应的视图之后（主要是进行资源清理工作）");
    }

    @Override
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
            throws Exception {
        System.out.println("=====>(2)在请求处理之后调用，即在controller方法执行之后调用");
    }

    @Override
    public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
        System.out.println("=====>（2）在请求处理之前调用，即在Controller方法调用之前！");
        return true;//只有返回true才会往下执行，返回FALSE的话就会取消当前请求
    }

}