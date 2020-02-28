package com.wlf.interceptor.config;

import com.wlf.interceptor.authen.access.AuthenticationInterceptor;
import com.wlf.interceptor.authen.access.LoggerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

 
@Configuration
public class MyWebAppConfigurer extends WebMvcConfigurerAdapter{
    @Bean
    public AuthenticationInterceptor authenticationInterceptor(){
        return new AuthenticationInterceptor();
    }
    @Bean
    public LoggerInterceptor loggerInterceptor(){
        return new LoggerInterceptor();
    }
    //配置各个拦截器需要拦截的路径
    //注册拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new MyInterceptor1()).addPathPatterns("/**");
//        registry.addInterceptor(new MyInterceptor2()).addPathPatterns("/**");
        registry.addInterceptor(authenticationInterceptor()).addPathPatterns("/**");
        registry.addInterceptor(loggerInterceptor()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }
}