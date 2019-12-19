package com.wlf.interceptor.authen.access;


import com.wlf.interceptor.entity.Role;
import com.wlf.interceptor.entity.User;
import com.wlf.interceptor.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;


// 自定义一个权限拦截器, 继承HandlerInterceptorAdapter类
public class AuthenticationInterceptor implements HandlerInterceptor {
 @Autowired
 UserService userService;
    // 在调用方法之前执行拦截
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
       if(! (handler instanceof  HandlerMethod)){
           return true;
       }
        // 将handler强转为HandlerMethod, 前面已经证实这个handler就是HandlerMethod
        HandlerMethod handlerMethod = (HandlerMethod) handler;

        // 从方法处理器中获取出要调用的方法
        Method method = handlerMethod.getMethod();
        // 获取出方法上的Access注解
        Access access = method.getAnnotation(Access.class);
        if (access == null) {
            // 如果注解为null, 说明不需要拦截, 直接放过
           return true;
       }
        if (access.authorities().length > 0) {
            // 如果权限配置不为空, 则取出配置值
           String[] authorities = access.authorities();
           Set<String> authSet = new HashSet<>();
           for (String authority : authorities) {
               // 将权限加入一个set集合中
               authSet.add(authority);
           }
           // 这里我为了方便是直接参数传入权限, 在实际操作中应该是从参数中获取用户Id
           // 到数据库权限表中查询用户拥有的权限集合, 与set集合中的权限进行对比完成权限校验
           String  id = request.getParameter("id");
            User user = userService.querybyname(id);
            if(user==null)
            {
                throw new RuntimeException("你还未注册账号");
            }
            Role role =user.getRoles();
            if(role ==null)
            {
                throw new RuntimeException("你没有权限访问");
            }
            if(authSet.contains(role.getRoleName())){
                return true;
            }
           throw new RuntimeException("你的操作权限不足");
        }
        // 拦截之后应该返回公共结果, 这里没做处理
        return false;
    }
 
}