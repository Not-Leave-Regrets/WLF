package com.wlf.interceptor.web;

import com.wlf.interceptor.authen.access.Access;
import com.wlf.interceptor.authen.access.Logger9;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api("权限验证")
public class HelloController {
 
    @RequestMapping(value = "/admin", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.GET)
    // 配置注解权限, 允许身份为admin, 或者说允许权限为admin的人访问
    @Access(authorities = {"admin"})
    @ApiOperation("测试拦截器")
    public String hello() {
        return "Hello, admin";
    }
    @Access(authorities = {"管理员"})
    @GetMapping("/authen")
    @ApiOperation("验证管理员才能访问")
    @Logger9(operations = "测试logger")
    public String authenId(String id ){
        return "success";
    }
}