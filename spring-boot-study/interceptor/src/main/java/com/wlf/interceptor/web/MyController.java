package com.wlf.interceptor.web;

import com.wlf.interceptor.authen.access.Logger9;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
 
@RestController
public class MyController {
    
    @GetMapping("/index")
    @Logger9(operations = "测试logger")
    public String index(){
        return "hello!";
    }
    
}