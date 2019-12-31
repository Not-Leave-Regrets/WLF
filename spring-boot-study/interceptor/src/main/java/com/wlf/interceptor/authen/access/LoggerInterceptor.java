package com.wlf.interceptor.authen.access;

import com.wlf.interceptor.entity.Log;
import com.wlf.interceptor.entity.User;
import com.wlf.interceptor.mapper.LogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.UUID;

public class LoggerInterceptor implements HandlerInterceptor {
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private LogMapper logMapper;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(! (handler instanceof  HandlerMethod)){
            return true;
        }
        // 将handler强转为HandlerMethod, 前面已经证实这个handler就是HandlerMethod
        HandlerMethod handlerMethod = (HandlerMethod) handler;

        // 从方法处理器中获取出要调用的方法
        Method method = handlerMethod.getMethod();
        // 获取出方法上的logger注解
        Logger logger = method.getAnnotation(Logger.class);
        if (logger == null) {
            // 如果注解为null, 说明不需要拦截, 直接放过
            return true;
        }
        String operations = logger.operations();
        Map<String, String[]> map = request.getParameterMap();
        String params="";
        if(map!=null){
            for(Map.Entry<String,String[]> entry :map.entrySet()){
                params+=entry.getKey()+":"+entry.getValue()[0];
            }
        }
        User user = (User) redisTemplate.opsForValue().get("users");
        if(user==null){
            return true;
        }
        String userId = user.getId();
        Log log = new Log(UUID.randomUUID().toString(),operations,userId,params);
        logMapper.insert(log);
        // 拦截之后应该返回公共结果, 这里没做处理
        return true;
    }

}
